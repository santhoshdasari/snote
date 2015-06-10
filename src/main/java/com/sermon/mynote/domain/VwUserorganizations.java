package com.sermon.mynote.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// Generated Jun 9, 2015 9:06:51 PM by Hibernate Tools 4.0.0

/**
 * VwUserorganizations generated by hbm2java
 */
@Entity
@NamedQuery(name = "VwUserorganizations.findOrganizationsByUser", query = "SELECT o FROM VwUserorganizations o  WHERE o.userid = (?1)")
@Table(name = "vw_userorganizations")
public class VwUserorganizations implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -228958903428769102L;
	private int userid;
	private String username;
	private String organizationName;
	private String cityName;
	private String stateName;
	private String countryName;
	private String zipcode;

	public VwUserorganizations() {
	}

	public VwUserorganizations(int userid, String username, String cityName,
			String stateName, String countryName) {
		this.userid = userid;
		this.username = username;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
	}

	public VwUserorganizations(int userid, String username,
			String organizationName, String cityName, String stateName,
			String countryName, String zipcode) {
		this.userid = userid;
		this.username = username;
		this.organizationName = organizationName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
		this.zipcode = zipcode;
	}
   
	@Id
	@Column(name = "userid")
	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VwUserorganizations))
			return false;
		VwUserorganizations castOther = (VwUserorganizations) other;

		return (this.getUserid() == castOther.getUserid())
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getOrganizationName() == castOther
						.getOrganizationName()) || (this.getOrganizationName() != null
						&& castOther.getOrganizationName() != null && this
						.getOrganizationName().equals(
								castOther.getOrganizationName())))
				&& ((this.getCityName() == castOther.getCityName()) || (this
						.getCityName() != null
						&& castOther.getCityName() != null && this
						.getCityName().equals(castOther.getCityName())))
				&& ((this.getStateName() == castOther.getStateName()) || (this
						.getStateName() != null
						&& castOther.getStateName() != null && this
						.getStateName().equals(castOther.getStateName())))
				&& ((this.getCountryName() == castOther.getCountryName()) || (this
						.getCountryName() != null
						&& castOther.getCountryName() != null && this
						.getCountryName().equals(castOther.getCountryName())))
				&& ((this.getZipcode() == castOther.getZipcode()) || (this
						.getZipcode() != null && castOther.getZipcode() != null && this
						.getZipcode().equals(castOther.getZipcode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserid();
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37
				* result
				+ (getOrganizationName() == null ? 0 : this
						.getOrganizationName().hashCode());
		result = 37 * result
				+ (getCityName() == null ? 0 : this.getCityName().hashCode());
		result = 37 * result
				+ (getStateName() == null ? 0 : this.getStateName().hashCode());
		result = 37
				* result
				+ (getCountryName() == null ? 0 : this.getCountryName()
						.hashCode());
		result = 37 * result
				+ (getZipcode() == null ? 0 : this.getZipcode().hashCode());
		return result;
	}

}
