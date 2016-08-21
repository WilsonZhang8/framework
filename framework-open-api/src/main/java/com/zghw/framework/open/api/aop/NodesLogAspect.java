package com.zghw.framework.open.api.aop;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import com.zghw.framework.chain.ValueStack;

/**
 * 针对节点做的切面日志记录
 * 
 * @author zghw
 *
 */
@Aspect
@Component
public class NodesLogAspect {
	private Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * 定义切面 所有该目标下的doNode方法作为切面
	 * 
	 * @param valueStack
	 */
	@Pointcut("execution(public * com.zghw.framework.*.*.doNode(com.zghw.framework.chain.ValueStack)) && args(valueStack)")
	public void doNode(ValueStack valueStack) {

	}

	/**
	 * 使用环绕通知记录日志
	 * 
	 * @param pjp
	 * @param valueStack
	 * @return
	 */
	@Around(value = "doNode(valueStack)", argNames = "valueStack")
	public String doNodeAround(ProceedingJoinPoint pjp, ValueStack valueStack) {
		String result = null;
		// 前置通知设置
		Object target = pjp.getTarget();
		String nodeName = ClassUtils.getQualifiedName(target.getClass());
		logger.info(">>>>>>进入结点[" + nodeName + "]<<<<<<");
		try {
			result = String.valueOf(pjp.proceed());// 通过一个个通知方法拦截器链得到返回的对象。
		} catch (Throwable e) {
			logger.info(">>>>>>结点[" + nodeName + "]出现异常>>>>>>" + e.getMessage());
			e.printStackTrace();
		}
		// 后置通知
		logger.info("<<<<<<离开结点[" + nodeName + "]>>>>>>");
		return result;
	}
}
