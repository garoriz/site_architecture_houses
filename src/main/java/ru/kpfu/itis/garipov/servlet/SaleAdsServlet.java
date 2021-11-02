package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.dto.SaleAdDTO;
import ru.kpfu.itis.garipov.service.impl.SaleAdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "listSaleAdsServlet", urlPatterns = "/saleAds")
public class SaleAdsServlet extends HttpServlet {

    SaleAdServiceImpl saleAdService = new SaleAdServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SaleAdDTO> saleAdsDTO = saleAdService.getAll();
        Collections.reverse(saleAdsDTO);
        req.setAttribute("saleAds", saleAdsDTO);
        req.getRequestDispatcher("sale_ads.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = "";
        int maxPrice = Integer.MAX_VALUE;
        if (req.getParameter("searchName") != null) {
            searchName = req.getParameter("searchName");
        }
        if (!req.getParameter("maxPrice").equals("")) {
            maxPrice = Integer.parseInt(req.getParameter("maxPrice"));
        }
        List<SaleAdDTO> saleAdsDTO = saleAdService.getAllByNameAndPice(searchName, maxPrice);
        Collections.reverse(saleAdsDTO);
        req.setAttribute("saleAds", saleAdsDTO);
        req.getRequestDispatcher("sale_ads.ftl").forward(req, resp);
    }
}
