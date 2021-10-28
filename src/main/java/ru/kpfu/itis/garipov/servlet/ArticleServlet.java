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
import java.io.IOException;

@WebServlet(name = "articleServlet", urlPatterns = "/article")
public class ArticleServlet extends HttpServlet {

    ArticleServiceImpl articleService = new ArticleServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ArticleDTO articleDTO = articleService.get(Integer.parseInt(id));
        UserDTO userDTO = userService.get(articleDTO.getUserId());
        req.setAttribute("author" ,userDTO);
        req.setAttribute("article", articleDTO);
        req.getRequestDispatcher("article.ftl").forward(req, resp);
    }
}
