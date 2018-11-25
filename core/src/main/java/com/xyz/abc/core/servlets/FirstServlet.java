package com.xyz.abc.core.servlets;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyz.abc.core.services.SampleService;

@SlingServlet(
		methods="GET",
		paths="/custom/firstServlet"
		)
public class FirstServlet extends SlingSafeMethodsServlet {
	
	@Reference
	SampleService sService;
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

	
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException{
		log.info("Entered into Servlet");
		
		//sService.adNode();
		
		/*ResourceResolver resolver = request.getResourceResolver();
		Resource resource = resolver.getResource("/content/samplePage/jcr:content");
log.info("Resource Path is ++ "+resource.getPath());
		Node node = resource.adaptTo(Node.class);
		
		Session session = resolver.adaptTo(Session.class);
		try {
			log.info("Resource adopted into Node as "+node.getName());
			node.setProperty("backend", "added");
			session.save();log.info("Added Property is "+node.getProperty("backend").getString());
		} catch (ValueFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VersionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
	}

}
