package org.example.mediahandling.repositories;

import org.example.mediahandling.models.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findByArtists_ArtistId(Long artistId);
    List<Media> findByGenres_GenreId(Long genreId);
    @Query("SELECT g.genreId FROM Media m JOIN m.genres g WHERE m.mediaId = :mediaId")
    Long getGenreIdByMediaId(Long mediaId);
}
