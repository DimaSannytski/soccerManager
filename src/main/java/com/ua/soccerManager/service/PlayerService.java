package com.ua.soccerManager.service;

import java.util.List;

import com.ua.soccerManager.entity.Player;

public interface PlayerService {

	Player addPlayer(Player player);

	Player findByPlayerId(Long playerId);

	List<Player> findAll();

	void delete(Long id);

	Player updatePlayer(Player player);
}
