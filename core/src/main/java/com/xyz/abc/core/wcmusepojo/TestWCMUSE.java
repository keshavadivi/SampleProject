package com.xyz.abc.core.wcmusepojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;

public class TestWCMUSE extends WCMUsePojo{

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

	
	private String javaDecs;
	public String getJavaDecs() {
		return javaDecs;
	}
	public String getJavaImg() {
		return javaImg;
	}
	private String javaImg;
	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		javaDecs = getProperties().get("./desc", "null");
		
		javaImg = getProperties().get("./img", "null");
		
		log.info("Current Component Name is :: "+getComponent().getName());
		
		log.info("Value of Java Img is "+javaImg+" and Jva Description"+javaDecs);
	}

}
