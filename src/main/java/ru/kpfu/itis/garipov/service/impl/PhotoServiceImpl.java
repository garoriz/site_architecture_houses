package ru.kpfu.itis.garipov.service.impl;

import ru.kpfu.itis.garipov.dao.impl.ArticleDaoImpl;
import ru.kpfu.itis.garipov.dao.impl.PhotoDaoImpl;
import ru.kpfu.itis.garipov.dto.ArticleDTO;
import ru.kpfu.itis.garipov.dto.PhotoDTO;
import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.model.Photo;
import ru.kpfu.itis.garipov.service.PhotoService;

import java.util.ArrayList;
import java.util.List;

public class PhotoServiceImpl implements PhotoService {

    private final PhotoDaoImpl dao = new PhotoDaoImpl();

    @Override
    public List<PhotoDTO> getAll() {
        List<Photo> photos = dao.getAll();
        List<PhotoDTO> photosDTO = new ArrayList<>();
        for (Photo photo : photos) {
            photosDTO.add(new PhotoDTO(photo.getId(),
                    photo.getUserId(),
                    photo.getUrlPhoto()));
        }
        return photosDTO;
    }

    @Override
    public void save(Photo photo) {
        dao.save(new Photo(
                photo.getUserId(),
                photo.getUrlPhoto()
        ));
    }

    public List<PhotoDTO> getAllById(int id) {
        List<Photo> photos = dao.getAllById(id);
        List<PhotoDTO> photosDTO = new ArrayList<>();
        for (Photo photo : photos) {
            photosDTO.add(new PhotoDTO(photo.getId(),
                    photo.getUserId(),
                    photo.getUrlPhoto()));
        }
        return photosDTO;
    }
}
