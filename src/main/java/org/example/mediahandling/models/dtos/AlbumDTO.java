package org.example.mediahandling.models.dtos;

import java.util.List;

public class AlbumDTO {

    private Long id;
    private String name;
    private int year;
    private List<String> artistNames;
    private List<MediaDTO> tracks;

    public AlbumDTO() { }

    public AlbumDTO(Long id, String name, int year, List<String> artistNames, List<MediaDTO> tracks) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.artistNames = artistNames;
        this.tracks = tracks;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public List<String> getArtistNames() { return artistNames; }

    public void setArtistNames(List<String> artistNames) { this.artistNames = artistNames; }

    public List<MediaDTO> getTracks() { return tracks; }

    public void setTracks(List<MediaDTO> tracks) { this.tracks = tracks; }
}
