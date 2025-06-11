package com.jcharles.portfolioApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcharles.portfolioApi.dto.PhotoMetadataDto;
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
   * @return ResponseEntity<List<Photo>> 200 A list containing all photos metadata
   * @return ResponseEntity 500 - Internal server Error
   */
  @GetMapping("/photos")
  public ResponseEntity<?> getAllPhotos() {
    try {
      List<Photo> photos = photoService.getAllPhotos();

      return ResponseEntity.ok(photos);
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Internal server error");
    }
  }

  /**
   * POST
   * Endpoint to add a new photo in database
   * @param file Photo file
   * @param metadataJson JSON string containing photo informations
   * @return ResponseEntity 200 - Photo added successfully
   * @return ResponseEntity 500 - Internal server error
   */
  @PostMapping("/photo")
  public ResponseEntity<String> createPhoto(
    @RequestParam("file") MultipartFile file,
    @RequestParam("metadata") String metadataJson
  ){
    try {
      PhotoMetadataDto photoMetadata = new ObjectMapper()
        .readValue(metadataJson, PhotoMetadataDto.class);

      photoService.addPhoto(photoMetadata, file);

      return ResponseEntity.ok("Photo added successfully");
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Internal server error");
    }
  }
}
