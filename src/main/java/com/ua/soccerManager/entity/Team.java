package com.ua.soccerManager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.ua.soccerManager.entity.enums.Country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Team extends BaseEntity {

	@NotNull
	private String name;
	@NotNull
	@Min(value = 0, message = "Transaction commission should not be less than 0")
	@Max(value = 10, message = "Transaction commission should not be greater than 10")
	private Double transactionCommission;
	@Min(value = 0, message = "Balance commission should not be less than 0")
	private Long balance;

	@Enumerated(EnumType.STRING)
	private Country country;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Player> players;

	@OneToMany(mappedBy = "teamFrom", cascade = CascadeType.ALL)
	private List<TeamTransaction> teamTransactionFrom;
	@OneToMany(mappedBy = "teamTo", cascade = CascadeType.ALL)
	private List<TeamTransaction> teamTransactionsTo;

}
