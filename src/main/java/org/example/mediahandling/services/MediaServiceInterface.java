package org.example.mediahandling.services;

import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.Media;

import java.util.List;
import java.util.Map;

public interface MediaServiceInterface {
    Media createMedia(Media media);
    List<MediaDTO> getAllMedia();
    MediaDTO getMediaById(Long id);
    MediaDTO updateMedia(Media media);
    void deleteMediaById(Long id);
    List<MediaDTO> getMediaByArtistId(Long id);
    Long getGenreIdByMediaId(Long id);
    List<MediaDTO> getMediaByGenreId(Long id);

    //Used to fetch genres for recommendations service
    Map<Long, List<String>> getGenresByMediaIds(List<Long> mediaIds);
}
