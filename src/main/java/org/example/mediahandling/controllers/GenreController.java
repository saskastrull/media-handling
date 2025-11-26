package org.example.mediahandling.controllers;

import org.example.mediahandling.models.entities.Genre;
import org.example.mediahandling.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mediahandling")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) { this.genreService = genreService; }

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return new ResponseEntity<>(genreService.getAllGenres(), HttpStatus.OK);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PostMapping("/creategenre")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        return new ResponseEntity<>(genreService.createGenre(genre), HttpStatus.CREATED);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @PutMapping("/updategenre")
    public ResponseEntity<Genre> updateGenre(@RequestBody Genre genre) {
        return new ResponseEntity<>(genreService.updateGenre(genre), HttpStatus.OK);
    }

    @PreAuthorize("@roleChecker.hasRole(authentication, 'edufy_ADMIN')")
    @DeleteMapping("/deletegenre/{id}")
    public ResponseEntity<String> removeGenre(@PathVariable("id") Long id) {
        genreService.deleteGenreById(id);
        return new ResponseEntity<>("Genre with id " + id + " deleted", HttpStatus.OK);
    }
}
