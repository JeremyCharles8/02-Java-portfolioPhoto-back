package com.jcharles.portfolioApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jcharles.portfolioApi.model.Album;
import com.jcharles.portfolioApi.repository.AlbumRepository;

@Service
public class AlbumService {
  
  private final AlbumRepository albumRepository;

  public AlbumService(AlbumRepository albumRepository) {
    this.albumRepository = albumRepository;
  }

  /**
   * Get all photos metadata
   * @return A list of all photos metadata
   */
  public List<Album> getAlbums() {
    return albumRepository.findAll();
  }
}
