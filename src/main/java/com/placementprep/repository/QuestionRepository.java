package com.placementprep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placementprep.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}