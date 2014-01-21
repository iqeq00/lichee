package org.lichee.simple.example.entity;

// Generated 2012-8-13 14:21:58 by Hibernate Tools 3.6.0

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
@Table(name = "se_role_permission")
public class SeRolePermission implements java.io.Serializable {

	private Integer rolePermissionId;
	private SeRole role;
	private SePermission permission;
	private Date rolePermissionCreateTime;
	private Date rolePermissionUpadteTime;

	public SeRolePermission() {
	}
	
	public SeRolePermission(Integer rolePermissionId, SeRole role,
			SePermission permission, Date rolePermissionCreateTime,
			Date rolePermissionUpadteTime) {
		this.rolePermissionId = rolePermissionId;
		this.role = role;
		this.permission = permission;
		this.rolePermissionCreateTime = rolePermissionCreateTime;
		this.rolePermissionUpadteTime = rolePermissionUpadteTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "role_permission_id", unique = true, nullable = false)
	public Integer getRolePermissionId() {
		return rolePermissionId;
	}

	public void setRolePermissionId(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	public SeRole getRole() {
		return role;
	}

	public void setRole(SeRole role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "permission_id", nullable = false)
	public SePermission getPermission() {
		return permission;
	}

	public void setPermission(SePermission permission) {
		this.permission = permission;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "role_permission_create_time", nullable = false, length = 19)
	public Date getRolePermissionCreateTime() {
		return rolePermissionCreateTime;
	}

	public void setRolePermissionCreateTime(Date rolePermissionCreateTime) {
		this.rolePermissionCreateTime = rolePermissionCreateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "role_permission_upadte_time", length = 19)
	public Date getRolePermissionUpadteTime() {
		return rolePermissionUpadteTime;
	}

	public void setRolePermissionUpadteTime(Date rolePermissionUpadteTime) {
		this.rolePermissionUpadteTime = rolePermissionUpadteTime;
	}

	
	

	

	

	


}
