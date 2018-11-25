package com.xyz.abc.core.query;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;

@Component
@Service(value=SampleQuery.class)
public class SampleQuery {
	
	@Reference
	ResourceResolverFactory factory;
	
	 protected final Logger log = LoggerFactory.getLogger(this.getClass());
       
	 
	 public void getFulltextSearch() {
		 
		 log.info("Entered into Serives and into addNode method");
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put(ResourceResolverFactory.SUBSERVICE, "getResolver");	
			
		
				
					try {
						ResourceResolver	resolver = factory.getServiceResourceResolver(map);
						
						
						QueryBuilder builder = resolver.adaptTo(QueryBuilder.class);
						Session session = resolver.adaptTo(Session.class);
						Map<String,String> pMap = new HashMap<String,String>();
						map.put("path", "/content");
						map.put("fulltext", "autem");
						map.put("p.limit", "-1");
						
						
						Query query = builder.createQuery(PredicateGroup.create(map), session);
						SearchResult result = query.getResult();
						Iterator<Node> itr = result.getNodes();
						List<Hit> hits = result.getHits();
						
						
						
						
					} catch (LoginException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 
		 
		 
	 }
	
	

}
