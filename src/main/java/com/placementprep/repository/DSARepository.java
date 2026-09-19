package com.placementprep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placementprep.entity.DSAQuestion;

@Repository
public interface DSARepository extends JpaRepository<DSAQuestion, Integer> {

    List<DSAQuestion> findByTopic(String topic);

    List<DSAQuestion> findByDifficulty(String difficulty);

    List<DSAQuestion> findByTopicAndDifficulty(String topic, String difficulty);

    // ✅ NEW LINE (Profile page ke liye)
    long countByCompletedTrue();
}