package org.example.mediahandling.services;

import jakarta.transaction.Transactional;
import org.example.mediahandling.exceptions.ResourceNotFoundException;
import org.example.mediahandling.models.entities.Genre;
import org.example.mediahandling.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements GenreServiceInterface {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional
    @Override
    public Genre createGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Genre cannot be null");
        }

        try {
            return genreRepository.save(genre);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create genre", e);
        }
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Transactional
    @Override
    public Genre updateGenre(Genre genre) {
        if (genre == null || genre.getGenreId() == null) {
            throw new IllegalArgumentException("Genre or Genre ID cannot be null");
        }

        if (!genreRepository.existsById(genre.getGenreId())) {
            throw new ResourceNotFoundException("Genre", "Genre with ID not found", genre.getGenreId());
        }

        try {
            return genreRepository.save(genre);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update genre", e);
        }
    }

    @Override
    public void deleteGenreById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Genre ID cannot be null");
        } else if (!genreRepository.existsById(id)) {
            throw new ResourceNotFoundException("Genre", "Genre with ID not found", id);
        }

        try {
            genreRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete genre", e); // genre might be tied to other entities
        }
    }
}
