package org.example.mediahandling.services;

import jakarta.transaction.Transactional;
import org.example.mediahandling.exceptions.ResourceNotFoundException;
import org.example.mediahandling.models.entities.Artist;
import org.example.mediahandling.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService implements ArtistServiceInterface {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) { this.artistRepository = artistRepository; }

    @Transactional
    @Override
    public Artist createArtist(Artist artist) {
        if (artist == null) {
            throw new IllegalArgumentException("Artist cannot be null");
        }

        try {
            return artistRepository.save(artist);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create artist", e);
        }
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Transactional
    @Override
    public Artist updateArtist(Artist artist) {
        if (artist == null || artist.getArtistId() == null) {
            throw new IllegalArgumentException("Artist or Artist ID cannot be null");
        }

        if (!artistRepository.existsById(artist.getArtistId())) {
            throw new ResourceNotFoundException("Artist", "Artist with ID not found", artist.getArtistId());
        }

        try {
            return artistRepository.save(artist);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update artist", e);
        }
    }

    @Override
    public void deleteArtistById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Artist ID cannot be null");
        } else if (!artistRepository.existsById(id)) {
            throw new ResourceNotFoundException("Artist", "Artist with ID not found", id);
        }

        try {
            artistRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete artist", e);
        }
    }
}
