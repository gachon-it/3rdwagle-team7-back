package com.hackathon.wagle.domain.user.repository;

import com.hackathon.wagle.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByStudentNumber(String studentNumber);

    Optional<User> findByEmail(String email);
}
