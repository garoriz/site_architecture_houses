package ru.kpfu.itis.garipov.service;

import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.dto.SaleAdDTO;
import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.model.SaleAd;

import java.util.List;

public interface SaleAdService {
    List<SaleAdDTO> getAll();
    SaleAdDTO get(int id);
    void save(SaleAd saleAd);
}
