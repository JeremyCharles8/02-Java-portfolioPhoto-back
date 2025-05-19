package com.jcharles.portfolioApi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "photo_metadata")
public class Photo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "file_name")
  private String fileName;

  private String title;

  private String caption;

  @Column(name = "img_url")
  private String imgUrl;

  @Column(name = "img_thumbnail_url")
  private String thumbnailUrl;

  @ManyToOne
  @JoinColumn(name = "album_id", nullable = true)
  private Album album;

  @Column(name = "created_at", updatable = false, insertable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
