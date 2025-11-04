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
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<MediaDTO> getAllMedia() {
        return mediaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MediaDTO getMediaById(Long id) {
        Optional<Media> mediaOpt = mediaRepository.findById(id);
        if (mediaOpt.isEmpty()) {
            throw new RuntimeException("Media with ID " + id + " not found");
        }
        return convertToDTO(mediaOpt.get());
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

    private MediaDTO convertToDTO(Media media) {
        MediaDTO dto = new MediaDTO();
        dto.setId(media.getMediaId());
        dto.setName(media.getMediaName());
        dto.setUrl(media.getUrl());
        dto.setReleaseDate(media.getReleaseDate());
        dto.setMediaType(media.getMediaType().getMediaTypeName());

        // Convert artist names to a simple list of strings
        dto.setArtists(
                media.getArtists().stream()
                        .map(a -> a.getArtistName())
                        .toList()
        );

        // Convert genres similarly
        dto.setGenres(
                media.getGenres().stream()
                        .map(g -> g.getGenreName())
                        .toList()
        );

        return dto;
    }
}
