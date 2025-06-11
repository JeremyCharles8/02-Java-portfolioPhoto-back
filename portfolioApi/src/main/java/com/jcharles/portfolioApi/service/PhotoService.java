package com.jcharles.portfolioApi.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.jcharles.portfolioApi.dto.PhotoMetadataDto;
import com.jcharles.portfolioApi.model.Album;
import com.jcharles.portfolioApi.model.Photo;
import com.jcharles.portfolioApi.repository.PhotoRepository;

@Service
public class PhotoService {
  
  private final PhotoRepository photoRepository;
  private final Cloudinary cloudinary;

  public PhotoService(PhotoRepository photoRepository, Cloudinary cloudinary) {
    this.photoRepository = photoRepository;
    this.cloudinary = cloudinary;
  }

  /**
   * Get all photos metadata
   * @return A list of all photos metadata
   */
  public List<Photo> getAllPhotos() {
    return photoRepository.findAll();
  }

  /**
   * Upload original photo and her thumbnail on cloudinary
   * @param photoMetadata Photo's informations
   * @param file Photo file
   */
  public void addPhoto(PhotoMetadataDto photoMetadata, MultipartFile file) throws IOException {
    if (photoRepository.existsByTitle(photoMetadata.getTitle())) {
      throw new IllegalArgumentException("Title already exists");
    }

    if(photoRepository.existsByFileName(photoMetadata.getFileName())) {
      throw new IllegalArgumentException("FileName already exists");
    }

    @SuppressWarnings("unchecked")
    Map<String, Object> originalUploadResult = cloudinary
      .uploader()
      .upload(file.getBytes(),ObjectUtils.emptyMap());

    Photo photo = new Photo();
    photo.setFileName(photoMetadata.getFileName());
    photo.setTitle(photoMetadata.getTitle());
    photo.setCaption(photoMetadata.getCaption());
    photo.setImgUrl((String) originalUploadResult.get("secure_url"));
    
    Album album = new Album();
    album.setId(photoMetadata.getAlbumId());

    photo.setAlbum(album);
    
    photoRepository.save(photo);
  }
}
