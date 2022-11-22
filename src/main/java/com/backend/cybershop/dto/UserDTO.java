package com.backend.cybershop.dto;

import com.backend.cybershop.entity.Document;
import com.backend.cybershop.entity.Rol;
import com.backend.cybershop.entity.Shoop;

public class UserDTO {

	private long userId;
	private String userNames;
	private String userLastName;
	private String userPhone;
	private String userImage;
	private String userNickName;
	private String password;
	private String dniNumber;
	private Rol userRol;
	private Document document;
	private Shoop shoop;

	public UserDTO() {
		super();
	}

	public UserDTO(long userId, String userNames, String userLastName, String userPhone, String userImage,
			String userNickName, String password, String dniNumber, Rol userRol, Document document, Shoop shoop) {
		super();
		this.userId = userId;
		this.userNames = userNames;
		this.userLastName = userLastName;
		this.userPhone = userPhone;
		this.userImage = userImage;
		this.userNickName = userNickName;
		this.password = password;
		this.dniNumber = dniNumber;
		this.userRol = userRol;
		this.document = document;
		this.shoop = shoop;
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
