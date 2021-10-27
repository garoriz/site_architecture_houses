package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "listArticlesServlet", urlPatterns = "/articles")
public class ListArticlesServlet extends HttpServlet {

    ArticleServiceImpl articleService = new ArticleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ArticleDTO> articlesDTO = articleService.getAll();
        Collections.reverse(articlesDTO);
        req.setAttribute("articles", articlesDTO);
        req.getRequestDispatcher("articles.jsp").forward(req, resp);
    }
}
