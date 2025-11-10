package org.example.mediahandling.services;

import org.example.mediahandling.models.dtos.MediaDTO;

import java.util.List;

public interface AlbumTrackServiceInterface {
    List<MediaDTO> getTracksByAlbum(Long albumId);
}
