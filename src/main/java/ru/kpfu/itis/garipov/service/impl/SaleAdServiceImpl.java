package ru.kpfu.itis.garipov.service.impl;

import ru.kpfu.itis.garipov.dao.impl.ArticleDaoImpl;
import ru.kpfu.itis.garipov.dao.impl.SaleAdDaoImpl;
import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.dto.SaleAdDTO;
import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.model.SaleAd;
import ru.kpfu.itis.garipov.service.SaleAdService;

import java.util.ArrayList;
import java.util.List;

public class SaleAdServiceImpl implements SaleAdService {

    private final SaleAdDaoImpl dao = new SaleAdDaoImpl();

    @Override
    public List<SaleAdDTO> getAll() {
        List<SaleAd> saleAds = dao.getAll();
        List<SaleAdDTO> saleAdsDTO = new ArrayList<>();
        for (SaleAd saleAd : saleAds) {
            saleAdsDTO.add(new SaleAdDTO(
                    saleAd.getId(),
                    saleAd.getUserId(),
                    saleAd.getHeading(),
                    saleAd.getContent(),
                    saleAd.getPrice(),
                    saleAd.getPhoneNumber(),
                    saleAd.getUrlPhoto()
            ));
        }
        return saleAdsDTO;
    }

    @Override
    public SaleAdDTO get(int id) {
        SaleAd saleAd = dao.get(id);
        return new SaleAdDTO(id,
                saleAd.getUserId(),
                saleAd.getHeading(),
                saleAd.getContent(),
                saleAd.getPrice(),
                saleAd.getPhoneNumber(),
                saleAd.getUrlPhoto());
    }

    @Override
    public void save(SaleAd saleAd) {
        dao.save(new SaleAd(
                        saleAd.getUserId(),
                        saleAd.getHeading(),
                        saleAd.getContent(),
                        saleAd.getPrice(),
                        saleAd.getPhoneNumber(),
                        saleAd.getUrlPhoto()
                )
        );
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public List<SaleAdDTO> getAllById(int id) {
        List<SaleAd> saleAds = dao.getAllById(id);
        List<SaleAdDTO> saleAdsDTO = new ArrayList<>();
        for (SaleAd saleAd : saleAds) {
            saleAdsDTO.add(new SaleAdDTO(saleAd.getId(),
                    saleAd.getUserId(),
                    saleAd.getHeading(),
                    saleAd.getContent(),
                    saleAd.getPrice(),
                    saleAd.getPhoneNumber(),
                    saleAd.getUrlPhoto()));
        }
        return saleAdsDTO;
    }

    public List<SaleAdDTO> getAllByNameAndPice(String text, int maxPrice) {
        List<SaleAd> saleAds = dao.getAllByNameAndPice(text, maxPrice);
        List<SaleAdDTO> saleAdsDTO = new ArrayList<>();
        for (SaleAd saleAd : saleAds) {
            saleAdsDTO.add(new SaleAdDTO(saleAd.getId(),
                    saleAd.getUserId(),
                    saleAd.getHeading(),
                    saleAd.getContent(),
                    saleAd.getPrice(),
                    saleAd.getPhoneNumber(),
                    saleAd.getUrlPhoto()));
        }
        return saleAdsDTO;
    }
}
