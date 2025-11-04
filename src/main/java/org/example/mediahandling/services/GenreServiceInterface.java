package org.example.mediahandling.services;

import org.example.mediahandling.models.entities.Genre;

import java.util.List;

public interface GenreServiceInterface {
    Genre createGenre(Genre genre);
    List<Genre> getAllGenres();
    Genre updateGenre(Genre genre);
    void deleteGenreById(Long id);
}
