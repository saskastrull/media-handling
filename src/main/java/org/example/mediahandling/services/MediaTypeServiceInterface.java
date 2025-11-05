package org.example.mediahandling.services;

import org.example.mediahandling.models.entities.MediaType;

import java.util.List;

public interface MediaTypeServiceInterface {
    MediaType createMediaType(MediaType mediaType);
    List<MediaType> getAllMediaTypes();
    MediaType updateMediaType(MediaType mediaType);
    void deleteMediaTypeById(Long id);
}
