 package com.xyz.abc.core.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.UnsupportedRepositoryOperationException;
import javax.jcr.Workspace;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;
import javax.jcr.observation.ObservationManager;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@Component(immediate=true)
@Service(value=EventListener.class)
public class SampleEventListeners implements EventListener {
	@Reference
	ResourceResolverFactory factory;
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    
    @org.apache.felix.scr.annotations.Activate
	public void Activate(final ComponentContext componentContext){
Map<String, Object> map = new HashMap<String, Object>();
		
		map.put(ResourceResolverFactory.SUBSERVICE, "getResolver");	
			try {
					ResourceResolver	resolver = factory.getServiceResourceResolver(map);
					Session session = resolver.adaptTo(Session.class);
					Workspace workspace = session.getWorkspace();
					ObservationManager obsManager = workspace.getObservationManager();
					String[] nodeType= {"cq:Page","cq:PageContent"};
					obsManager.addEventListener(this, 
												Event.PROPERTY_ADDED | Event.PROPERTY_CHANGED |Event.NODE_ADDED,
												"/content", 
												true, 
												null,
												nodeType, 
												false);
					
				} catch (LoginException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedRepositoryOperationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public void onEvent(EventIterator evnetItr) {
		log.info("Into On Event Method:: ");
		while(evnetItr.hasNext()) {
			
			try {
				log.info("Event Triggered at :: "+evnetItr.nextEvent().getPath());
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				log.info("Came into Exception");
				e.printStackTrace();
			}
		}
		
	}

}
