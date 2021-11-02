package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.service.impl.SaleAdServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "deleteSaleAd", urlPatterns = "/deleteSaleAd")
public class DeleteSaleAdServlet extends HttpServlet {

    SaleAdServiceImpl saleAdService = new SaleAdServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String id = req.getParameter("id");
        if (id == null) {
            resp.sendRedirect("/");
        } else {
            saleAdService.delete(Integer.parseInt(id));
            resp.sendRedirect("/mySaleAds");
        }
    }
}
