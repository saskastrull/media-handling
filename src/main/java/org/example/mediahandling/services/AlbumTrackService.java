package org.example.mediahandling.services;

import org.example.mediahandling.mappers.DTOMapper;
import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.AlbumTrack;
import org.example.mediahandling.repositories.AlbumTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumTrackService implements AlbumTrackServiceInterface {

    private final AlbumTrackRepository albumTrackRepository;
    private final DTOMapper dtoMapper;

    @Autowired
    public AlbumTrackService(AlbumTrackRepository albumTrackRepository, DTOMapper dtoMapper) {
        this.albumTrackRepository = albumTrackRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<MediaDTO> getTracksByAlbum(Long albumId) {
        List<AlbumTrack> albumTracks =
                albumTrackRepository.findByAlbum_AlbumIdOrderByTrackNumberAsc(albumId);

        return albumTracks.stream()
                .map(AlbumTrack::getMedia)
                .map(dtoMapper::toMediaDTO)
                .toList();
    }
}
