package com.jcharles.portfolioApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jcharles.portfolioApi.dto.PhotoMetadataDto;
import com.jcharles.portfolioApi.model.Photo;
import com.jcharles.portfolioApi.repository.PhotoRepository;

@Service
public class PhotoService {
  
  private final PhotoRepository photoRepository;

  public PhotoService(PhotoRepository photoRepository) {
    this.photoRepository = photoRepository;
  }

  /**
   * Get all photos metadata
   * @return A list of all photos metadata
   */
  public List<Photo> getAllPhotos() {
    return photoRepository.findAll();
  }

  public addPhoto(PhotoMetadataDto photoMetadata){
    
  }
}
