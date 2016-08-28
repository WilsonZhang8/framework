package com.zghw.framework.http;

import java.io.Serializable;

/**
 * url路径
 * 
 * @author zghw
 *
 */
public class WebURL implements Serializable {
	private static final long serialVersionUID = 1L;
	private String url;
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 返回一个url地址
	 */
	@Override
	public String toString() {
		if (url != null && !url.isEmpty()) {
			if (path != null && !path.isEmpty()) {
				return url + path;
			}
			return url;
		}
		return super.toString();
	}
}
