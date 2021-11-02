package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.dto.PhotoDTO;
import ru.kpfu.itis.garipov.dto.UserDTO;
import ru.kpfu.itis.garipov.service.impl.PhotoServiceImpl;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "listMyPhotosServlet", urlPatterns = "/myPhotos")
public class MyPhotosServlet extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();
    PhotoServiceImpl photoService = new PhotoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        UserDTO user = userService.get(sessionUser);

        List<PhotoDTO> photosDTO = photoService.getAllById(user.getId());
        Collections.reverse(photosDTO);
        req.setAttribute("photos", photosDTO);
        req.getRequestDispatcher("my_photos.ftl").forward(req, resp);
    }
}
