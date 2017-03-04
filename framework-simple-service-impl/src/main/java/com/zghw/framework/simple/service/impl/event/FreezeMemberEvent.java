package com.zghw.framework.simple.service.impl.event;

import org.springframework.context.ApplicationEvent;

import com.zghw.framework.entity.simple.Member;

/**
 * 解冻会员事件
 * 
 * @author zghw
 *
 */
public class FreezeMemberEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private Member member;

	public FreezeMemberEvent(Object source, Member member) {
		super(source);
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
