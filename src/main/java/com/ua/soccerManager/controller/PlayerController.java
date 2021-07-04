package com.ua.soccerManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayerController {

	@RequestMapping("/players")
	public String showPlayers() {
		return "players";
	}

	@RequestMapping("/player")
	public String showPlayer() {
		return "player";
	}

	@RequestMapping("/create/player")
	public String createPlayer() {
		return "createplayer";
	}

	@RequestMapping("/edit/player")
	public String editPlayer() {
		return "editplayer";
	}
}
