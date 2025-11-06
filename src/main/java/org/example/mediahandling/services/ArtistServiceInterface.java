package org.example.mediahandling.services;

import org.example.mediahandling.models.entities.Artist;

import java.util.List;

public interface ArtistServiceInterface {
    Artist createArtist(Artist artist);
    List<Artist> getAllArtists();
    Artist updateArtist(Artist artist);
    void deleteArtistById(Long id);
}
