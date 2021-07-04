package com.ua.soccerManager.mapper;

import com.ua.soccerManager.dto.TransferDTO;
import com.ua.soccerManager.entity.Player;
import com.ua.soccerManager.entity.TeamTransaction;
import com.ua.soccerManager.service.PlayerService;
import com.ua.soccerManager.service.TeamService;
import com.ua.soccerManager.utils.MathPart;

public interface TransferMapper {

	public static TeamTransaction transferDtoToEntity(TransferDTO transferDTO, TeamService teamService,
			PlayerService playerService) {

		TeamTransaction teamTransaction = new TeamTransaction();
		teamTransaction.setPlayer(playerService.findByPlayerId(transferDTO.getPlayerId()));
		teamTransaction.setTeamFrom(teamTransaction.getPlayer().getTeam());
		teamTransaction.setTeamTo(teamService.findTeamById(transferDTO.getTeamToId()));
		teamTransaction.setTransactionCost(
				MathPart.getTransferCost(teamTransaction.getPlayer(), teamTransaction.getTeamFrom()));
		return teamTransaction;

	}

	public static TransferDTO getTransferDTO(Player player) {
		TransferDTO transferDTO = new TransferDTO();
		transferDTO.setPlayerId(player.getId());
		transferDTO.setPlayerName(player.getName());
		transferDTO.setTeamFromId(player.getTeam().getId());
		transferDTO.setTeamFromName(player.getTeam().getName());
		transferDTO.setTransferCost(MathPart.getTransferCost(player, player.getTeam()));
		transferDTO.setTransferComission(player.getTeam().getTransactionCommission());
		return transferDTO;

	}
}
