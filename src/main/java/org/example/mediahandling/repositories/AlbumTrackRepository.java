package org.example.mediahandling.repositories;

import org.example.mediahandling.models.entities.AlbumTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlbumTrackRepository extends JpaRepository<AlbumTrack, Long> {
    List<AlbumTrack> findByAlbum_AlbumIdOrderByTrackNumberAsc(Long albumId);
}
