package com.backend.cybershop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_user")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Column(name = "name_user")
	private String userNames;
	@Column(name = "last_name_user")
	private String userLastName;
	@Column(name = "phone_user")
	private String userPhone;
	@Column(name = "image_user")
	private String userImage;
	@Column(name = "nickname_user")
	private String userNickName;
	@Column(name = "password_user")
	private String password;
	@Column(name = "doc_number_user")
	private String dniNumber;	
	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rol_id", nullable = false)
	private Rol userRol;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "document_id", nullable = false)
	private Document document;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shoop_id", nullable = false)
	private Shoop shoop;
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserNames() {
		return userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDniNumber() {
		return dniNumber;
	}

	public void setDniNumber(String dniNumber) {
		this.dniNumber = dniNumber;
	}

	public Rol getUserRol() {
		return userRol;
	}

	public void setUserRol(Rol userRol) {
		this.userRol = userRol;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Shoop getShoop() {
		return shoop;
	}

	public void setShoop(Shoop shoop) {
		this.shoop = shoop;
	}
}