package com.xyz.abc.core.osgiservices;

import org.osgi.service.component.annotations.Component;

@Component(service=SampleOsgiService.class, immediate =true)
public class SampleOsgiService {

	
	public String hello() {
		
		
		return "Hello How r u";
		
		
	}
	
}
