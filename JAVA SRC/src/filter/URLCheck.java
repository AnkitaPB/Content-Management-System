package filter;

import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.PageBean;
import beans.TemplateBean;
import beans.WebsiteBean;
import delegate.PageDelegate;
import delegate.TemplateDelegate;
import delegate.WebsiteDelegate;

public class URLCheck {

	public String urlCheck(String url){
	
	  try{	
		System.out.println("url in URLCheck class: "+url);  
	    int index=url.lastIndexOf('/');
	    int endIndex=url.indexOf(".jsp");
	 
	    String pageName=url.substring(index+1, endIndex);
	    String [] temp=url.split("/");
	    String websiteName=temp[temp.length-2];
	  	System.out.println("website name in urlCheck is: "+websiteName);
        System.out.println("page name in urlcheck: "+pageName);  
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
			 	        	String path=templateBean.getTemplatePath();
			 	        	System.out.println(" path is: "+path);
			 	        	return path;
			 	        	
			 	        	/*disp=req.getRequestDispatcher("/".concat(path));
		 	        	  	req.setAttribute("websiteName", websiteName);
			 	        	req.setAttribute("pageName", pageName);
			 	        	disp.forward(req, res);
			 	          */
			 	        }
			 	        else{
			 	        	//send 404 error
			 	        	String errorPagePath="/errorPages/errorPage404.jsp?errorMsg='Page Not Found Exception'";
			 	        	return errorPagePath;
			 	        /*System.out.println("Page not present");
			            disp=req.getRequestDispatcher("/errorPages/errorPage404.jsp");
	 	        	  	req.setAttribute("errorMsg","Page Not Found Exception" );
		 	        	disp.forward(req, res);*/
			 	        }
			 	 }
			 	 else{
			 		 //send 404 error
			 		String errorPagePath="/errorPages/errorPage404.jsp?errorMsg='Website Not Found Exception'";
	 	        	return errorPagePath;
	 	       
			 	/*	 System.out.println("Requested website is not present");
			 		 disp=req.getRequestDispatcher("/errorPages/errorPage404.jsp");
 	        	  	 req.setAttribute("errorMsg","Website Not Found Exception" );
	 	        	 disp.forward(req, res);*/
			 	 }
	}		  
	 catch(Exception e){
		  System.out.println("Exception in urlcheck is: "+e);
		 
	 }
	 
	 return null;
  }
}
