package org.example.mediahandling.services;

import jakarta.transaction.Transactional;
import org.example.mediahandling.exceptions.ResourceNotFoundException;
import org.example.mediahandling.models.dtos.AlbumDTO;
import org.example.mediahandling.models.entities.Album;
import org.example.mediahandling.repositories.AlbumRepository;
import org.example.mediahandling.mappers.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService implements AlbumServiceInterface {

    private final AlbumRepository albumRepository;
    private final DTOMapper dtoMapper;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, DTOMapper dtoMapper) {
        this.albumRepository = albumRepository;
        this.dtoMapper = dtoMapper;
    }

    @Transactional
    @Override
    public Album createAlbum(Album album) {
        if (album == null) throw new IllegalArgumentException("Album cannot be null");
        return albumRepository.save(album);
    }

    @Override
    public List<AlbumDTO> getAllAlbums() {
        return albumRepository.findAll().stream()
                .map(dtoMapper::toAlbumDTO)
                .toList();
    }

    @Transactional
    @Override
    public Album updateAlbum(Album album) {
        if (album == null || album.getAlbumId() == null)
            throw new IllegalArgumentException("Album or ID cannot be null");
        if (!albumRepository.existsById(album.getAlbumId()))
            throw new ResourceNotFoundException("Album", "Album not found", album.getAlbumId());
        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbumById(Long id) {
        if (id == null) throw new IllegalArgumentException("Album ID cannot be null");
        if (!albumRepository.existsById(id))
            throw new ResourceNotFoundException("Album", "Album not found", id);
        albumRepository.deleteById(id);
    }

    @Override
    public List<AlbumDTO> getAlbumByArtistId(Long artistId) {
        List<Album> albumList = albumRepository.findByArtists_ArtistId(artistId);

        if (albumList.isEmpty()) {
            throw new ResourceNotFoundException("Album", "No albums found for artist ID", artistId);
        }

        return albumList.stream()
                .map(dtoMapper::toAlbumDTO)
                .toList();
    }
}
