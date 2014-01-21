package org.lichee.simple.example.entity;

// Generated 2012-8-13 14:18:57 by Hibernate Tools 3.6.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "se_user_role")
public class SeUserRole implements java.io.Serializable {

	private Integer userRoleId;
	private SeUser user;
	private SeRole role;
	private Date userRoleCreateTime;
	private Date userRoleUpadteTime;

	public SeUserRole() {
	}

	
	public SeUserRole(Integer userRoleId, SeUser user, SeRole role,
			Date userRoleCreateTime, Date userRoleUpadteTime) {
		
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
		this.userRoleCreateTime = userRoleCreateTime;
		this.userRoleUpadteTime = userRoleUpadteTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_role_id", unique = true, nullable = false)
	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public SeUser getUser() {
		return user;
	}

	public void setUser(SeUser user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	public SeRole getRole() {
		return role;
	}

	public void setRole(SeRole role) {
		this.role = role;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_role_create_time", nullable = false, length = 19)
	public Date getUserRoleCreateTime() {
		return userRoleCreateTime;
	}

	public void setUserRoleCreateTime(Date userRoleCreateTime) {
		this.userRoleCreateTime = userRoleCreateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_role_upadte_time", length = 19)
	public Date getUserRoleUpadteTime() {
		return userRoleUpadteTime;
	}

	public void setUserRoleUpadteTime(Date userRoleUpadteTime) {
		this.userRoleUpadteTime = userRoleUpadteTime;
	}

}