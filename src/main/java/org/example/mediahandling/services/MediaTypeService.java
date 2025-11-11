package org.example.mediahandling.services;

import jakarta.transaction.Transactional;
import org.example.mediahandling.exceptions.ResourceNotFoundException;
import org.example.mediahandling.models.entities.MediaType;
import org.example.mediahandling.repositories.MediaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaTypeService implements MediaTypeServiceInterface {

    private final MediaTypeRepository mediaTypeRepository;

    @Autowired
    public MediaTypeService(MediaTypeRepository mediaTypeRepository) { this.mediaTypeRepository = mediaTypeRepository; }

    @Transactional
    @Override
    public MediaType createMediaType(MediaType mediaType) {
        if (mediaType == null) {
            throw new IllegalArgumentException("Media type cannot be null");
        }

        try {
            return mediaTypeRepository.save(mediaType);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create media type", e);
        }
    }

    @Override
    public List<MediaType> getAllMediaTypes() { return mediaTypeRepository.findAll(); }

    @Transactional
    @Override
    public MediaType updateMediaType(MediaType mediaType) {
        if (mediaType == null || mediaType.getMediaTypeId() == null) {
            throw new IllegalArgumentException("Media type or Media type ID cannot be null");
        }

        if (!mediaTypeRepository.existsById(mediaType.getMediaTypeId())) {
            throw new ResourceNotFoundException("Media type", "Media type with ID not found", mediaType.getMediaTypeId());
        }

        try {
            return mediaTypeRepository.save(mediaType);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update media type", e);
        }
    }

    @Override
    public void deleteMediaTypeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Media type ID cannot be null");
        } else if (!mediaTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Media type", "Media type with ID not found", id);
        }

        try {
            mediaTypeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete media type", e); // media type might be tied to other entities
        }
    }
}
