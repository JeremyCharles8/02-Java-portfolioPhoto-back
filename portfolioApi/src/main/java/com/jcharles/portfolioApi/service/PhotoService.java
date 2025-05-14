package com.jcharles.portfolioApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jcharles.portfolioApi.model.Photo;
import com.jcharles.portfolioApi.repository.PhotoRepository;

@Service
public class PhotoService {
  
  private final PhotoRepository photoRepository;

  public PhotoService(PhotoRepository photoRepository) {
    this.photoRepository = photoRepository;
  }

  /**
   * Get all albums name
   * @return A list of all albums name
   */
  public List<Photo> getPhotos() {
    return photoRepository.findAll();
  }
}
