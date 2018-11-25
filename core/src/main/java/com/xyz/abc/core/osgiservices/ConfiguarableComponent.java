package com.xyz.abc.core.osgiservices;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Runnable.class, configurationPolicy = ConfigurationPolicy.REQUIRE, immediate = true)
@Designate(ocd = ConfiguarableComponent.MyServiceConfiguration.class )

public class ConfiguarableComponent  implements Runnable{
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@ObjectClassDefinition(name = "My Service Configuration", description = "Service Configuration")
	
	public static @interface MyServiceConfiguration{
		
		@AttributeDefinition(name="CronJob-Expression")
	        String scheduler_expression() default "*/30 * * * * ?";
		
		
		@AttributeDefinition(name="Name", description ="Follow Uppercase Letters")
        String name() ;

		
		
	}
	private String oName;

	@Activate
	public void activate(MyServiceConfiguration config) {
		
		oName = config.name();
		log.info("Name :: "+oName);
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		log.info("Enetered Schedular");
	}

}
