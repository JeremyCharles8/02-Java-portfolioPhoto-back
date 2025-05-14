package com.jcharles.portfolioApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jcharles.portfolioApi.model.Photo;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {
  
}
