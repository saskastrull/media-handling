package org.example.mediahandling.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "media_type")
public class MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="media_type_id")
    private Long mediaTypeId;

    @Column(name="media_type_name", length=30, unique=true, nullable=false)
    private String mediaTypeName;

    public MediaType() {}

    public Long getMediaTypeId() { return mediaTypeId; }

    public void setMediaTypeId(Long mediaTypeId) { this.mediaTypeId = mediaTypeId; }

    public String getMediaTypeName() { return mediaTypeName; }

    public void setMediaTypeName(String mediaTypeName) { this.mediaTypeName = mediaTypeName; }
}
