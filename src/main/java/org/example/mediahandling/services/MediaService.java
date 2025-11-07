package org.example.mediahandling.services;

import org.example.mediahandling.exceptions.ResourceNotFoundException;
import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.Media;
import org.example.mediahandling.repositories.MediaRepository;
import org.example.mediahandling.mappers.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService implements MediaServiceInterface {

    private final MediaRepository mediaRepository;
    private final DTOMapper dtoMapper;

    public MediaService(MediaRepository mediaRepository, DTOMapper dtoMapper) {
        this.mediaRepository = mediaRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public Media createMedia(Media media) {
        if (media == null) {
            throw new IllegalArgumentException("Media cannot be null");
        }
        return mediaRepository.save(media);
    }

    public List<MediaDTO> getAllMedia() {
        return mediaRepository.findAll().stream()
                .map(dtoMapper::toMediaDTO)
                .toList();
    }

    public MediaDTO getMediaById(Long id) {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Media",
                        "Media with ID " + id + " not found",
                        id
                ));
        return dtoMapper.toMediaDTO(media);
    }

    @Override
    public Media updateMedia(Media media) {
        if (media == null || media.getMediaId() == null) {
            throw new IllegalArgumentException("Media or Media ID cannot be null");
        }

        if (!mediaRepository.existsById(media.getMediaId())) {
            throw new ResourceNotFoundException(
                    "Media",
                    "Media with ID not found",
                    media.getMediaId()
            );
        }

        return mediaRepository.save(media);
    }

    @Override
    public void deleteMediaById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Media ID cannot be null");
        }
        if (!mediaRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Media",
                    "Media with ID not found",
                    id
            );
        }
        mediaRepository.deleteById(id);
    }

    @Override
    public List<MediaDTO> getMediaByArtistId(Long artistId) {
        List<Media> mediaList = mediaRepository.findByArtists_ArtistId(artistId);

        if (mediaList.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Media",
                    "No media found for artist ID",
                    artistId
            );
        }

        return mediaList.stream()
                .map(dtoMapper::toMediaDTO)
                .toList();
    }

    @Override
    public List<MediaDTO> getMediaByGenreId(Long genreId) {
        List<Media> mediaList = mediaRepository.findByGenres_GenreId(genreId);

        if (mediaList.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Media",
                    "No media found for genre ID",
                    genreId
            );
        }

        return mediaList.stream()
                .map(dtoMapper::toMediaDTO)
                .toList();
    }
}
