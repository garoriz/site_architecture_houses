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
        String urlParam = req.getParameter("login");
        if (urlParam == null && sessionUser != null) {
            UserDTO user = userService.get(sessionUser);
            req.setAttribute("user", user);
            req.getRequestDispatcher("profile.ftl").forward(req, resp);
        } else if (sessionUser != null && sessionUser.equals(urlParam)) {
            UserDTO user = userService.get(sessionUser);
            req.setAttribute("user", user);
            req.getRequestDispatcher("profile.ftl").forward(req, resp);
        } else if (sessionUser != null && !sessionUser.equals(urlParam)) {
            UserDTO user = userService.get(urlParam);
            req.setAttribute("user", user);
            req.getRequestDispatcher("other_user_profile.ftl").forward(req, resp);
        } else if (urlParam != null && userService.get(urlParam) != null) {
            UserDTO user = userService.get(urlParam);
            req.setAttribute("user", user);
            session.invalidate();
            req.getRequestDispatcher("other_user_profile.ftl").forward(req, resp);
        } else if (urlParam == null) {
            session.invalidate();
            resp.sendRedirect("/login");
        }
    }
}
