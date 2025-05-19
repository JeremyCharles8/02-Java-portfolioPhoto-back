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
   * Get all albums informations
   * @return A list of all albums informations
   */
  public List<Album> getAllAlbums() {
    return albumRepository.findAll();
  }
}
