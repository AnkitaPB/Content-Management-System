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
import javax.servlet.http.HttpSession;

import beans.UserBean;

public class LoginFilter implements Filter{
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
			System.out.println("**********You r in Login Filter****  ");
			String url=req.getRequestURI();
	        int index=url.lastIndexOf("/");
	        String pageName=url.substring(index+1);
	        System.out.println("Page name in login filter is: "+pageName);
	         if(pageName.compareToIgnoreCase("index.jsp")==0 || pageName.compareToIgnoreCase("_login.jsp")==0){
	        	 
	        	 index=url.indexOf("pages");
	        	 System.out.println("index: "+index);
	        	 String temp=url.substring(index-1);
	        	 System.out.println("url in login if: "+temp);
	        	 RequestDispatcher disp;
	 	         disp=req.getRequestDispatcher(temp);
	 	         disp.forward(req, res);
	        	 }
	         else{
	            System.out.println("in login else");	
			         HttpSession session=req.getSession();
			         
			         UserBean userBean=new UserBean();
			         if(session.isNew()!=true){
				        	 userBean=(UserBean)session.getAttribute("userBean");  
				         	System.out.println("user name: "+userBean.getUserName());
				        
				        	 	if(userBean.getUserName()!=null){
					        	 RequestDispatcher disp;
					        	 String temp=url.substring(0);
					        	 index=url.indexOf("pages");
					        	 System.out.println("index: "+index);
					        	 temp=url.substring(index-1);
					        	 System.out.println("url in login else: "+temp);
					        	 disp=req.getRequestDispatcher(temp);
					 	         disp.forward(req, res);
					        	 }
				        	 else{
				        		 RequestDispatcher disp;
					 	         disp=req.getRequestDispatcher("/pages/index.jsp");
					 	         disp.forward(req, res);
					        	 
				        	 }
		    
	               }
		           else{
		        	   RequestDispatcher disp;
			 	         disp=req.getRequestDispatcher("/pages/index.jsp");
			 	         disp.forward(req, res);
			        	
		           }
	         }
		}
		catch(Exception e){
			System.out.println("Exception in LoginFilter:   "+e);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
