package org.example.mediahandling.services;

import org.example.mediahandling.exceptions.ResourceNotFoundException;
import org.example.mediahandling.models.entities.Album;
import org.example.mediahandling.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService implements AlbumServiceInterface {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) { this.albumRepository = albumRepository; }

    @Override
    public Album createAlbum(Album album) {
        if (album == null) {
            throw new IllegalArgumentException("Album cannot be null");
        }

        try {
            return albumRepository.save(album);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create album", e);
        }
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album updateAlbum(Album album) {
        if (album == null || album.getAlbumId() == null) {
            throw new IllegalArgumentException("Album or Album ID cannot be null");
        }

        if (!albumRepository.existsById(album.getAlbumId())) {
            throw new ResourceNotFoundException("Album", "Album with ID not found", album.getAlbumId());
        }

        try {
            return albumRepository.save(album);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update album", e);
        }
    }

    @Override
    public void deleteAlbumById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Album ID cannot be null");
        } else if (!albumRepository.existsById(id)) {
            throw new ResourceNotFoundException("Album", "Album with ID not found", id);
        }

        try {
            albumRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete album", e);
        }
    }

    @Override
    public List<Album> getAlbumByArtistId(Long id) {
        List<Album> albumList = albumRepository.findByArtists_ArtistId(id);

        if (albumList.isEmpty()) {
            throw new ResourceNotFoundException("Album", "No album found for artist ID", id);
        }

        return albumList;
    }
}
