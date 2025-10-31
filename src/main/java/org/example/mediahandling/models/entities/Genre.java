package org.example.mediahandling.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name="genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="genre_id")
    private Long genreId;

    @Column(name="genre_name", length=50, nullable=false)
    private String genreName;

    public Genre() {}

    public Long getGenreId() { return genreId; }

    public void setGenreId(Long genreId) { this.genreId = genreId; }

    public String getGenreName() { return genreName; }

    public void setGenreName(String genreName) { this.genreName = genreName; }
}
