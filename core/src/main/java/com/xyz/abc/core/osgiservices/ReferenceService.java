package com.xyz.abc.core.osgiservices;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=Runnable.class,property= { "scheduler.expression= 0 0/1 * 1/1 * ? *"},immediate=true)
public class ReferenceService implements Runnable{
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

	private SampleOsgiService service;
	
	@Reference
	public void bindSampleOsgiService(SampleOsgiService service) {
		this.service=service;
	}
	public void unbindSampleOsgiService(SampleOsgiService service) {
		this.service=service;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		log.info("From Schedular");
		 // log.info("From OSGI Service "+service.hello());	
		}

	
}
