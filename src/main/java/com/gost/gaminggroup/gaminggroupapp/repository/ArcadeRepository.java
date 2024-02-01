package com.gost.gaminggroup.gaminggroupapp.repository;

import com.gost.gaminggroup.gaminggroupapp.models.Arcade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArcadeRepository extends JpaRepository<Arcade, Integer> {
    Optional<Arcade> findArcadeByName(String name);
}
