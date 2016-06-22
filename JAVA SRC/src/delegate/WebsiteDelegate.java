package delegate;

import java.util.ArrayList;
import java.util.HashMap;

import dao.WebsiteDAO;

import beans.ErrorBean;
import beans.TemplateBean;
import beans.UserAccessBean;

import beans.WebsiteBean;

public class WebsiteDelegate {

  private boolean status;
  WebsiteDAO websiteDAO=null;

  public WebsiteDelegate()
  {
      websiteDAO=new WebsiteDAO();
  }

  public HashMap validateWebsite(String websiteName)throws Exception{

     ErrorBean errorBean=null;

    if(websiteName=="")
    {
      errorBean=new ErrorBean();
      errorBean.setErrorKey("WebsiteNullError");
      errorBean.setErrorMsg("Please, Enter Website Name..");
    }
    else
    {
    	if(websiteName.contains(" "))
    	{
    		  errorBean=new ErrorBean();
    	      errorBean.setErrorKey("InvalideWebsiteNameError");
    	      errorBean.setErrorMsg("Please, Enter Website Name without space..");
    		
    	}
    	status=websiteDAO.checkWebsiteExistence(websiteName);
      if(status==true)
      {
        errorBean=new ErrorBean();
        errorBean.setErrorKey("WebsiteAlreadyPresentError");
        errorBean.setErrorMsg("Website Name Already Exist..");
      }
    }

    if(errorBean!=null){
      HashMap<String, ErrorBean> errorHashMap=new HashMap<String, ErrorBean>();
      errorHashMap.put(errorBean.getErrorKey(),errorBean);
      return errorHashMap;
    }

      return null;
  }

  public HashMap isWebsiteAlreadyExist(WebsiteBean websiteBean,int userKey)throws Exception{

      ErrorBean errorBean=null;

    if(websiteBean.getActiveFlag()=="")
    {
      errorBean=new ErrorBean();
      errorBean.setErrorKey("WebsiteNullError");
      errorBean.setErrorMsg("Please, Enter Website Name..");
    }

    else{
      status=websiteDAO.checkWebsiteAccess(websiteBean.getWebsiteKey(),userKey);
      if(status==false)
      {
        errorBean=new ErrorBean();
        errorBean.setErrorKey("AccessDeniedError");
        errorBean.setErrorMsg("Access Denied");
      }
    }

    if(errorBean!=null){
      HashMap<String, ErrorBean> errorHashMap=new HashMap<String, ErrorBean>();
      errorHashMap.put(errorBean.getErrorKey(),errorBean);
      return errorHashMap;
    }

    return null;
  }

  
  public String getWebsiteName(int websiteKey) throws Exception{
     return websiteDAO.getWebsiteNameByWebsiteKey(websiteKey);
    
  }

  public void updateWebsiteDate(String websiteName) throws Exception
  {
	  websiteDAO.updateWebsiteModifiedDate(websiteName);
  }
  
    public WebsiteBean getWebsiteByWebsiteKey(int key)throws Exception{
    return websiteDAO.getWebsiteByWebsiteKey(key);
  }

  public void createUserAccess(UserAccessBean userBean)throws Exception
  {
            websiteDAO.createUserAccess(userBean);
  }
  public TemplateBean getTemplateByTemplateKey(int templateKey) throws Exception{
	 
	  return websiteDAO.getTemplateByTemplateKey(templateKey);
  }
 public WebsiteBean getWebsiteByWebsiteName(String websiteName) throws Exception{
	   
      
	    return websiteDAO.getWebsiteByWebsiteName(websiteName);
    
 }

 public void createWebsite(String websiteName)throws Exception
 {
	  
   websiteDAO.createWebsite(websiteName);
   
  
 }
 public ArrayList getWebsiteByUserKey(int userKey) throws Exception{
	 return websiteDAO.getWebsiteByUserKey(userKey);
 }
 
 public ArrayList getWebsiteNameByUserKey(int userKey) throws Exception{
	 return websiteDAO.getWebsiteNameByUserKey(userKey);
 }
 
 public void updateWebsiteModifiedDate(String websiteName) throws Exception
 {
	 websiteDAO.updateWebsiteModifiedDate(websiteName);
 }
 public void renameWebsite(String oldWebsiteName,String newWebsiteName)throws Exception
 {
	websiteDAO.renameWebsite(oldWebsiteName, newWebsiteName); 
 }
 public void deleteWebsite(String websiteName)throws Exception
 {
	 websiteDAO.deleteWebsite(websiteName);
 }

}

