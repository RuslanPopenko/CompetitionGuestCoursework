package controller;

import dao.AppForParticipDao;
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

/**
 * Сервлет для взаэмодії зі сторінками /index.jsp, /profile.jsp
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
@WebServlet("/DeleteAppForServlet")
public class DeleteAppForServlet extends HttpServlet {

    /**
     * Видаляє профіль за бази даних, отриманий з /profile.jsp
     * і напрявляє на /index.jsp
     * @param request запит
     * @param response відповідь
     * @throws ServletException необхідне виключення
     * @throws IOException необхідне виключення
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Factory factory=Factory.getInstance();
        AppForParticipDao appForParticipDao=factory.getAppForParticipDao();
        ProfileDao profileDao = factory.getProfileDao();
        String str=request.getParameter("deleted").toString();
        AppForParticip appForParticip=new AppForParticip();

        try {
            appForParticip=appForParticipDao.getAppForParticip(Integer.parseInt(str));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Profile profile=appForParticip.getProfile();
        try {
            appForParticipDao.deleteAppForParticip(appForParticip);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            profileDao.deleteProfile(profile);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Deleted');");
        out.println("location='index.jsp';");
        out.println("</script>");

    }

}
