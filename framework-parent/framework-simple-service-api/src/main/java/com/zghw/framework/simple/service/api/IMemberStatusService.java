package com.zghw.framework.simple.service.api;

import com.zghw.framework.entity.simple.Member;

public interface IMemberStatusService {

	/**
	 * 冻结会员后置处理
	 * 
	 * @param member
	 */
	public void freezeMemberPostHandle(Member member);

	/**
	 * 解冻会员后置处理
	 * 
	 * @param member
	 */
	public void unFreezeMemberPostHandle(Member member);
}
