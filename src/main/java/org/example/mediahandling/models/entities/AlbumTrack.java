package org.example.mediahandling.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "album_track")
public class AlbumTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_track_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id", nullable = false)
    private Media media;

    @Column(name = "track_number", nullable = false)
    private int trackNumber;

    public AlbumTrack() { }

    public AlbumTrack(Album album, Media media, int trackNumber) {
        this.album = album;
        this.media = media;
        this.trackNumber = trackNumber;
    }

    public Long getId() { return id; }

    public Album getAlbum() { return album; }

    public Media getMedia() { return media; }

    public int getTrackNumber() { return trackNumber; }

    public void setAlbum(Album album) { this.album = album; }

    public void setMedia(Media media) { this.media = media; }

    public void setTrackNumber(int trackNumber) { this.trackNumber = trackNumber; }
}