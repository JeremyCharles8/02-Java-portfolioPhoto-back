package com.jcharles.portfolioApi.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
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
   * Upload original photo and her thumbnail on cloudinary, create photo in database
   * @param photoMetadata Photo's data
   * @param file Photo file
   * @throws IOException Title already exists
   * @throws IOException FileName already exists
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

    @SuppressWarnings("unchecked")
    Map<String, Object> thumbnailUploadResult = cloudinary
      .uploader()
      .explicit(
        (String) originalUploadResult.get("public_id"),
        ObjectUtils.asMap(
          "type", "upload",
          "eager", List.of(
            new Transformation<>().width(200).height(200).crop("limit")
          ),
          "eager_async", false
        )
      );

    @SuppressWarnings("unchecked")
    List<Map<String, Object>> eager = (List<Map<String, Object>>) thumbnailUploadResult
      .get("eager");
    Map<String, Object> thumbnail = eager.get(0);
    
    Album album = new Album();
    album.setId(photoMetadata.getAlbumId());

    Photo photo = new Photo();
    photo.setFileName(photoMetadata.getFileName());
    photo.setTitle(photoMetadata.getTitle());
    photo.setCaption(photoMetadata.getCaption());
    photo.setImgUrl((String) originalUploadResult.get("secure_url"));
    photo.setThumbnailUrl((String) thumbnail.get("secure_url"));
    photo.setAlbum(album);
    
    photoRepository.save(photo);
  }

}
