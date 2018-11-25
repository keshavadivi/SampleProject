package com.xyz.abc.core;

import com.adobe.cq.sightly.WCMUsePojo;

public class Sighlty2Jva extends WCMUsePojo {
private String varible;
	public String getVarible() {
	return varible;
}
	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		String value1,value2;
		value1=get("value1",String.class);
		value2=get("value2",String.class);
		 varible = value1+" "+value2;
	}

}
