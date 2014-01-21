package org.lichee.simple.example.entity;

// Generated 2012-7-19 10:06:20 by Hibernate Tools 3.6.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "se_permission")
public class SePermission implements java.io.Serializable {

	private Integer permissionId;
	private String permissionName;
	private String permissionUrl;
	private String permissionDesc;
	private Date permissionCreateTime;
	private Date permissionUpadteTime;
	private Set<SeRolePermission> rolePermissions = new HashSet<SeRolePermission>(0);

	public SePermission() {
	}
	
	public SePermission(Integer permissionId, String permissionName,
			String permissionUrl, String permissionDesc,
			Date permissionCreateTime, Date permissionUpadteTime) {
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.permissionUrl = permissionUrl;
		this.permissionDesc = permissionDesc;
		this.permissionCreateTime = permissionCreateTime;
		this.permissionUpadteTime = permissionUpadteTime;
	}
	
	public SePermission(Integer permissionId, String permissionName,
			String permissionUrl, String permissionDesc,
			Date permissionCreateTime, Date permissionUpadteTime,
			Set<SeRolePermission> rolePermissions) {
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.permissionUrl = permissionUrl;
		this.permissionDesc = permissionDesc;
		this.permissionCreateTime = permissionCreateTime;
		this.permissionUpadteTime = permissionUpadteTime;
		this.rolePermissions = rolePermissions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "permission_id", unique = true, nullable = false)
	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	@Column(name = "permission_name", nullable = false, length = 60)
	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Column(name = "permission_url", nullable = false, length = 65535)
	public String getPermissionUrl() {
		return permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	@Column(name = "permission_desc", nullable = false, length = 65535)
	public String getPermissionDesc() {
		return permissionDesc;
	}

	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "permission_create_time", nullable = false, length = 19)
	public Date getPermissionCreateTime() {
		return permissionCreateTime;
	}

	public void setPermissionCreateTime(Date permissionCreateTime) {
		this.permissionCreateTime = permissionCreateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "permission_upadte_time", length = 19)
	public Date getPermissionUpadteTime() {
		return permissionUpadteTime;
	}

	public void setPermissionUpadteTime(Date permissionUpadteTime) {
		this.permissionUpadteTime = permissionUpadteTime;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "permission")
	@JsonIgnore
	public Set<SeRolePermission> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(Set<SeRolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	
	
}
