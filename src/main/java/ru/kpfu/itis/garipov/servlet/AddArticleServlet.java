package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.service.impl.ArticleServiceImpl;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;


@WebServlet(name = "addArticleServlet", urlPatterns = "/addArticle")
public class AddArticleServlet extends HttpServlet {

    ArticleServiceImpl articleService = new ArticleServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add_article.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        String heading = req.getParameter("heading");
        String content = req.getParameter("content");
        articleService.save(new Article(
                userService.get(sessionUser).getId(),
                heading,
                content));
        resp.sendRedirect("/articles");
    }
}
