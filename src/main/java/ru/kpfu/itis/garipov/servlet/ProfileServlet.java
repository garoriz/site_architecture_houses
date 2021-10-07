package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    private static final UserDTO USER = new UserDTO(1, "Ризван", "Гарипов", "Ничто не вечно");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", USER);
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }
}
