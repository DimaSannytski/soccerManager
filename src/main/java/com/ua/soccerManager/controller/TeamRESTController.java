package com.ua.soccerManager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ua.soccerManager.dto.TeamProfileDto;
import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.entity.Team;
import com.ua.soccerManager.mapper.TeamMapper;
import com.ua.soccerManager.service.PlayerService;
import com.ua.soccerManager.service.TeamService;
import com.ua.soccerManager.utils.MathPart;

@RestController
public class TeamRESTController {

	@Autowired
	TeamService teamService;
	@Autowired
	PlayerService playerService;

	@RequestMapping(value = "/team", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public TeamProfileDto addTeam(@RequestBody @Valid TeamProfileDto teamProfileDto) {

		return TeamMapper.teamToProgileDTO(teamService.addTeam(TeamMapper.createTeamFromDto(teamProfileDto)));
	}

	@RequestMapping(value = "/team", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public TeamProfileDto updateTeam(@RequestBody @Valid TeamProfileDto teamProfileDto) {

		return TeamMapper.teamToProgileDTO(teamService.updateTeam(
				TeamMapper.updateTeamFromDto(teamProfileDto, teamService.findTeamById(teamProfileDto.getId()))));
	}

	@RequestMapping(value = "/getallteams", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<TeamProfileDto> getTeams() {
		List<Team> list = teamService.findAll();
		return TeamMapper.listTeamToListDTO(list);
	}

	@RequestMapping(value = "/team/{Id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public TeamProfileDto getTeamById(@PathVariable("Id") Long Id) {
		return TeamMapper.teamToProgileDTO(teamService.findTeamById(Id));
	}

	@RequestMapping(value = "/team/{Id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteTeam(@PathVariable("Id") Long Id) {
		teamService.dalete(Id);
	}

	@RequestMapping(value = "/getteamsfortransfer/{Id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<TeamProfileDto> getTeamsForTransfer(@PathVariable("Id") Long Id) {
		Player player = playerService.findByPlayerId(Id);
		return TeamMapper.listTeamToListDTO(
				teamService.findTeamsForTransfer(MathPart.getTransferCost(player, player.getTeam()), player));
	}
}
