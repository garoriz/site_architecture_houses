package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "settingsServlet", urlPatterns = "/settings")
public class SettingsServlet extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("settings.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String status = req.getParameter("status");
        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmedPassword");
        if (password.equals(confirmedPassword)) {
            //userService.save(createUser(name, surname, login, password));
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setMaxInactiveInterval(60 * 60);

            resp.sendRedirect("/profile");
        } else {
            resp.sendRedirect("/registration");
        }
    }
}
