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
 * 冻结会员监听器，监听到事件就开始发送。 实现ApplicationListener
 * 
 * @author zghw
 *
 */
@Component
public class FreezeMemberListenter implements ApplicationListener<FreezeMemberEvent> {
	public static Logger logger = LoggerFactory.getLogger(FreezeMemberListenter.class);
	private ISimpleService simpleService;

	/**
	 * 监听冻结会员事件，当有事件发生则调用该方法
	 */
	@Override
	public void onApplicationEvent(FreezeMemberEvent event) {
		logger.info("调用冻结会员事件");
		Member member = event.getMember();
		final MemberStatusInfo memberStatusInfo = new MemberStatusInfo();
		BeanUtils.copyProperties(member, memberStatusInfo);
		// 开启线程异步跑任务
		new Thread() {
			@Override
			public void run() {
				try {
					logger.info("开始发送到API使用");
					// 设置几秒模拟异步效果
					Thread.sleep(9000);
					// 发送到其他站点使用
					simpleService.memberStatus(JSON.json(memberStatusInfo));
					logger.info("发送到API使用完成");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		logger.info("发送到API使用");
	}

	@Autowired
	public void setSimpleService(@Qualifier("simpleService") ISimpleService simpleService) {
		this.simpleService = simpleService;
	}

}
