package com.zghw.framework.simple.service.impl.event;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.json.JSON;
import com.zghw.framework.entity.open.api.dto.simple.MemberStatusInfo;
import com.zghw.framework.entity.simple.Member;
import com.zghw.framework.http.service.api.internal.ISimpleService;

/**
 * 解冻会员监听器，监听到事件就开始发送。 实现ApplicationListener
 * 
 * @author zghw
 *
 */
@Component
public class UnFreezeMemberListenter implements ApplicationListener<UnFreezeMemberEvent> {
	public static Logger logger = LoggerFactory.getLogger(UnFreezeMemberListenter.class);
	private ISimpleService simpleService;

	/**
	 * 监听解冻会员事件，当有事件发生则调用该方法
	 */
	@Override
	public void onApplicationEvent(UnFreezeMemberEvent event) {
		Member member = event.getMember();
		logger.info("调用解冻会员事件");
		MemberStatusInfo memberStatusInfo = new MemberStatusInfo();
		BeanUtils.copyProperties(member, memberStatusInfo);
		try {
			// 发送到其他站点使用
			simpleService.memberStatus(JSON.json(memberStatusInfo));
			logger.info("发送到API使用");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Autowired
	public void setSimpleService(@Qualifier("simpleService") ISimpleService simpleService) {
		this.simpleService = simpleService;
	}

}
