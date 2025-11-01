package org.example.mediahandling.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="album_id")
    private Long albumId;

    @Column(name="album_name", length=50, nullable=false)
    private String albumName;

    @Column
    private int year;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "album_artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists = new ArrayList<>();

    @ManyToMany(mappedBy = "albums", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Media> mediaList = new ArrayList<>();

    public Album() {}

    public Long getAlbumId() { return albumId; }

    public void setAlbumId(Long albumId) { this.albumId = albumId; }

    public String getAlbumName() { return albumName; }

    public void setAlbumName(String albumName) { this.albumName = albumName; }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public List<Artist> getArtists() { return artists; }

    public void setArtists(List<Artist> artists) { this.artists = artists; }

    public List<Media> getMediaList() { return mediaList; }

    public void setMediaList(List<Media> mediaList) { this.mediaList = mediaList; }
}
