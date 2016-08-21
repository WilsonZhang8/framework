package com.zghw.framework.open.api.module.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zghw.framework.chain.Chain;
import com.zghw.framework.chain.ValueStack;

@Component
public class BaseController {

	private Chain chain_A1_BASE_001;

	public String getInfo(){
		ValueStack valueStack=new ValueStack();
		try {
			chain_A1_BASE_001.doChain(valueStack);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "result";
	}
	
	@Autowired
	public void setChain_A1_BASE_001(@Qualifier("chain_A1_BASE_001") Chain chain_A1_BASE_001) {
		this.chain_A1_BASE_001 = chain_A1_BASE_001;
	}
}
