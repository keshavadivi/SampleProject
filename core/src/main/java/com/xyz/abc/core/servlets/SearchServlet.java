package com.xyz.abc.core.servlets;

import java.util.Iterator;
import java.util.List;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyz.abc.core.SearchBean;
import com.xyz.abc.core.services.SampleService;
import com.xyz.abc.core.services.SearchQuery;

@SlingServlet(
		methods="GET",
		paths="/custom/search"
		)
public class SearchServlet extends SlingSafeMethodsServlet {

	@Reference
	SearchQuery search;
	
	final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException{
		log.info("Entered into Servlet");
		response.setContentType("text/html");
		String word = request.getParameter("query");
		List<SearchBean> list = search.getSearchItems(word,request);
		
		Iterator<SearchBean> itr = list.iterator();
		while(itr.hasNext()) {
			SearchBean searchitr = itr.next();
			
			response.getOutputStream().println("<h2>"+searchitr.getpName()+"</h2> ------ + <a href="+searchitr.getPath()+".html"+">"+searchitr.getPath()+"</a>");
			;
			;
			
			
		}
	
		
	}

}
