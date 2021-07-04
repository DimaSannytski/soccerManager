package com.ua.soccerManager.service;

import java.util.List;

import com.ua.soccerManager.entity.TeamTransaction;

public interface TeamTransactionService {
	void delete(Long id);

	List<TeamTransaction> findAll();

	TeamTransaction saveTeamTransaction(TeamTransaction teamTransaction);

	TeamTransaction findById(Long Id);
}
