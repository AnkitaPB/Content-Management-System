package filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.PageBean;
import beans.TemplateBean;
import beans.WebsiteBean;

import delegate.PageDelegate;
import delegate.TemplateDelegate;
import delegate.WebsiteDelegate;

public class URLFilter implements Filter{
	 
	private FilterConfig filterConfig;
	   

		public void init(FilterConfig filterConfig) throws ServletException {
			this.filterConfig=filterConfig;
		}

		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
			try{
			 	
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse res=(HttpServletResponse)response;
			System.out.println("**********You r in URLFilter****  ");
			String url=req.getRequestURI();
			System.out.println("Requested url is: "+url);  
		    int index=url.lastIndexOf('/');
		    int endIndex=url.indexOf(".jsp");
			
		 if(endIndex!=-1){	
		    System.out.println("extension index: "+endIndex);
			System.out.println("Index of last / in url: "+index);   
		    String pageName=url.substring(index+1, endIndex);
		    String [] temp=url.split("/");
		    String websiteName=temp[temp.length-2];
		  	System.out.println("above if");
	         
			    if(websiteName.compareToIgnoreCase("Pages")==0 || temp[temp.length-2].compareToIgnoreCase("include")==0){
					System.out.println("In way to login filter"+websiteName);  
			    	chain.doFilter(req, res);
					  
				  }
				  else{
			 	
	           	System.out.println("The new url is:"+url);
	           	System.out.println("Website name is: "+websiteName);
			    System.out.println("The requested page name is: "+pageName);  
			 	WebsiteDelegate webDelegate=new WebsiteDelegate();
			 	WebsiteBean websiteBean=new WebsiteBean();
			 	PageBean pageBean=new PageBean();
			 	TemplateBean templateBean=new TemplateBean();
			 	HashMap hMap=new HashMap();
			 	hMap=webDelegate.validateWebsite(websiteName);
			 	 if(hMap!=null){
			 		 System.out.println("Website validated");
			 	        websiteBean=webDelegate.getWebsiteByWebsiteName(websiteName);
			 	        pageBean.setPageName(pageName);
			 	        pageBean.setWebsiteKey(websiteBean.getWebsiteKey());
			 	        System.out.println("Website key in filter is: "+pageBean.getWebsiteKey());
			 	        PageDelegate pageDelegate=new PageDelegate();
			 	        pageBean=pageDelegate.checkPageExistenceByPageName(pageBean);
			 	        
				 	        if(pageBean.getPageKey()!=0){
				 	        	System.out.println("Template key in filter is: "+pageBean.getTemplateKey());
				 	        	TemplateDelegate templateDelegate=new TemplateDelegate();
				 	        	templateBean=templateDelegate.getTemplateByTemplateKey(pageBean.getTemplateKey());
				 	        	System.out.println("Template path is as: "+templateBean.getTemplatePath());
				 	    //    	index=templateBean.getTemplatePath().indexOf("shared");
				 	        	String path=templateBean.getTemplatePath();
				 	        	System.out.println(" path is: "+path);
				 	      //  	path.replace('\'', '/');
				 	        	RequestDispatcher disp;
				 	            disp=req.getRequestDispatcher("/".concat(path));
			 	        	  	req.setAttribute("websiteName", websiteName);
				 	        	req.setAttribute("pageName", pageName);
				 	        	disp.forward(req, res);
				 	        	
				 	        }
				 	        else{
				 	        	//send 404 error
				 	        System.out.println("Page not present");

			 	        	RequestDispatcher disp;
			 	            disp=req.getRequestDispatcher("/errorPages/errorPage404.jsp");
		 	        	  	req.setAttribute("errorMsg","Page Not Found Exception" );
			 	        	disp.forward(req, res);
				 	        }
				 	 }
				 	 else{
				 		 //send 404 error
				 		 System.out.println("Requested website is not present");
				 		RequestDispatcher disp;
		 	            disp=req.getRequestDispatcher("/errorPages/errorPage404.jsp");
	 	        	  	req.setAttribute("errorMsg","Website Not Found Exception" );
		 	        	disp.forward(req, res);
				 	 }
				  }
		 }
			}
		 	catch(Exception e){
		 		
		 	}
		   
				       return;
			  
		}
		
		public void destroy() {
		
		}
		
}
