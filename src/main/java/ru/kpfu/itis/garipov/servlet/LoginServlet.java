package ru.kpfu.itis.garipov.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (LOGIN.equals(login) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", login);
            session.setMaxInactiveInterval(60 * 60);

            Cookie userCookie = new Cookie("username", login);
            userCookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(userCookie);

            resp.sendRedirect("registration.html");
        } else {
            resp.sendRedirect("/login");
        }

    }
}
