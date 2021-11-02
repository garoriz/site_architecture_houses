package ru.kpfu.itis.garipov.service;

import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.model.Article;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> getAll();
    ArticleDTO get(int id);
    void save(Article article);
}
