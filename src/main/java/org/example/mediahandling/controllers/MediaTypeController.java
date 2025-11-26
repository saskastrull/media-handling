package org.example.mediahandling.controllers;

import org.example.mediahandling.models.entities.MediaType;
import org.example.mediahandling.services.MediaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mediahandling")
public class MediaTypeController {

    private final MediaTypeService mediaTypeService;

    @Autowired
    public MediaTypeController(MediaTypeService mediaTypeService) { this.mediaTypeService = mediaTypeService; }

    @GetMapping("/mediatypes")
    public ResponseEntity<List<MediaType>> getAllMediaTypes() {
        return new ResponseEntity<>(mediaTypeService.getAllMediaTypes(), HttpStatus.OK);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PostMapping("/createmediatype")
    public ResponseEntity<MediaType> createMediaType(@RequestBody MediaType mediaType) {
        return new ResponseEntity<>(mediaTypeService.createMediaType(mediaType), HttpStatus.CREATED);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PutMapping("/updatemediatype")
    public ResponseEntity<MediaType> updateMediaType(@RequestBody MediaType mediaType) {
        return new ResponseEntity<>(mediaTypeService.updateMediaType(mediaType), HttpStatus.OK);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @DeleteMapping("/deletemediatype/{id}")
    public ResponseEntity<String> removeMediaType(@PathVariable("id") Long id) {
        mediaTypeService.deleteMediaTypeById(id);
        return new ResponseEntity<>("Media type with id " + id + " deleted", HttpStatus.OK);
    }
}
