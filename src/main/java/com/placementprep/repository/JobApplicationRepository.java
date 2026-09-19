package com.placementprep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placementprep.entity.JobApplication;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Integer> {

}