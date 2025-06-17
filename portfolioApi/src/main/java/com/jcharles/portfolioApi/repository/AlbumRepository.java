package com.jcharles.portfolioApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcharles.portfolioApi.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

  boolean existsByName (String name);
}
