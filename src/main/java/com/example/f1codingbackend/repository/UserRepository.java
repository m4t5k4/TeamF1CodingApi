package com.example.f1codingbackend.repository;

import com.example.f1codingbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    List<User> findAll();
}
