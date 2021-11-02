package ru.kpfu.itis.garipov.servlet;


import ru.kpfu.itis.garipov.dto.PhotoDTO;
import ru.kpfu.itis.garipov.dto.UserDTO;
import ru.kpfu.itis.garipov.service.impl.PhotoServiceImpl;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "listPhotosServlet", urlPatterns = "/photos")
public class PhotosServlet extends HttpServlet {

    PhotoServiceImpl photoService = new PhotoServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PhotoDTO> photosDTO = photoService.getAll();
        Collections.reverse(photosDTO);
        LinkedHashMap<PhotoDTO, UserDTO> linkedHashMap = new LinkedHashMap<>();
        for (PhotoDTO photoDTO : photosDTO) {
            linkedHashMap.put(photoDTO, userService.get(photoDTO.getUserId()));
        }
        req.setAttribute("linkedHashMap", linkedHashMap);
        req.getRequestDispatcher("photos.ftl").forward(req, resp);
    }
}
