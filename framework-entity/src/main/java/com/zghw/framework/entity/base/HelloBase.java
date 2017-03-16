package com.zghw.framework.entity.base;

import java.io.Serializable;

public class HelloBase implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Integer hits;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}
}
