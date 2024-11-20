package com.safetyreport.safetyreport.repository;

import com.safetyreport.safetyreport.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
