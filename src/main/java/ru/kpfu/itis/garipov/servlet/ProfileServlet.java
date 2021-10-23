package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.UserDTO;
import ru.kpfu.itis.garipov.model.User;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        if (sessionUser == null) {
            resp.sendRedirect("/login");
        }

        UserDTO user = userService.get(sessionUser);
        req.setAttribute("user", user);
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }
}
