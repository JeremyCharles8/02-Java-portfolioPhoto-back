package com.jcharles.portfolioApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jcharles.portfolioApi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
