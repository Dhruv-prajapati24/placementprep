package com.placementprep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placementprep.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Check user by email
    User findByEmail(String email);

    // Login using email and password
    User findByEmailAndPassword(String email, String password);

}