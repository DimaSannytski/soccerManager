package com.ua.soccerManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ua.soccerManager.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	@Query("SELECT u FROM Team u WHERE u.id = :id")
	Team findTeamById(@Param("id") Long id);

	@Query("SELECT u FROM Team u WHERE u.name = :name")
	Team findTeamByName(@Param("name") String name);

	@Query("SELECT u FROM Team u WHERE u.balance >= :cost")
	List<Team> findTeamForTransfer(@Param("cost") Long cost);
}
