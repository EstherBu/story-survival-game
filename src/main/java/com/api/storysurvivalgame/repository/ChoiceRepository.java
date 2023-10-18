package com.api.storysurvivalgame.repository;

import com.api.storysurvivalgame.model.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<Choice, Integer> {
}
