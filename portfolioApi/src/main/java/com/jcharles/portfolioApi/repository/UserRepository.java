package com.jcharles.portfolioApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcharles.portfolioApi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
