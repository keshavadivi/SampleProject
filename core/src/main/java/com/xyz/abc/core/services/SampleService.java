package com.xyz.abc.core.services;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate=true)
@Service(value=SampleServiceInt.class)

public class SampleService implements SampleServiceInt{

	@Reference
	ResourceResolverFactory factory;
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
	

	public void adNode(String path) {
		log.info("Entered into Serives and into addNode method");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put(ResourceResolverFactory.SUBSERVICE, "getResolver");	
		
	
			try {
				ResourceResolver	resolver = factory.getServiceResourceResolver(map);
			
		Resource resource = resolver.getResource(path);
		Node node = resource.adaptTo(Node.class);
		log.info("Node path is :: "+node.getPath());
		node.addNode("workflow").setPrimaryType("cq:PageContent");
		resolver.adaptTo(Session.class).save();
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchNodeTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (VersionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConstraintViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LockException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ItemExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PathNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	@Override
	public void adProperty(String path) {
		// TODO Auto-generated method stub
		log.info("Entered into Serives and into addNode method");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put(ResourceResolverFactory.SUBSERVICE, "getResolver");	
		
	
			try {
				ResourceResolver	resolver = factory.getServiceResourceResolver(map);
			
		Resource resource = resolver.getResource(path);
		Node node = resource.adaptTo(Node.class);
		log.info("Node path is :: "+node.getPath());
node.setProperty("Workflow", "added");
		resolver.adaptTo(Session.class).save();
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchNodeTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (VersionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConstraintViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LockException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ItemExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PathNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	
}
