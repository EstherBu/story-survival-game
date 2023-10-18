package com.api.storysurvivalgame.repository;

import com.api.storysurvivalgame.model.StorySegment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorySegmentRepository extends JpaRepository<StorySegment, Integer> {
}
