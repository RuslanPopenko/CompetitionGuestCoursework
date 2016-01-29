package controller;

import dao.CompetitionDao;
import entity.Competition;
import factoryDao.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Сервлет для взаэмодії зі сторінкою /competition.jsp
 * @author Руслан Попенко
 * @version 1.0
 * @since 2015-04-14
 */
@WebServlet("/CompetServlet")
public class CompetServlet extends HttpServlet {

    /**
     * Повертає з бази даних таблицю Змагання
     * пересилає її на /competition.jsp
     * @param request запит
     * @param response відповідь
     * @throws ServletException необхідне виключення
     * @throws IOException необхідне виключення
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Factory factory = Factory.getInstance();
        CompetitionDao competitionDao = factory.getCompetitionDao();

        List<Competition> compList = null;
        try {
            compList = competitionDao.getCompetitions();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("ListOfComp", compList);
        request.getRequestDispatcher("/competition.jsp").forward(request, response);
    }

}
