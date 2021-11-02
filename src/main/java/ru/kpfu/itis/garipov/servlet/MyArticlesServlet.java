package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.dto.UserDTO;
import ru.kpfu.itis.garipov.service.impl.ArticleServiceImpl;
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

@WebServlet(name = "listMyArticlesServlet", urlPatterns = "/myArticles")
public class MyArticlesServlet extends HttpServlet {

    ArticleServiceImpl articleService = new ArticleServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        UserDTO user = userService.get(sessionUser);

        List<ArticleDTO> articlesDTO = articleService.getAllById(user.getId());
        Collections.reverse(articlesDTO);
        req.setAttribute("articles", articlesDTO);
        req.getRequestDispatcher("my_articles.ftl").forward(req, resp);
    }
}
