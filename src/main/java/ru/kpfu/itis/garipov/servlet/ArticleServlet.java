package ru.kpfu.itis.garipov.servlet;

import ru.kpfu.itis.garipov.dto.ArticleDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "articleServlet", urlPatterns = "/article")
public class ArticleServlet extends HttpServlet {

    private static final ArticleDTO ARTICLE = new ArticleDTO(1, "Признания молодого архитектора",
            "Ричардс Эндрьюс с детства мечтал стать архитектором. Мечта его сбылась, и в тридцать лет он уже" +
                    " работал младшим компаньоном в архитектурном бюро. Но молодому человеку хотелось большего, " +
                    "хотелось быть самому себе хозяином. И вот пять лет назад он принял смелое решение: снял бывший " +
                    "каретник, устроил там себе студию и кабинет, распрощался с работодателем, повесил на двери " +
                    "скромную вывеску и стал ждать клиентов.", "19.08.2020 6:31");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("article", ARTICLE);
        req.getRequestDispatcher("article.ftl").forward(req, resp);
    }
}
