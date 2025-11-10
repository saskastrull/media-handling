package org.example.mediahandling.models.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="album_id")
    private Long albumId;

    @Column(name="album_name", length=50, nullable=false)
    private String albumName;

    @Column
    private int album_year;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "album_artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists = new ArrayList<>();

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("trackNumber ASC")
    private List<AlbumTrack> albumTracks = new ArrayList<>();

    public Album() {}

    public Long getAlbumId() { return albumId; }

    public void setAlbumId(Long albumId) { this.albumId = albumId; }

    public String getAlbumName() { return albumName; }

    public void setAlbumName(String albumName) { this.albumName = albumName; }

    public int getAlbum_year() {
        return album_year;
    }

    public void setAlbum_year(int album_year) {
        this.album_year = album_year;
    }

    public List<Artist> getArtists() { return artists; }

    public void setArtists(List<Artist> artists) { this.artists = artists; }

    public List<AlbumTrack> getAlbumTracks() { return albumTracks; }

    public void setAlbumTracks(List<AlbumTrack> albumTracks) { this.albumTracks = albumTracks; }
}
