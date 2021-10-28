package ru.kpfu.itis.garipov.service.impl;

import ru.kpfu.itis.garipov.dao.impl.ArticleDaoImpl;
import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.service.ArticleService;

import java.util.ArrayList;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private final ArticleDaoImpl dao = new ArticleDaoImpl();

    @Override
    public List<ArticleDTO> getAll() {
        List<Article> articles = dao.getAll();
        List<ArticleDTO> articlesDTO = new ArrayList<>();
        for (Article article : articles) {
            articlesDTO.add(new ArticleDTO(article.getId(),
                    article.getUserId(),
                    article.getDate(),
                    article.getHeading(),
                    article.getContent(),
                    article.getUrlPhoto()));
        }
        return articlesDTO;
    }

    @Override
    public ArticleDTO get(int id) {
        Article article = dao.get(id);
        return new ArticleDTO(id,
                article.getUserId(),
                article.getDate(),
                article.getHeading(),
                article.getContent(),
                article.getUrlPhoto());
    }
}
