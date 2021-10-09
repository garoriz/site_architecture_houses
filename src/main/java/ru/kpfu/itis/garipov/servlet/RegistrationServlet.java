package ru.kpfu.itis.garipov.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("registration.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmedPassword");
        if (password.equals(confirmedPassword)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", login);
            session.setMaxInactiveInterval(60 * 60);

            Cookie userCookie = new Cookie("username", login);
            userCookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(userCookie);

            resp.sendRedirect("/profile");
        } else {
            resp.sendRedirect("/registration");
        }
    }
}
