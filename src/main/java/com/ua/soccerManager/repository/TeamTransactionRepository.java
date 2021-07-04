package com.ua.soccerManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ua.soccerManager.entity.TeamTransaction;

@Repository
public interface TeamTransactionRepository extends JpaRepository<TeamTransaction, Long> {

	@Query("SELECT u FROM TeamTransaction u WHERE u.id = :id")
	TeamTransaction findTeamTransactionById(@Param("id") Long id);
}
