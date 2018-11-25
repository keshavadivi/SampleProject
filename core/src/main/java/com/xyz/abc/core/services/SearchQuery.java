package com.xyz.abc.core.services;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;

import com.xyz.abc.core.SearchBean;

public interface SearchQuery {

	public List<SearchBean> getSearchItems(String word, SlingHttpServletRequest request);

}
