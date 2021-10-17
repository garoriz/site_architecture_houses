package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.SaleAdDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "saleAdServlet", urlPatterns = "/saleAd")
public class SaleAdServlet extends HttpServlet {

    private static final SaleAdDTO SALE_AD = new SaleAdDTO(1, "Продам гараж", "Купите" +
            ", пожалуйста, гараж!!!! СРОЧНО", 100, "8999 999 99 99", "1.1.1900 00:00");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("saleAd", SALE_AD);
        req.getRequestDispatcher("sale_ad.ftl").forward(req, resp);
    }
}
