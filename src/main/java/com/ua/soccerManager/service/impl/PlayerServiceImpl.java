package com.ua.soccerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.repository.PlayerRepository;
import com.ua.soccerManager.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	@Override
	public Player addPlayer(Player player) {
		player.setCreatedAt(new Date());
		player.setUpdatedAt(new Date());
		return playerRepository.save(player);

	}

	@Override
	public Player findByPlayerId(Long playerId) {

		return playerRepository.findUserById(playerId);
	}

	@Override
	public List<Player> findAll() {

		return playerRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		playerRepository.deleteById(id);

	}

	@Override
	public Player updatePlayer(Player player) {
		player.setUpdatedAt(new Date());
		return playerRepository.save(player);

	}

}
