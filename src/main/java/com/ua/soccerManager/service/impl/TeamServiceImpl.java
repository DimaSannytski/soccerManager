package com.ua.soccerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.entity.Team;
import com.ua.soccerManager.repository.TeamRepository;
import com.ua.soccerManager.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;

	@Override
	public Team addTeam(Team team) {
		team.setCreatedAt(new Date());
		team.setUpdatedAt(new Date());
		return teamRepository.save(team);

	}

	@Override
	public void dalete(Long id) {

		teamRepository.deleteById(id);

	}

	@Override
	public List<Team> findAll() {

		return teamRepository.findAll();
	}

	@Override
	public Team findTeamById(Long id) {

		return teamRepository.findTeamById(id);
	}

	@Override
	public Team updateTeam(Team team) {
		team.setUpdatedAt(new Date());
		return teamRepository.save(team);
	}

	@Override
	public List<Team> findTeamsForTransfer(Long cost, Player player) {
		List<Team> list = teamRepository.findTeamForTransfer(cost);
		list.remove(player.getTeam());
		return list;
	}

}
