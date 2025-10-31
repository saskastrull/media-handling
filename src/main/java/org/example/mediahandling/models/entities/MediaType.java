package org.example.mediahandling.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "media_type")
public class MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaTypeId;

    @Column(length = 30, unique = true, nullable = false)
    private String type;

    public MediaType() {}

    public Long getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(Long mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
