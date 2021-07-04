package com.ua.soccerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.entity.Team;
import com.ua.soccerManager.entity.TeamTransaction;
import com.ua.soccerManager.repository.TeamTransactionRepository;
import com.ua.soccerManager.service.PlayerService;
import com.ua.soccerManager.service.TeamService;
import com.ua.soccerManager.service.TeamTransactionService;

@Service
public class TeamTransactionServiceImpl implements TeamTransactionService {

	@Autowired
	TeamTransactionRepository teamTransactionRepository;
	@Autowired
	PlayerService playerService;
	@Autowired
	TeamService teamService;

	@Override
	public void delete(Long id) {
		teamTransactionRepository.deleteById(id);

	}

	@Override
	public List<TeamTransaction> findAll() {

		return teamTransactionRepository.findAll();
	}

	@Override
	public TeamTransaction saveTeamTransaction(TeamTransaction teamTransaction) {
		teamTransaction.setCreatedAt(new Date());
		teamTransaction.setUpdatedAt(new Date());
		Player player = teamTransaction.getPlayer();
		player.setTeam(teamTransaction.getTeamTo());
		teamTransactionRepository.save(teamTransaction);
		playerService.updatePlayer(player);
		Team teamFrom = teamTransaction.getTeamFrom();
		Team teamTo = teamTransaction.getTeamTo();
		teamFrom.setBalance(teamFrom.getBalance() + teamTransaction.getTransactionCost());
		teamTo.setBalance(teamTo.getBalance() - teamTransaction.getTransactionCost());
		teamService.updateTeam(teamTo);
		teamService.updateTeam(teamFrom);
		return teamTransaction;
	}

	@Override
	public TeamTransaction findById(Long Id) {

		return teamTransactionRepository.findTeamTransactionById(Id);
	}

}
