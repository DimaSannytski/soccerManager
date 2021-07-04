package com.ua.soccerManager.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeamTransaction extends BaseEntity {

	@ManyToOne
	private Player player;
	@ManyToOne
	private Team teamFrom;
	@ManyToOne
	private Team teamTo;
	private Long transactionCost;
}
