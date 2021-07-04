package com.ua.soccerManager.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ua.soccerManager.dto.TransferDTO;
import com.ua.soccerManager.entity.Team;
import com.ua.soccerManager.service.TeamService;

public class CheckTransferTeamValidation implements ConstraintValidator<CheckTransferTeam, TransferDTO> {

	@Autowired TeamService teamService;

	@Override
	public boolean isValid(TransferDTO dto, ConstraintValidatorContext context) {
		if (dto.getTeamFromId() == dto.getTeamToId()) return false;  
		Team team = teamService.findTeamById(dto.getTeamToId());
		
		return team.getBalance() >= dto.getTransferCost();
	}


}
