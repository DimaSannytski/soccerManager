package com.ua.soccerManager.utils;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;

import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.entity.Team;
import com.ua.soccerManager.entity.enums.Country;
import com.ua.soccerManager.entity.enums.PlayerStyle;
import com.ua.soccerManager.service.PlayerService;
import com.ua.soccerManager.service.TeamService;

public interface FillBase {

	public static void FillBaseWithValues(ConfigurableApplicationContext context) {
		
		TeamService teamService = context.getBean(TeamService.class);
		PlayerService playerService = context.getBean(PlayerService.class);

		if (!teamService.findAll().isEmpty()) return;
		
		Team team = new Team("TeamName", 3.1, 1000000000l, Country.BRASIL, new ArrayList<Player>(), null, null);
		teamService.addTeam(team);
		for (int i = 0; i < 60; i++) {
			if (i % 10 == 0 & i != 0) {
				team = new Team("TeamName" + i, 3.1, 1000000000l, Country.BRASIL, new ArrayList<Player>(), null, null);
				teamService.addTeam(team);
			} else {
				Player player = new Player("Name" + i, "Surname" + i,
						new Date(System.currentTimeMillis() - 365l * 24l * 3600l * 35l * 1000l),
						new Date(System.currentTimeMillis() - 365l * 24l * 3600l * 15l * 1000l), null, team,
						Country.BRASIL, PlayerStyle.ATTACKING);

				playerService.addPlayer(player);
				team.getPlayers().add(player);
			}
		}
		teamService.addTeam(team);

	}
}
