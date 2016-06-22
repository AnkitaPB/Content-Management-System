package delegate;
import java.util.ArrayList;
import java.util.HashMap;
import beans.ErrorBean;
import beans.PageBean;
import beans.TemplateBean;
import beans.WebsiteBean;
import dao.PageDAO;


  public class PageDelegate {//extends Delegate{


    PageDAO pageDAO=null;
    public PageDelegate()
    {
          pageDAO=new PageDAO();

     }
    public HashMap validatePageName(PageBean pageBean,TemplateBean templateBean) throws Exception{

          boolean status;
            ErrorBean errorBean=null;
      
          if(pageBean.getPageName()==null)
          {System.out.println("Page name in delegate: "+pageBean.getPageName());
            errorBean=new ErrorBean();
            errorBean.setErrorKey("PageNameNullError");
            errorBean.setErrorMsg("Please, Enter Page Name..");
          }
          else if(templateBean.getTemplateName()==""){
            System.out.println("template check in delegate: ");
            errorBean=new ErrorBean();
            errorBean.setErrorKey("TemplateNullError");
            errorBean.setErrorMsg("Please, Select Template..");

          }
          else{
            System.out.println("Page name in check existance delegate: "+pageBean.getPageName());
            status=pageDAO.checkPageExistence(pageBean);
              if(status==true)
                {
                errorBean=new ErrorBean();
                errorBean.setErrorKey("PageNameAlreadyPresentError");
                errorBean.setErrorMsg("Page Name Already Exist..");

                }
               }
           if(errorBean!=null){
             HashMap<String, ErrorBean> errorHashMap=new HashMap<String, ErrorBean>();
               errorHashMap.put(errorBean.getErrorKey(),errorBean);
             return errorHashMap;
           }

             return null;
 }

    public boolean checkDefaultPageExistence(int websiteKey) throws Exception{
  	  return pageDAO.checkDefaultPageExistence(websiteKey);
    }

    public PageBean checkPageExistenceByPageName(PageBean pageBean) throws Exception{
    	return pageDAO.checkPageExistenceByPageName(pageBean);
    	
    }
/*
  public void createPageRecord(PageBean pageBean,TemplateBean templateBean) throws Exception{
                   boolean status=false;
          //  TemplateBean templateBean=new TemplateBean();
            
                	   	  System.out.println("Page name:"+pageBean.getPageName());
		                  templateBean=pageDAO.getTemplateKey(templateBean);
		                  pageBean.setTemplateKey(templateBean.getTemplateKey());
		                  //pageKey=pageDAO.createPage(pb);
		                  pageDAO.createPage(pageBean);
		                    
		                  System.out.println("Status in Delegate create is: "+status);

            
           
          }  */
    public void createPageRecord(PageBean pageBean,TemplateBean templateBean,String defaultPageStatus,boolean overWriteStatus) throws Exception{
        boolean status=false;
//  TemplateBean templateBean=new TemplateBean();
    	  System.out.println("*************default Page status:"+defaultPageStatus);
    	System.out.println("*********default Page overwrite status:"+overWriteStatus);
          
     	   	  System.out.println("Page name:"+pageBean.getPageName());
               templateBean=pageDAO.getTemplateKey(templateBean);
               pageBean.setTemplateKey(templateBean.getTemplateKey());
               //pageKey=pageDAO.createPage(pb);
               pageDAO.createPage(pageBean,defaultPageStatus,overWriteStatus);
                 
               System.out.println("Status in Delegate create is: "+status);

 

}

  public PageBean getPageByPageName(PageBean pageBean) throws Exception{
	  
	     pageBean=pageDAO.getPageByPageName(pageBean);
	     return pageBean;
  }
  public PageBean getDefaultPageByWebsite(String websiteName)throws Exception
  {
	  return pageDAO.getDefaultPageByWebsite(websiteName);
	  	  
  }

/*
  public String getCode(PageBean pageBean)throws Exception
  {
    return pageDAO.getCode(pageBean);
  }
*/
 /* public String getCode(String websiteName,String pageName,String templateName)throws Exception
  {
	  System.out.println("********In PageDel getCode() Method*******");
    return pageDAO.getCode(websiteName,pageName,templateName);
  }*/
  public ArrayList getAllPageName(WebsiteBean websiteBean)throws Exception
  {
    return pageDAO.getAllPageName(websiteBean);
  }
  public String getWebsiteName(int key)throws Exception{
    return pageDAO.getWebsiteName(key);
  }
  public PageBean getAllPageNameByWebsite(String websiteName)throws Exception
  {
	  return pageDAO.getAllPageNameByWebsite(websiteName);
	  	  
  }

 
/*  public int getPageByWebsiteName(String pageName,String websiteName)throws Exception
  {
    //PageBean pageBean=null;
     int j=0;
    rs=pageDAO.getPageByWebsiteName(pageName,websiteName);
    while(rs.next())
    {
     j=rs.getInt("pagekey");
      pageBean.setPageKey(rs.getInt("websitekey"));
      pageBean.setPageKey(rs.getInt("pagename"));
      pageBean.setPageKey(rs.getInt("templatekey"));

   }
    return j;
   
  }*/
  public StringBuffer getPageCode(PageBean pageBean)throws Exception
  {
    return pageDAO.getPageCode(pageBean);
  }

  public PageBean  getPageByPageNameAndWebsiteKey(String pageName,int websiteKey)throws Exception
  {
	  System.out.println("pageNmae :"+pageName);
	  System.out.println("web key;"+websiteKey);
	  
    PageBean pageBean=new PageBean();
    pageBean=pageDAO.getPageByPageNameAndWebsiteKey(pageName, websiteKey);
    return pageBean;
   }
public void deletePage(String pageName,int websiteKey)throws Exception
{
	pageDAO.deletePage(pageName,websiteKey);
}
public void updatePage(String oldPageName,String pageName,int websiteKey)throws Exception
{
	pageDAO.updatePage(oldPageName,pageName,websiteKey);
} 
  }