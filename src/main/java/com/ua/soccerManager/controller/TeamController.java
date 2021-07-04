package com.ua.soccerManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamController {
	@RequestMapping("/teams")
	public String showTeams() {
		return "teams";
	}

	@RequestMapping("/team")
	public String showTeamProfile() {
		return "team";
	}

	@RequestMapping("/create/team")
	public String createPlayer() {
		return "createteam";
	}

	@RequestMapping("/edit/team")
	public String editPlayer() {
		return "editteam";
	}

}
