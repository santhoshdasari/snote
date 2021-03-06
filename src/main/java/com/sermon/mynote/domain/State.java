package com.sermon.mynote.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// Generated May 7, 2015 9:40:59 PM by Hibernate Tools 4.0.0

/**
 * State generated by hbm2java
 */
@Entity
@Table(name = "state")
public class State implements java.io.Serializable {

	private Integer stateId;
	private String stateName;
	private Integer countryId;

	public State() {
	}

	public State(String stateName) {
		this.stateName = stateName;
	}

	public State(String stateName, Integer countryId) {
		this.stateName = stateName;
		this.countryId = countryId;
	}
   
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "StateId")
	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

}
