package filter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.UserBean;

public class LoginCheck {
   
	 public String loginCheck(String url,HttpServletRequest req){
		 
		 System.out.println("**********You r in Login Check**** url is: "+url);
		    int index=url.lastIndexOf("/");
	        String pageName=url.substring(index+1);
	        System.out.println("Page name in login filter is: "+pageName);
	         
	       if(pageName.compareToIgnoreCase("index.jsp")==0 || pageName.compareToIgnoreCase("_login.jsp")==0 || pageName.compareToIgnoreCase("password.jsp")==0 || pageName.compareToIgnoreCase("_password.jsp")==0 || pageName.compareToIgnoreCase("registration.jsp")==0 || pageName.compareToIgnoreCase("_registration.jsp")==0){
	        	 
	        	 index=url.indexOf("pages");
	        	 System.out.println("index: "+index);
	        	 String newURL=url.substring(index-1);
	        	 System.out.println("url in login if: "+newURL);
	        	 return newURL;
	        }
	      else{
	       
	    	     System.out.println("in login else");	
			     UserBean userBean=new UserBean();
		//	     HttpServletRequest req;
			         HttpSession session=req.getSession();
		
			         userBean=(UserBean)session.getAttribute("userBean");
			         //session.isNew();
					if(userBean!=null){
				        	
						    //userBean=(UserBean)session.getAttribute("userBean");  
				           	System.out.println("user name: "+userBean.getUserName());
				        
				        	 	if(userBean.getUserName()!=null){
					        	
					        	 String temp;
					        	 index=url.indexOf("pages");
					        	 System.out.println("index: "+index);
					        	 temp=url.substring(index-1);
					        	 System.out.println("url in login else: "+temp);
					               return temp;
					        	 //	 disp=req.getRequestDispatcher(temp);
					 	      //   disp.forward(req, res);
					        	 }
				        	 else{
				        		  System.out.println("Else of userBean.getUserName()");
				        	       return "/pages/index.jsp";
				        		// disp=req.getRequestDispatcher("/pages/index.jsp");
					 	         //disp.forward(req, res);
					        	 
				        	 }
		    
	               }
		           else{
		        	   System.out.println("else of userbean!=null");
		                   return  "/pages/index.jsp";
		        	   //  disp=req.getRequestDispatcher("/pages/index.jsp");
			 	         //disp.forward(req, res);
			        	
		           }
		   
	 }
	   
  }
}	 
	 
