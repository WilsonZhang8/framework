package com.zghw.framework.open.api.module.base.chain.A1_BASE_002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.entity.simple.Member;
import com.zghw.framework.simple.service.api.IMemberStatusService;

/**
 * 处理节点
 * 
 * @author zghw
 *
 */
public class HandleNode extends AbstractNode {
	public static Logger logger = LoggerFactory.getLogger(HandleNode.class);
	private IMemberStatusService memberStatusService;

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		String option = valueStack.getString("option");
		Member member = new Member();
		member.setId(1l);
		member.setMemberName("测试");
		member.setStatus(option);
		if (option.equals("1")) {
			logger.info("进入冻结会员后置处理！");
			memberStatusService.freezeMemberPostHandle(member);
		} else if (option.equals("0")) {
			logger.info("进入解冻会员后置处理！");
			memberStatusService.unFreezeMemberPostHandle(member);
		}

		return NEXT;
	}

	@Autowired
	public void setMemberStatusService(@Qualifier("memberStatusService") IMemberStatusService memberStatusService) {
		this.memberStatusService = memberStatusService;
	}
}
