package com.xyz.abc.core.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
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
import com.xyz.abc.core.SearchBean;


@Component(immediate=true)
@Service(value=SearchQuery.class)
public class SearchQueryImpl implements SearchQuery {
	@Reference
	ResourceResolverFactory factory;
	
	 protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public List getSearchItems(String word,SlingHttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put(ResourceResolverFactory.SUBSERVICE, "getResolver");	
		
		List<SearchBean> searchList= new ArrayList<SearchBean>();
			
				try {
					ResourceResolver	resolver = factory.getServiceResourceResolver(map);
					
					
					QueryBuilder builder = resolver.adaptTo(QueryBuilder.class);
					Session session = resolver.adaptTo(Session.class);
					Map<String,String> pMap = new HashMap<String,String>();
					map.put("path", "/content");
					map.put("fulltext",word);
					map.put("p.limit", "-1");
					
					
					Query query = builder.createQuery(PredicateGroup.create(map), session);
					SearchResult result = query.getResult();
					Iterator<Node> itr = result.getNodes();
					while(itr.hasNext()) {
					Node node = itr.next();
					log.info("Node in while loop :: "+node.getPath());
					
					
					SearchBean sBean = new SearchBean();
					sBean.setPath(node.getPath());
					sBean.setpName(node.getName());
					searchList.add(sBean);
					
						
					}
					
					
					
				} catch (LoginException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 
	 
		
		
		
		
		
		return searchList;
	}

}
