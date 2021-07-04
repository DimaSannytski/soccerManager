package com.ua.soccerManager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ua.soccerManager.dto.TransferDTO;
import com.ua.soccerManager.mapper.TransferMapper;
import com.ua.soccerManager.service.PlayerService;
import com.ua.soccerManager.service.TeamService;
import com.ua.soccerManager.service.TeamTransactionService;

@RestController
public class TransferRESTController {

	@Autowired
	PlayerService playerService;
	@Autowired
	TeamService teamService;
	@Autowired
	TeamTransactionService teamTransactionService;

	@RequestMapping(value = "/transfer/{Id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public TransferDTO getTransferParam(@PathVariable("Id") Long Id) {
		return TransferMapper.getTransferDTO(playerService.findByPlayerId(Id));
	}

	@RequestMapping(value = "/transfer", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void creatTransfer(@RequestBody @Valid TransferDTO transferDTO) {
		teamTransactionService
				.saveTeamTransaction(TransferMapper.transferDtoToEntity(transferDTO, teamService, playerService));
	}

}
