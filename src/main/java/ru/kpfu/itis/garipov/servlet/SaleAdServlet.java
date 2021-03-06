package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.dto.SaleAdDTO;
import ru.kpfu.itis.garipov.dto.UserDTO;
import ru.kpfu.itis.garipov.service.impl.ArticleServiceImpl;
import ru.kpfu.itis.garipov.service.impl.SaleAdServiceImpl;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "saleAdServlet", urlPatterns = "/saleAd")
public class SaleAdServlet extends HttpServlet {

    SaleAdServiceImpl saleAdService = new SaleAdServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        SaleAdDTO saleAdDTO = saleAdService.get(Integer.parseInt(id));
        UserDTO userDTO = userService.get(saleAdDTO.getUserId());
        req.setAttribute("author" ,userDTO);
        req.setAttribute("saleAd", saleAdDTO);
        req.getRequestDispatcher("sale_ad.ftl").forward(req, resp);
    }
}
