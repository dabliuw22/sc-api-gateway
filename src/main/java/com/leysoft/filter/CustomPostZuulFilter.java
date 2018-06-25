package com.leysoft.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class CustomPostZuulFilter extends ZuulFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomPostZuulFilter.class);
	
	private int id = 1;
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
		response.addHeader("X-Response-ID", String.valueOf(id++));
		LOGGER.info("response -> {} response status -> {}", response, response.getStatus());
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 5;
	}
}
