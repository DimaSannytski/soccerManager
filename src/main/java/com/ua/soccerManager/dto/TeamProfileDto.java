package com.ua.soccerManager.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamProfileDto {

	private Long id;
	@NotNull
	private String name;
	@NotNull
	@Min(value = 0, message = "Transaction commission should not be less than 0")
	@Max(value = 10, message = "Transaction commission should not be greater than 10")
	private Double transactionCommission;
	private Long balance;
	@NotBlank(message = "Country can`t be empty")
	private String country;

}
