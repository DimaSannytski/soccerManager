package com.ua.soccerManager.dto;

import javax.validation.constraints.NotNull;

import com.ua.soccerManager.validator.CheckTransferTeam;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@CheckTransferTeam
public class TransferDTO {
	private Long id;
	private Long teamFromId;
	@NotNull
	private Long teamToId;
	@NotNull
	private Long playerId;
	private String teamFromName;
	private String teamToName;
	private String playerName;
	private Double transferComission;
	private Long transferCost;
}
