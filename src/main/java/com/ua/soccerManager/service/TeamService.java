package com.ua.soccerManager.service;

import java.util.List;

import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.entity.Team;

public interface TeamService {

	Team addTeam(Team team);

	Team updateTeam(Team team);

	void dalete(Long id);

	List<Team> findAll();

	List<Team> findTeamsForTransfer(Long cost, Player player);

	Team findTeamById(Long id);

}
