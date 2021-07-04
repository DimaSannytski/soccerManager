package com.ua.soccerManager.utils;

import java.util.Date;

import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.entity.Team;

public interface MathPart {

	public static Long getTransferCost(Player player, Team team) {
		Date dateNow = new Date();
		int experienceInMonth = (int) ((dateNow.getTime() - player.getStartWorkFrom().getTime())
				/ (30l * 24l * 60l * 60l * 1000l));
		int ageInYears = (int) ((dateNow.getTime() - player.getBitrhday().getTime())
				/ (365l * 24l * 60l * 60l * 1000l));
		if (ageInYears == 0)
			return null;
		Long cost = (long) (experienceInMonth * 100000 / ageInYears);
		Long comission = (long) (cost * (team.getTransactionCommission() / 100));
		return cost + comission;
	}
}
