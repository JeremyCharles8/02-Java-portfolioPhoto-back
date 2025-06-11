package com.jcharles.portfolioApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcharles.portfolioApi.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
  
  boolean existsByTitle (String title);
  boolean existsByFileName (String fileName);
}
