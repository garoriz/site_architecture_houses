package ru.kpfu.itis.garipov.servlet;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet(name = "settingsServlet", urlPatterns = "/settings")
public class SettingsServlet extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        if (sessionUser == null) {
            resp.sendRedirect("/login");
        } else {
            req.getRequestDispatcher("settings.ftl").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String status = req.getParameter("status");
        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmedPassword");
        if (!name.equals("")) {
            userService.changeName(sessionUser, name);
        }
        if (!surname.equals("")) {
            userService.changeSurname(sessionUser, surname);
        }
        if (!login.equals("")) {
            userService.changeLogin(sessionUser, login);
            session.removeAttribute("login");
            session.setAttribute("login", login);
            sessionUser = (String) session.getAttribute("login");
        }
        if (!status.equals("")) {
            userService.changeStatus(sessionUser, status);
        }
        if (!password.equals("") | !confirmedPassword.equals("")) {
            if (password.equals(confirmedPassword)) {
                userService.changePassword(sessionUser, password);
            }
        }
        resp.sendRedirect("/settings");
    }
}
