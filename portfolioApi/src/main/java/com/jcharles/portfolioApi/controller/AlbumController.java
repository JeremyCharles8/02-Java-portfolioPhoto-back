package com.jcharles.portfolioApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcharles.portfolioApi.model.Album;
import com.jcharles.portfolioApi.service.AlbumService;

@RestController
public class AlbumController {
  
  private final AlbumService albumService;

  public AlbumController(AlbumService albumService) {
    this.albumService = albumService;
  }

  /**
   * GET
   * Endpoint to get all albums informations
   * @return A list of all albums informations
   */
  @GetMapping("/albums")
  public List<Album> getAllAlbums() {
    return albumService.getAllAlbums();
  }
}
