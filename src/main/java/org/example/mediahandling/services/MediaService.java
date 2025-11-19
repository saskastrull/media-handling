package org.example.mediahandling.services;

import jakarta.transaction.Transactional;
import org.example.mediahandling.exceptions.ResourceNotFoundException;
import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.Genre;
import org.example.mediahandling.models.entities.Media;
import org.example.mediahandling.models.entities.MediaType;
import org.example.mediahandling.repositories.MediaRepository;
import org.example.mediahandling.mappers.DTOMapper;
import org.example.mediahandling.repositories.MediaTypeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MediaService implements MediaServiceInterface {

    private final MediaRepository mediaRepository;
    private final MediaTypeRepository mediaTypeRepository;
    private final DTOMapper dtoMapper;

    public MediaService(MediaRepository mediaRepository,
                        MediaTypeRepository mediaTypeRepository,
                        DTOMapper dtoMapper) {
        this.mediaRepository = mediaRepository;
        this.mediaTypeRepository = mediaTypeRepository;
        this.dtoMapper = dtoMapper;
    }

    @Transactional
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

    @Transactional
    @Override
    public MediaDTO updateMedia(Media media) {
        if (media == null || media.getMediaId() == null) {
            throw new IllegalArgumentException("Media or Media ID cannot be null");
        }

        Media existingMedia = mediaRepository.findById(media.getMediaId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Media",
                        "Media with ID not found",
                        media.getMediaId()
                ));

        // Check for any new data
        if (media.getMediaName() != null && !media.getMediaName().isBlank()) {
            existingMedia.setMediaName(media.getMediaName());
        }

        if (media.getUrl() != null && !media.getUrl().isBlank()) {
            existingMedia.setUrl(media.getUrl());
        }

        if (media.getReleaseDate() != null) {
            existingMedia.setReleaseDate(media.getReleaseDate());
        }

        if (media.getMediaType() != null && media.getMediaType().getMediaTypeId() != null) {
            MediaType type = mediaTypeRepository.findById(media.getMediaType().getMediaTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "MediaType",
                            "MediaType with ID not found",
                            media.getMediaType().getMediaTypeId()
                    ));
            existingMedia.setMediaType(type);
        }

        if (media.getGenres() != null && !media.getGenres().isEmpty()) {
            existingMedia.setGenres(media.getGenres());
        }

        if (media.getArtists() != null && !media.getArtists().isEmpty()) {
            existingMedia.setArtists(media.getArtists());
        }

        if (media.getAlbumTracks() != null && !media.getAlbumTracks().isEmpty()) {
            existingMedia.setAlbumTracks(media.getAlbumTracks());
        }

        return dtoMapper.toMediaDTO(mediaRepository.save(existingMedia));
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
    public Long getGenreIdByMediaId(Long id) {
        return mediaRepository.getGenreIdByMediaId(id);
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




    // Used to fetch genres for recommendations service
    @Override
    public Map<Long, List<String>> getGenresByMediaIds(List<Long> mediaIds) {

        Map<Long, List<String>> genresByMediaIds = new HashMap<>();

        List<Media> medias = mediaRepository.findAllById(mediaIds);

        for(Media media : medias) {
            List<String> genreNames = media.getGenres().stream().map(genre -> genre.getGenreName()).toList();
            genresByMediaIds.put(media.getMediaId(), genreNames);
        }
        return genresByMediaIds;
    }
}
