package org.example.mediahandling.controllers;

import org.example.mediahandling.models.entities.Album;
import org.example.mediahandling.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mediahandling")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) { this.albumService = albumService; }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }

    @PostMapping("/createalbum")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(albumService.createAlbum(album), HttpStatus.CREATED);
    }

    @PutMapping("/updatealbum")
    public ResponseEntity<Album> updateAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(albumService.updateAlbum(album), HttpStatus.OK);
    }

    @DeleteMapping("/deletealbum/{id}")
    public ResponseEntity<String> removeAlbum(@PathVariable("id") Long id) {
        albumService.deleteAlbumById(id);
        return new ResponseEntity<>("Album with id " + id + " deleted", HttpStatus.OK);
    }
}
