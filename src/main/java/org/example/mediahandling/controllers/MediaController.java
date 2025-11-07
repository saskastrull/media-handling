package org.example.mediahandling.controllers;

import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.Media;
import org.example.mediahandling.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mediahandling")
public class MediaController {

    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) { this.mediaService = mediaService; }

    @GetMapping("/media")
    public ResponseEntity<List<MediaDTO>> getAllMedia() {
        return new ResponseEntity<>(mediaService.getAllMedia(), HttpStatus.OK);
    }

    @GetMapping("/media/{id}")
    public ResponseEntity<MediaDTO> getMediaById(@PathVariable Long id) {
        return new ResponseEntity<>(mediaService.getMediaById(id), HttpStatus.OK);
    }

    @PostMapping("/createmedia")
    public ResponseEntity<Media> createMedia(@RequestBody Media media) {
        return new ResponseEntity<>(mediaService.createMedia(media), HttpStatus.CREATED);
    }

    @PutMapping("/updatemedia")
    public ResponseEntity<Media> updateMedia(@RequestBody Media media) {
        return new ResponseEntity<>(mediaService.updateMedia(media), HttpStatus.OK);
    }

    @DeleteMapping("/deletemedia/{id}")
    public ResponseEntity<String> removeMedia(@PathVariable("id") Long id) {
        mediaService.deleteMediaById(id);
        return new ResponseEntity<>("Media with id " + id + " deleted", HttpStatus.OK);
    }
}
