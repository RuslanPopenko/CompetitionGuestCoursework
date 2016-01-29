package controller;

import dao.AppForParticipDao;
import dao.CategoryDao;
import dao.ProfileDao;
import entity.AppForParticip;
import entity.Category;
import entity.Profile;
import factoryDao.Factory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Сервлет для взаэмодії зі сторінкою /profile.jsp
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
@WebServlet("/TransitionServlet")
public class TransitionServlet extends HttpServlet {
    /**
     * Поле ідентиіфікатор заявки
     */
    private static int n;

    /**
     * Геттер для ідентиіфікатора заявки
     * @return ідентиіфікатор заявки
     */
    public static int getNumberOfApp (){
        return n;
    }

    /**
     * Здійснює перехід з гостя до іншої категорії
     * @param request запит
     * @param response відповідь
     * @throws ServletException необхідне виключення
     * @throws IOException необхідне виключення
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Factory factory=Factory.getInstance();
        AppForParticipDao appForParticipDao=factory.getAppForParticipDao();
        ProfileDao profileDao = factory.getProfileDao();
        CategoryDao categoryDao=factory.getCategoryDao();
        String str=request.getParameter("numberOfApp").toString();
        n=Integer.parseInt(str);
        AppForParticip appForParticip=new AppForParticip();
        Category category=new Category();

        try {
            appForParticip=appForParticipDao.getAppForParticip(Integer.parseInt(str));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Profile profile=appForParticip.getProfile();

        String selectedValue=request.getParameter("catOptions");
        if(selectedValue.equals("1"))
        {
            try {
                category=categoryDao.getCategory(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            appForParticip.setCategory(category);
            profile.setCategory(category);
            try {
                appForParticipDao.updateAppForParticip(appForParticip);
                profileDao.updateProfile(profile);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if(selectedValue.equals("2"))
        {
            try {
                category=categoryDao.getCategory(2);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            appForParticip.setCategory(category);
            profile.setCategory(category);
            try {
                appForParticipDao.updateAppForParticip(appForParticip);
                profileDao.updateProfile(profile);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(selectedValue.equals("4"))
        {
            try {
                category=categoryDao.getCategory(4);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            appForParticip.setCategory(category);
            profile.setCategory(category);
            try {
                appForParticipDao.updateAppForParticip(appForParticip);
                profileDao.updateProfile(profile);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Category changed');");
        out.println("location='index.jsp';");
        out.println("</script>");

    }

}
