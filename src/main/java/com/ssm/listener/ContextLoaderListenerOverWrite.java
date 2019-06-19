package com.ssm.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class ContextLoaderListenerOverWrite extends ContextLoaderListener {
	
	 
	     @Override  
	     /** 
	     * @description 重写ContextLoaderListener的contextInitialized方法 
	     */  
	    public void contextInitialized(ServletContextEvent event) {  
	        super.contextInitialized(event);  
	        WebApplicationContext springContext =  WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()); 	     
	    }  
}
