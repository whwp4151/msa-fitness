package com.project.trainer.repository;

import com.project.trainer.domain.Trainers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainers, Long> {
    Optional<Trainers> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
