package ru.kpfu.itis.garipov.service;

import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.dto.PhotoDTO;
import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.model.Photo;

import java.util.List;

public interface PhotoService {
    List<PhotoDTO> getAll();
    void save(Photo photo);
}
