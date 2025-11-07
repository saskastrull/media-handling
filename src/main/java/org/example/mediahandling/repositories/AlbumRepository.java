package org.example.mediahandling.repositories;

import org.example.mediahandling.models.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByArtists_ArtistId(Long artistId);
}
