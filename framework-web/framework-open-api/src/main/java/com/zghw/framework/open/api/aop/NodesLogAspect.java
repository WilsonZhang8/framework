package com.zghw.framework.open.api.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import com.alibaba.dubbo.common.json.JSON;
import com.zghw.framework.chain.ChainConstant;
import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.object.dto.Result;

/**
 * 针对节点做的切面日志记录
 * 
 * @author zghw
 *
 */
@Aspect
@Component
public class NodesLogAspect {
	public static Logger logger = LoggerFactory.getLogger(NodesLogAspect.class);

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
	public String doNodeAround(ProceedingJoinPoint pjp, ValueStack valueStack) throws Exception {
		String result = null;
		// 前置通知设置
		Object target = pjp.getTarget();
		String nodeName = ClassUtils.getQualifiedName(target.getClass());
		logger.info(">>>>>>进入结点[" + nodeName + "]<<<<<<");
		try {
			result = String.valueOf(pjp.proceed());// 通过一个个通知方法拦截器链得到返回的对象。
			// 后置通知
			logger.info("<<<<<<离开结点[" + nodeName + "]>>>>>>");
			if (valueStack.getValue(ChainConstant.RESULT) != null) {
				Result res = (Result) valueStack.getValue(ChainConstant.RESULT);
				logger.info("<<<<<<处理的result结果为：>>>>>>" + JSON.json(res));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			logger.info(">>>>>>结点[" + nodeName + "]出现异常>>>>>>" + e.getMessage());
			throw new Exception(e);
		}
		return result;
	}
}
