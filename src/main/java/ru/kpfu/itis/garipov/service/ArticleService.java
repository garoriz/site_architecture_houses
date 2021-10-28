package ru.kpfu.itis.garipov.service;

import ru.kpfu.itis.garipov.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> getAll();
    ArticleDTO get(int id);
}
