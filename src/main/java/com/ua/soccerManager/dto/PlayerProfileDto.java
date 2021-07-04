package com.ua.soccerManager.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerProfileDto {

	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	private Long birthdayMs;
	private Long startWorkFromMs;
	@NotNull
	private String teamName;
	@NotNull(message = "Team id can`t be empty")
	private Long teamId;
	@NotBlank(message = "Country can`t be empty")
	private String country;
	@NotBlank(message = "Player style can`t be empty")
	private String playerStyle;

}
