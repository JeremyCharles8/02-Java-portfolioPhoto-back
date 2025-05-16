package com.jcharles.portfolioApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcharles.portfolioApi.model.Photo;
import com.jcharles.portfolioApi.service.PhotoService;

@RestController
public class PhotoController {
  
  private final PhotoService photoService;

  public PhotoController(PhotoService photoService) {
    this.photoService = photoService;
  }
  
  /**
   * GET
   * Endpoint to get all photos metadata
   * @return A list of photos metadata
   */
  @GetMapping("/photos")
  public List<Photo> getAllPhotos() {
    return photoService.getAllPhotos();
  }
}
