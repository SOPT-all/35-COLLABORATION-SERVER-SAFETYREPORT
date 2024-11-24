package com.safetyreport.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetyreport.domain.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
