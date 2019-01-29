package com.douzone.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/")
public class EncodingFilter implements Filter {
	
	private String encoding;
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Encoding Filter initialized...");
		
		encoding = fConfig.getInitParameter("encoding");
		
		if(encoding == null) {
			encoding = "UTF-8";
		}
	}

	
    public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* request 처리 */
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
		/* response 처리*/
	}

	
}
