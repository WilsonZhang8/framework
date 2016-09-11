package com.zghw.framework.entity.simple;

import java.io.Serializable;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String memberName;
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
