package com.douzone.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextLoaderLisener
 *
 */
//@WebListener
public class ContextLoaderListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }

	public void contextInitialized(ServletContextEvent servletContextEvent)  { 
        String contextConfigLocation = servletContextEvent.
        getServletContext().getInitParameter("contextConfigLocation"); 
		
        
        System.out.println("Container Starts...." + contextConfigLocation);
    }
	
}
