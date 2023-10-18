package com.api.storysurvivalgame.repository;

import com.api.storysurvivalgame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
