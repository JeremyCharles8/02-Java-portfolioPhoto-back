package com.jcharles.portfolioApi.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcharles.portfolioApi.dto.AlbumDto;
import com.jcharles.portfolioApi.model.Album;
import com.jcharles.portfolioApi.service.AlbumService;

import jakarta.validation.Valid;

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
  public List<Album> getAll() {
    return albumService.getAll();
  }

  /**
   * Endpoint to add a new album in database
   * @param album JSON containing album's data
   * @return 200 - Album created successfully
   */
  @PostMapping("/album")
  public ResponseEntity<String> create(
    @Valid
    @RequestBody
    AlbumDto album
  ) throws IOException {
    albumService.create(album);

    return ResponseEntity.ok("Album created successfully");
  }

  /**
   * Endpoint to delete an album
   * @param id Album's id to delete
   * @return 204
   */
  @DeleteMapping("/album/{id://d+}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    albumService.delete(id);

    return ResponseEntity.noContent().build();
  }
}
