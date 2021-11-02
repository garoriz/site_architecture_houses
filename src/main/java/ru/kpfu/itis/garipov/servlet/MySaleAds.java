package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.dto.SaleAdDTO;
import ru.kpfu.itis.garipov.dto.UserDTO;
import ru.kpfu.itis.garipov.service.impl.SaleAdServiceImpl;
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

@WebServlet(name = "listMySaleAdsServlet", urlPatterns = "/mySaleAds")
public class MySaleAds extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();
    SaleAdServiceImpl saleAdService = new SaleAdServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        UserDTO user = userService.get(sessionUser);

        List<SaleAdDTO> saleAdsDTO = saleAdService.getAllById(user.getId());
        Collections.reverse(saleAdsDTO);
        req.setAttribute("saleAds", saleAdsDTO);
        req.getRequestDispatcher("my_sale_ads.ftl").forward(req, resp);
    }
}
