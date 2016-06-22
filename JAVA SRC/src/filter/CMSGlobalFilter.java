package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.WebsiteBean;

import delegate.WebsiteDelegate;

public class CMSGlobalFilter implements Filter{

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
			String url=req.getRequestURI();
			 System.out.println("********You are in CMSGlobalFilter******** url is"+url);
			 
			 String [] temp=url.split("/");
			    String websiteName=temp[temp.length-2];
			    if(websiteName.compareToIgnoreCase("Pages")==0 || websiteName.compareToIgnoreCase("include")==0){
			    	//go to login filter
                   LoginCheck login=new LoginCheck();
                   String newPath=login.loginCheck(url, req);
                   System.out.println("new path in CMSGlobalfilter: "+newPath);
                   RequestDispatcher disp;
				   disp=req.getRequestDispatcher(newPath);
				   disp.forward(req, res);	  
				  }
				  else{
					  //go to url filter
					  URLCheck check=new URLCheck();
					  String templatePath=check.urlCheck(url);
					  System.out.println("templatepath i filter is: "+templatePath);
					  int index=url.lastIndexOf('/');
					  int endIndex=url.indexOf(".jsp");
					  String pageName=url.substring(index+1, endIndex);
				      System.out.println("website name is: "+websiteName+" page naem:  "+pageName); 
				      RequestDispatcher disp;
				      disp=req.getRequestDispatcher(templatePath);
	 	        	 	req.setAttribute("websiteName", websiteName);
		 	        	req.setAttribute("pageName", pageName);
		 	        	WebsiteDelegate webDelegate=new WebsiteDelegate();
		 	        	WebsiteBean websiteBean=new WebsiteBean();
		 	        	websiteBean=webDelegate.getWebsiteByWebsiteName(websiteName);
		 	        	if(websiteBean!=null){
			 	        	req.setAttribute("cssPath", websiteBean.getCssPath());
			 	        	req.setAttribute("javascriptPath", websiteBean.getJavascriptPath());
			 	        	
			 	        	System.out.println("css path in filter:"+websiteBean.getCssPath());
			 	        	}
		 	        	
		 	        	
		 	        	  
		 	        	disp.forward(req, res);
				  }
		}
		catch(Exception e){
		  System.out.println("Exception in filter: "+e.toString());	
		}
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

}
