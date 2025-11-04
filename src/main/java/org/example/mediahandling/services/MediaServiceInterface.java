package org.example.mediahandling.services;

import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.Media;

import java.util.List;

public interface MediaServiceInterface {
    Media createMedia(Media media);
    List<MediaDTO> getAllMedia();
    Media updateMedia(Media media);
    void deleteMediaById(Long id);
}
