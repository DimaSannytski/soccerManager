package com.ua.soccerManager.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ua.soccerManager.dto.PlayerProfileDto;
import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.entity.Team;
import com.ua.soccerManager.entity.enums.Country;
import com.ua.soccerManager.entity.enums.PlayerStyle;

public interface PlayerMapper {

	public static PlayerProfileDto playerToDto(Player player) {
		PlayerProfileDto playerProfileDto = new PlayerProfileDto();
		playerProfileDto.setId(player.getId());
		playerProfileDto.setCountry(player.getCountry().toString());
		playerProfileDto.setBirthdayMs(player.getBitrhday().getTime());
		playerProfileDto.setStartWorkFromMs(player.getStartWorkFrom().getTime());
		playerProfileDto.setPlayerStyle(player.getPlayerStyle().toString());
		playerProfileDto.setName(player.getName());
		playerProfileDto.setSurname(player.getSurname());
		playerProfileDto.setTeamId(player.getTeam().getId());
		playerProfileDto.setTeamName(player.getTeam().getName());
		return playerProfileDto;
	}

	public static Player DtoToPlayerCreate(PlayerProfileDto playerProfileDto, Team team) {
		Player player = new Player();
		player.setCreatedAt(new Date());
		player.setUpdatedAt(new Date());
		player.setName(playerProfileDto.getName());
		player.setSurname(playerProfileDto.getSurname());
		player.setCountry(Country.valueOf(playerProfileDto.getCountry()));
		player.setPlayerStyle(PlayerStyle.valueOf(playerProfileDto.getPlayerStyle()));
		player.setTeam(team);
		player.setBitrhday(new Date(playerProfileDto.getBirthdayMs()));
		player.setStartWorkFrom(new Date(playerProfileDto.getStartWorkFromMs()));
		return player;
	}

	public static Player DtoToPlayerEdit(PlayerProfileDto playerProfileDto, Player player, Team team) {
		player.setCreatedAt(player.getCreatedAt());
		player.setName(playerProfileDto.getName());
		player.setSurname(playerProfileDto.getSurname());
		player.setCountry(Country.valueOf(playerProfileDto.getCountry()));
		player.setPlayerStyle(PlayerStyle.valueOf(playerProfileDto.getPlayerStyle()));
		player.setBitrhday(new Date(playerProfileDto.getBirthdayMs()));
		player.setStartWorkFrom(new Date(playerProfileDto.getStartWorkFromMs()));
		player.setTeam(team);
		return player;
	}

	public static List<PlayerProfileDto> getListPlayerProfileDto(List<Player> list) {
		List<PlayerProfileDto> listPlayerProfileDtos = new ArrayList<>();
		for (Player player : list) {
			listPlayerProfileDtos.add(PlayerMapper.playerToDto(player));
		}
		return listPlayerProfileDtos;
	}
}
