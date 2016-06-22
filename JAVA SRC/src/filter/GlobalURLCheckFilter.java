package filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalURLCheckFilter implements Filter {

	private FilterConfig filterConfig;
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig=filterConfig;
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
	      
		try{
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		System.out.println("**********You r in Global Filter****  ");
		String url=req.getRequestURI();
		
	 	System.out.println("Requested url in Global Filter is: "+url);  
	    String [] temp=url.split("/");
	    String rootName=temp[temp.length-2];
	     
		  if(rootName.compareToIgnoreCase("Pages")==0){
			  chain.doFilter(req, res);
			  
		  }
		  else{
			  chain.doFilter(req, res);
		  }
		}
		catch(Exception e){
			System.out.println("Exception in global filter: "+e);
		}
		}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	

}
