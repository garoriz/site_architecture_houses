package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.model.User;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("registration.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmedPassword");
        if ((userService.get(login) != null) || login.length() < 8 || name.trim().equals("")) {
            resp.sendRedirect("/registration");
        } else if (password.length() > 7 && password.equals(confirmedPassword)) {
            userService.save(createUser(name, surname, login, password));
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setMaxInactiveInterval(60 * 60);

            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/registration");
        }
    }

    private User createUser(String name, String surname, String login, String password) {
        return new User(name, surname, " ",
                "<img src=https://res.cloudinary.com/dfn48aqa5/image/upload/v1634988875/fb_avatar_ipvpno.jpg " +
                        "width=\"100\" height=\"111\">",
                login, password);
    }
}
