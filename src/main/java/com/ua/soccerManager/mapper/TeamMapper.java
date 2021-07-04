package com.ua.soccerManager.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ua.soccerManager.dto.TeamProfileDto;
import com.ua.soccerManager.entity.Team;
import com.ua.soccerManager.entity.enums.Country;

public interface TeamMapper {

	public static TeamProfileDto teamToProgileDTO(Team team) {
		TeamProfileDto teamProfileDto = new TeamProfileDto();
		teamProfileDto.setId(team.getId());
		teamProfileDto.setName(team.getName());
		teamProfileDto.setCountry(team.getCountry().toString());
		teamProfileDto.setTransactionCommission(team.getTransactionCommission());
		teamProfileDto.setBalance(team.getBalance());
		return teamProfileDto;

	}

	public static Team createTeamFromDto(TeamProfileDto teamProfileDto) {

		Team team = new Team();
		team.setCountry(Country.valueOf(teamProfileDto.getCountry()));
		team.setName(teamProfileDto.getName());
		team.setTransactionCommission(teamProfileDto.getTransactionCommission());
		team.setBalance(teamProfileDto.getBalance());
		return team;

	}

	public static Team updateTeamFromDto(TeamProfileDto teamProfileDto, Team team) {

		team.setCountry(Country.valueOf(teamProfileDto.getCountry()));
		team.setName(teamProfileDto.getName());
		team.setTransactionCommission(teamProfileDto.getTransactionCommission());
		team.setBalance(teamProfileDto.getBalance());
		return team;

	}

	public static List<TeamProfileDto> listTeamToListDTO(List<Team> list) {
		List<TeamProfileDto> teamProfileDtos = new ArrayList<TeamProfileDto>();
		for (Team team : list) {
			teamProfileDtos.add(TeamMapper.teamToProgileDTO(team));
		}
		return teamProfileDtos;

	}
}
