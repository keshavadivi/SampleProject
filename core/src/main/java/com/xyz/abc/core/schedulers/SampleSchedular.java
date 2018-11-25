package com.xyz.abc.core.schedulers;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyz.abc.core.services.SampleService;
import com.xyz.abc.core.services.SampleServiceInt;

@Component(immediate=true)
@Service(value=Runnable.class)
@Property(name = "scheduler.expression", value ="0 0/1 * 1/1 * ? *")
public class SampleSchedular implements Runnable{
	@Reference
	public SampleServiceInt service;
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run() {
		// TODO Auto-generated method stub
		log.info("From Schedular :: ");
		//service.adNode();
	}

}
