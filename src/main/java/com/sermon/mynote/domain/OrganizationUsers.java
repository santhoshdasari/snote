package com.sermon.mynote.domain;

// Generated May 7, 2015 9:40:59 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * OrganizationUsers generated by hbm2java
 */
@Entity
@NamedQuery(name = "OrganizationUsers.findOrgUserById", query = "SELECT o FROM OrganizationUsers o WHERE o.userId = (?1)")
@Table(name = "organizationusers")
public class OrganizationUsers implements java.io.Serializable {

	private Integer orgUserId;
	private int organizationId;
	private int userId;
	private Date membershipDate;
	private String membershipStatus;

	public OrganizationUsers() {
	}

	public OrganizationUsers(int organizationId, int userId, int userRoleId) {
		this.organizationId = organizationId;
		this.userId = userId;
		//this.userRoleId = userRoleId;
	}

	public OrganizationUsers(int organizationId, int userId, int userRoleId,
			Date membershipDate, String membershipStatus) {
		this.organizationId = organizationId;
		this.userId = userId;
		this.membershipDate = membershipDate;
		this.membershipStatus = membershipStatus;
	}
   
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "OrgUserId")
	public Integer getOrgUserId() {
		return this.orgUserId;
	}

	@ManyToOne 
	private Organization organization;
	
	public void setOrgUserId(Integer orgUserId) {
		this.orgUserId = orgUserId;
	}

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getMembershipDate() {
		return this.membershipDate;
	}

	public void setMembershipDate(Date membershipDate) {
		this.membershipDate = membershipDate;
	}

	public String getMembershipStatus() {
		return this.membershipStatus;
	}

	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

}
