package com.jcharles.portfolioApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jcharles.portfolioApi.model.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
 
}
