package com.zghw.framework.simple.service.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.zghw.framework.entity.simple.Member;
import com.zghw.framework.simple.service.api.IMemberStatusService;
import com.zghw.framework.simple.service.impl.event.FreezeMemberEvent;
import com.zghw.framework.simple.service.impl.event.UnFreezeMemberEvent;

@Service
public class MemberStatusService implements IMemberStatusService, ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

	@Override
	public void freezeMemberPostHandle(Member member) {
		FreezeMemberEvent freezeMemberEvent = new FreezeMemberEvent(this, member);
		publisher.publishEvent(freezeMemberEvent);
	}

	@Override
	public void unFreezeMemberPostHandle(Member member) {
		UnFreezeMemberEvent unFreezeMemberEvent = new UnFreezeMemberEvent(this, member);
		publisher.publishEvent(unFreezeMemberEvent);
	}
}
