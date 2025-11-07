package org.example.mediahandling.models.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "media")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="media_id")
    private Long mediaId;

    @Column(name="media_name",length = 50, nullable = false)
    private String mediaName;

    @Column(length = 255, nullable = false)
    private String url;

    @Column(nullable = false)
    private LocalDate releaseDate;

    // Media can have many genres
    @ManyToMany
    @JoinTable(
            name = "media_genre",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    // Media can be shared among artists
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "media_artist",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists = new ArrayList<>();

    // Media can only have one media type
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_type_id", nullable = false)
    private MediaType mediaType;

    // Relationship to albums
    @OneToMany(mappedBy = "media", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlbumTrack> albumTracks = new ArrayList<>();

    public Media() {}

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) { this.mediaName = mediaName;}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) { this.url = url; }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Artist> getArtists() { return artists; }

    public void setArtists(List<Artist> artists) { this.artists = artists; }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public List<AlbumTrack> getAlbumTracks() { return albumTracks; }

    public void setAlbumTracks(List<AlbumTrack> albumTracks) { this.albumTracks = albumTracks; }
}
