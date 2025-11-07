package org.example.mediahandling.services;

import org.example.mediahandling.models.dtos.MediaDTO;
import org.example.mediahandling.models.entities.AlbumTrack;
import org.example.mediahandling.models.entities.Media;
import org.example.mediahandling.repositories.AlbumTrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumTrackService implements AlbumTrackServiceInterface {

    private final AlbumTrackRepository albumTrackRepository;

    public AlbumTrackService(AlbumTrackRepository albumTrackRepository) {
        this.albumTrackRepository = albumTrackRepository;
    }

    public List<MediaDTO> getTracksByAlbum(Long albumId) {
        List<AlbumTrack> albumTracks =
                albumTrackRepository.findByAlbum_AlbumIdOrderByTrackNumberAsc(albumId);

        return albumTracks.stream()
                .map(AlbumTrack::getMedia)
                .map(this::convertToDTO)
                .toList();
    }

    private MediaDTO convertToDTO(Media media) {
        String mediaType = media.getMediaType() != null ? media.getMediaType().getMediaTypeName() : null;

        List<String> genres = media.getGenres()
                .stream()
                .map(g -> g.getGenreName())
                .toList();

        List<String> artists = media.getArtists()
                .stream()
                .map(a -> a.getArtistName())
                .toList();

        List<String> albums = media.getAlbumTracks()
                .stream()
                .map(at -> at.getAlbum().getAlbumName())
                .distinct()
                .toList();

        return new MediaDTO(
                media.getMediaId(),
                media.getMediaName(),
                media.getUrl(),
                media.getReleaseDate(),
                mediaType,
                genres,
                artists,
                albums
        );
    }
}
