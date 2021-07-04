package com.ua.soccerManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ua.soccerManager.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query("SELECT u FROM Player u WHERE u.id = :id")
	Player findUserById(@Param("id") Long id);

	@Query("SELECT u FROM Player u WHERE u.name = :name")
	Player findUserByName(@Param("name") String name);
}
