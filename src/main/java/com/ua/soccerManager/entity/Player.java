package com.ua.soccerManager.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.ua.soccerManager.entity.enums.Country;
import com.ua.soccerManager.entity.enums.PlayerStyle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player extends BaseEntity {

	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	private Date bitrhday;
	private Date startWorkFrom;

	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
	private List<TeamTransaction> teamTransaction;
	@ManyToOne
	private Team team;
	@Enumerated(EnumType.STRING)
	private Country country;
	@Enumerated(EnumType.STRING)
	private PlayerStyle playerStyle;
}
