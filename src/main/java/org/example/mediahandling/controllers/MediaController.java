package org.example.mediahandling.controllers;

import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.Media;
import org.example.mediahandling.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PostMapping("/createmedia")
    public ResponseEntity<Media> createMedia(@RequestBody Media media) {
        return new ResponseEntity<>(mediaService.createMedia(media), HttpStatus.CREATED);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PutMapping("/updatemedia")
    public ResponseEntity<MediaDTO> updateMedia(@RequestBody Media media) {
        return new ResponseEntity<>(mediaService.updateMedia(media), HttpStatus.OK);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @DeleteMapping("/deletemedia/{id}")
    public ResponseEntity<String> removeMedia(@PathVariable("id") Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authorities → " + auth.getAuthorities());
        mediaService.deleteMediaById(id);
        return new ResponseEntity<>("Media with id " + id + " deleted", HttpStatus.OK);
    }

    @GetMapping("/mediabyartist/{id}")
    public ResponseEntity<List<MediaDTO>> getMediaByArtistId(@PathVariable Long id) {
        return new ResponseEntity<>(mediaService.getMediaByArtistId(id), HttpStatus.OK);
    }

    @GetMapping("/mediabygenre/{id}")
    public ResponseEntity<List<MediaDTO>> getMediaByGenreId(@PathVariable Long id) {
        return new ResponseEntity<>(mediaService.getMediaByGenreId(id), HttpStatus.OK);
    }

    @GetMapping("/genreidbymediaid/{id}")
    public ResponseEntity<Long> getGenreIdByMediaId(@PathVariable Long id) {
        return new ResponseEntity<>(mediaService.getGenreIdByMediaId(id), HttpStatus.OK);
    }

    //Endpoint for fetching genres to use in recommendations service
    @GetMapping("/genresbymediaids")
    public ResponseEntity<Map<Long, List<String>>> getGenresByMediaIds(@RequestParam List<Long> mediaIds) {
        return new ResponseEntity<>(mediaService.getGenresByMediaIds(mediaIds), HttpStatus.OK);
    }
}
