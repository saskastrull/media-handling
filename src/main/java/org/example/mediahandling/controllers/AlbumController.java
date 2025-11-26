package org.example.mediahandling.controllers;

import org.example.mediahandling.models.dtos.AlbumDTO;
import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.Album;
import org.example.mediahandling.services.AlbumService;
import org.example.mediahandling.services.AlbumTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mediahandling")
public class AlbumController {

    private final AlbumService albumService;
    private final AlbumTrackService albumTrackService;

    @Autowired
    public AlbumController(AlbumService albumService, AlbumTrackService albumTrackService) {
        this.albumService = albumService;
        this.albumTrackService = albumTrackService; }

    @GetMapping("/albums")
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() {
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PostMapping("/createalbum")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(albumService.createAlbum(album), HttpStatus.CREATED);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PutMapping("/updatealbum")
    public ResponseEntity<Album> updateAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(albumService.updateAlbum(album), HttpStatus.OK);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @DeleteMapping("/deletealbum/{id}")
    public ResponseEntity<String> removeAlbum(@PathVariable("id") Long id) {
        albumService.deleteAlbumById(id);
        return new ResponseEntity<>("Album with id " + id + " deleted", HttpStatus.OK);
    }

    @GetMapping("/albumbyartist/{id}")
    public ResponseEntity<List<AlbumDTO>> getAlbumByArtistId(@PathVariable Long id) {
        return new ResponseEntity<>(albumService.getAlbumByArtistId(id), HttpStatus.OK);
    }

    @GetMapping("/album/{albumId}")
    public List<MediaDTO> getTracks(@PathVariable Long albumId) {
        return albumTrackService.getTracksByAlbum(albumId);
    }
}
