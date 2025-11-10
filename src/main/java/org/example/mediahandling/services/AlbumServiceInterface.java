package org.example.mediahandling.services;

import org.example.mediahandling.models.dtos.AlbumDTO;
import org.example.mediahandling.models.entities.Album;

import java.util.List;

public interface AlbumServiceInterface {
    Album createAlbum(Album album);
    List<AlbumDTO> getAllAlbums();
    Album updateAlbum(Album album);
    void deleteAlbumById(Long id);
    List<AlbumDTO> getAlbumByArtistId(Long id);
}
