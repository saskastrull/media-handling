package org.example.mediahandling.services;

import org.example.mediahandling.exceptions.ResourceNotFoundException;
import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.Album;
import org.example.mediahandling.models.entities.Artist;
import org.example.mediahandling.models.entities.Genre;
import org.example.mediahandling.models.entities.Media;
import org.example.mediahandling.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService implements MediaServiceInterface {

    private final MediaRepository mediaRepository;

    @Autowired
    public MediaService(MediaRepository mediaRepository) { this.mediaRepository = mediaRepository; }

    @Override
    public Media createMedia(Media media) {
        if (media == null) {
            throw new IllegalArgumentException("Media cannot be null");
        }

        try {
            return mediaRepository.save(media);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create media", e);
        }
    }

    @Override
    public List<MediaDTO> getAllMedia() {
        List<Media> mediaList = mediaRepository.findAll();

        return mediaList.stream().map(media -> {
            return new MediaDTO(
                    media.getMediaId(),
                    media.getMediaName(),
                    media.getUrl(),
                    media.getReleaseDate(),
                    media.getMediaType() != null ? media.getMediaType().getMediaTypeName() : null,
                    media.getGenres().stream()
                            .map(Genre::getGenreName)
                            .toList(),
                    media.getArtists().stream()
                            .map(Artist::getArtistName)
                            .toList(),
                    media.getAlbums().stream()
                            .map(Album::getAlbumName)
                            .toList()
            );
        }).toList();
    }

    @Override
    public Media updateMedia(Media media) {
        if (media == null || media.getMediaId() == null) {
            throw new IllegalArgumentException("Media or Media ID cannot be null");
        }

        if (!mediaRepository.existsById(media.getMediaId())) {
            throw new ResourceNotFoundException("Media", "Media with ID not found", media.getMediaId());
        }

        try {
            return mediaRepository.save(media);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update media", e);
        }
    }

    @Override
    public void deleteMediaById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Media ID cannot be null");
        } else if (!mediaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Media", "Media with ID not found", id);
        }

        try {
            mediaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete media", e);
        }
    }
}
