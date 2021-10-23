package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.helper.PasswordHelper;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userService.get(login) == null) {
            resp.sendRedirect("/login");
        } else if (userService.get(login).getPassword().equals(PasswordHelper.encrypt(password))) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setMaxInactiveInterval(60 * 60);

            resp.sendRedirect("/profile");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
