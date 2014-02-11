package org.lichee.simple.example.entity;

// Generated 2012-8-13 14:18:57 by Hibernate Tools 3.6.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name = "se_user")
public class SeUser implements java.io.Serializable {

	private Integer userId;
	private String userName;
	private String userPassword;
	private String userAccount;
	private Date userCreateTime;
	private Date userUpadteTime;
	private Set<SeUserRole> userRoles = new HashSet<SeUserRole>(0);

	public SeUser() {
	}
	
	public SeUser(Integer userId, String userName, String userPassword,
			String userAccount, Date userCreateTime, Date userUpadteTime) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAccount = userAccount;
		this.userCreateTime = userCreateTime;
		this.userUpadteTime = userUpadteTime;
	}

	public SeUser(Integer userId, String userName, String userPassword,
			String userAccount, Date userCreateTime, Date userUpadteTime,
			Set<SeUserRole> userRoles) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAccount = userAccount;
		this.userCreateTime = userCreateTime;
		this.userUpadteTime = userUpadteTime;
		this.userRoles = userRoles;
	}



	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "user_password", nullable = false, length = 60)
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_account", nullable = false, length = 60)
	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_create_time", nullable = false, length = 19)
	public Date getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_upadte_time", length = 19)
	public Date getUserUpadteTime() {
		return userUpadteTime;
	}

	public void setUserUpadteTime(Date userUpadteTime) {
		this.userUpadteTime = userUpadteTime;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "user")
	@JsonIgnore
	public Set<SeUserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<SeUserRole> userRoles) {
		this.userRoles = userRoles;
	}


}