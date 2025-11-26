package org.example.mediahandling.controllers;

import org.example.mediahandling.models.entities.Artist;
import org.example.mediahandling.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mediahandling")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) { this.artistService = artistService; }

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtists() {
        return new ResponseEntity<>(artistService.getAllArtists(), HttpStatus.OK);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PostMapping("/createartist")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.createArtist(artist), HttpStatus.CREATED);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PutMapping("/updateartist")
    public ResponseEntity<Artist> updateArtist(@RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.updateArtist(artist), HttpStatus.OK);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @DeleteMapping("/deleteartist/{id}")
    public ResponseEntity<String> removeArtist(@PathVariable("id") Long id) {
        artistService.deleteArtistById(id);
        return new ResponseEntity<>("Artist with id " + id + " deleted", HttpStatus.OK);
    }
}
