package com.stockie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
/*    */ @Table(name="USERS")
public class User {
	@Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId")
	//@SequenceGenerator(name = "userId", sequenceName = "SEQ_USER_ID", allocationSize = 1)
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private int enabled;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
