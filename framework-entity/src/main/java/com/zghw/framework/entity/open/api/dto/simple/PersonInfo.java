package com.zghw.framework.entity.open.api.dto.simple;

import java.io.Serializable;
import java.util.List;

public class PersonInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idType;
	private String idNo;
	private String name;
	private List<String> hobby;
	private String telphone;

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

}
