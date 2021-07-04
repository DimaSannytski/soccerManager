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

import com.ua.soccerManager.dto.PlayerProfileDto;
import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.entity.Team;
import com.ua.soccerManager.mapper.PlayerMapper;
import com.ua.soccerManager.service.PlayerService;
import com.ua.soccerManager.service.TeamService;

@RestController
public class PlayerRESTController {

	@Autowired
	PlayerService playerService;
	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/player", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public PlayerProfileDto addPlayer(@RequestBody @Valid PlayerProfileDto playerProfileDto) {

		return PlayerMapper.playerToDto(playerService.addPlayer(PlayerMapper.DtoToPlayerCreate(playerProfileDto,
				teamService.findTeamById(playerProfileDto.getTeamId()))));
	}

	@RequestMapping(value = "/player", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public PlayerProfileDto editPlayer(@RequestBody @Valid PlayerProfileDto playerProfileDto) {

		return PlayerMapper.playerToDto(playerService.updatePlayer(
				PlayerMapper.DtoToPlayerEdit(playerProfileDto, playerService.findByPlayerId(playerProfileDto.getId()),
						teamService.findTeamById(playerProfileDto.getTeamId()))));
	}

	@RequestMapping(value = "/getall", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<PlayerProfileDto> getPlayer() {
		List<Player> list = playerService.findAll();
		return PlayerMapper.getListPlayerProfileDto(list);
	}

	@RequestMapping(value = "/player/{Id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public PlayerProfileDto getPlayer(@PathVariable("Id") Long Id) {
		return PlayerMapper.playerToDto(playerService.findByPlayerId(Id));
	}

	@RequestMapping(value = "/player/team/{Id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<PlayerProfileDto> getPlayersByTeam(@PathVariable("Id") Long Id) {
		Team team = teamService.findTeamById(Id);
		return PlayerMapper.getListPlayerProfileDto(team.getPlayers());
	}

	@RequestMapping(value = "/player/{Id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deletePlayer(@PathVariable("Id") Long Id) {
		playerService.delete(Id);
	}
}
