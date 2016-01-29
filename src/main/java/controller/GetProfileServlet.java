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
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Сервлет для взаэмодії зі сторінкою /profile.jsp
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
@WebServlet("/GetProfileServlet")
public class GetProfileServlet extends HttpServlet {
    /**
     * Виймає профіль з бази даних і відправляє на /profile.jsp
     * @param request запит
     * @param response відповідь
     * @throws ServletException необхідне виключення
     * @throws IOException необхідне виключення
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usN = request.getParameter("userName").toString();
        request.setAttribute("usN", usN);
        Factory factory=Factory.getInstance();

        AppForParticipDao appForParticipDao=factory.getAppForParticipDao();

        AppForParticip ap=new AppForParticip();

        int n=Integer.parseInt(usN);
        try {
            ap=appForParticipDao.getAppForParticip(n);
        } catch (SQLException e) {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        if (ap==null){
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        Timestamp date=ap.getDate();

        request.setAttribute("TimeOfApp", date.toLocaleString());

        if(ap.getResult()) {
            request.setAttribute("result", "\u0417\u0430\u0442\u0432\u0435\u0440\u0434\u0436\u0435\u043d\u043e");
        } else {
            request.setAttribute("result", "\u041d\u0435 \u0437\u0430\u0442\u0432\u0435\u0440\u0434\u0436\u0435\u043d\u043e");
        }

        String compId=ap.getCompetition().getId()+"";
        String compDate=ap.getCompetition().getDate().toLocaleString();
        String compPlace=ap.getCompetition().getPlace();

        request.setAttribute("compId", compId);
        request.setAttribute("compDate", compDate);
        request.setAttribute("compPlace", compPlace);

        Profile profile=ap.getProfile();
        String name=profile.getName();
        String photo=profile.getPhoto();
        String eMail=profile.geteMail();
        String contacts=profile.getContacts();

        request.setAttribute("name", name);
        request.setAttribute("photo", photo);
        request.setAttribute("eMail", eMail);
        request.setAttribute("contacts", contacts);

        String category=ap.getCategory().getCateg();
        if (category.equals("guest")){
            request.setAttribute("category", category);
            request.getRequestDispatcher("/profile.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }


    }





}
