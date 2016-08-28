package com.zghw.framework.open.api.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zghw.framework.common.util.RequestUtils;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	public static Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("startTimeRequest");

	/**
	 * 进入请求记录日志
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long beginTime = System.currentTimeMillis();// 1、开始时间
		startTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）

		// 请求使用的协议及版本
		String protocol = request.getProtocol();
		// 获得客户端的主机名,如果没有就获取IP地址
		String remoteHost = RequestUtils.getIpAddr(request);
		// 客户端端口号
		int remotePort = request.getRemotePort();
		// 请求的URL不包含查询参数
		String requestURL = request.getRequestURL().toString();
		// Servlet中资源路径
		String servletPath = request.getServletPath();
		// 查询字符串以一系列“名/值”对的形式出现，名值对之间用字符“&”分隔
		String queryString = RequestUtils.getQueryParamMap(request).toString();
		logger.info("======请求    >>>  path:" + servletPath + "  param:" + queryString + "  URL:" + requestURL);
		logger.info("======客户端>>>  protocol:" + protocol + "  host： " + remoteHost + "  port:" + remotePort);
		return true;
	}

	/**
	 * 处理完请求记录日志
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long endTime = System.currentTimeMillis();// 2、结束时间
		long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
		long consumeTime = endTime - beginTime;// 3、消耗的时间
		logger.info("======请求完成 ，请求处理花费 "+consumeTime +" ms <<<<");
	}

}
