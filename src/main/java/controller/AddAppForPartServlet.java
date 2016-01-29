package controller;

import dao.AppForParticipDao;
import dao.CategoryDao;
import dao.CompetitionDao;
import dao.ProfileDao;
import entity.AppForParticip;
import entity.Profile;
import factoryDao.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Сервлет для взаэмодії зі сторінками /registr.jsp, /registred.jsp
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
@WebServlet("/AppForPartServlet")
public class AddAppForPartServlet extends HttpServlet {

    /**
     * Отримаємо дані про профіль з /registr.jsp,
     * заносимо профіль і заявку в базу даних,
     * і пересилаємо результат реєстрації на /registred.jsp
     * @param request запит
     * @param response відповідь
     * @throws ServletException необхідне виключення
     * @throws IOException необхідне виключення
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Factory factory=Factory.getInstance();
        ProfileDao profileDao = factory.getProfileDao();
        CategoryDao categoryDao=factory.getCategoryDao();
        CompetitionDao competitionDao=factory.getCompetitionDao();
        AppForParticipDao appForParticipDao=factory.getAppForParticipDao();

        String name=request.getParameter("name");
        String photo="photo";
        String eMail=request.getParameter("eMail");
        String contact=request.getParameter("contact");
        Profile profile=new Profile();
        try {
            profile.setCategory(categoryDao.getCategory(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        profile.setName(name);
        profile.setPhoto(photo);
        profile.seteMail(eMail);
        profile.setContacts(contact);

        try {
            profileDao.addProfile(profile);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String number=request.getParameter("num");
        int num=Integer.parseInt(number);



        AppForParticip appForParticip=new AppForParticip();

        try {
            appForParticip.setCategory(categoryDao.getCategory(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        appForParticip.setProfile(profile);
        try {
            appForParticip.setCompetition(competitionDao.getCompetition(num));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        java.util.Date date= new java.util.Date();
        Timestamp current=new Timestamp(date.getTime());
        appForParticip.setDate(current);
        appForParticip.setResult(false);

        try {
            appForParticipDao.addAppForParticip(appForParticip);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("id", ""+appForParticipDao.getIdentif());
        request.getRequestDispatcher("/registred.jsp").forward(request, response);


    }


}
