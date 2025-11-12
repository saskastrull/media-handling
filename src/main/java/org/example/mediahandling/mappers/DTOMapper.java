package org.example.mediahandling.mappers;

import org.example.mediahandling.models.dtos.AlbumDTO;
import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.Album;
import org.example.mediahandling.models.entities.AlbumTrack;
import org.example.mediahandling.models.entities.Media;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Utility class used for mapping the Media and Album JPA entities to DTOs.
 */
@Component
public class DTOMapper {

    public MediaDTO toMediaDTO(Media media) {
        List<String> artists = media.getArtists().stream()
                .map(a -> a.getArtistName())
                .toList();

        List<String> genres = media.getGenres().stream()
                .map(g -> g.getGenreName())
                .toList();

        List<String> albums = media.getAlbumTracks().stream()
                .map(at -> at.getAlbum().getAlbumName())
                .toList();

        return new MediaDTO(
                media.getMediaId(),
                media.getMediaName(),
                media.getUrl(),
                media.getReleaseDate(),
                media.getMediaType() != null ? media.getMediaType().getMediaTypeName() : null,
                genres,
                artists,
                albums
        );
    }

    public AlbumDTO toAlbumDTO(Album album) {
        List<String> artistNames = album.getArtists().stream()
                .map(a -> a.getArtistName())
                .toList();

        List<MediaDTO> tracks = album.getAlbumTracks().stream()
                .map(AlbumTrack::getMedia)
                .map(this::toMediaDTO) // reuse MediaDTO mapping
                .toList();

        return new AlbumDTO(
                album.getAlbumId(),
                album.getAlbumName(),
                album.getAlbum_year(),
                artistNames,
                tracks
        );
    }
}
