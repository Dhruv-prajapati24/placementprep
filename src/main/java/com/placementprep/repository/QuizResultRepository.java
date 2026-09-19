package com.placementprep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placementprep.entity.QuizResult;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResult, Integer> {

}