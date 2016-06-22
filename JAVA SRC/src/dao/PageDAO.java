package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import beans.PageBean;
import beans.TemplateBean;
import beans.WebsiteBean;

public class PageDAO extends CommonDAO{

    protected static final String PAGE_QUERY ="select * from page where active_flag='Y' and website_key=? and page_Name=?";
      protected static final String PAGE_INSERT_QUERY="insert into page(website_key,template_key,page_name,active_flag,default_page) values(?,?,?,?,?)";
      protected static final String PAGE_DELETE_QUERY="update page set active_flag='N' where page_Name=? and website_key=?";
      protected static final String PAGE_UPDATE_QUERY="update page set page_name=? where active_flag='Y' and page_name=? and website_key=?";
      protected static final String PAGE_NAME_QUERY="Select * from page p,template t where p.template_key=t.template_key and website_key= ? and p.active_flag='Y' order by page_name";
      protected static final String PAGE_NAME_BY_WEBSITE_QUERY="Select * from page p where p.active_flag='Y' and p.website_key= ? ";
      protected static final String DEFAULT_PAGE_QUERY="Select * from page p where p.active_flag='Y' and p.website_key= ? and p.default_page='Y'";
      protected static final String DEFAULT_PAGE_UPDATE_QUERY="update page set default_page=? where active_flag='Y' and website_key=?";
      protected static final String DEFAULT_PAGE_BY_WEBSITE_QUERY="Select * from page p where  p.active_flag='Y' and p.default_page='Y' and p.website_key= ?";
      
      public PageDAO()
      {
           super();
           super.initConnection();
      }

      public boolean checkPageExistence(PageBean pageBean)throws Exception    //check whether page already exist or not
      {

      boolean status=false;
      PreparedStatement ps;
      ResultSet rs;
      ps = con.prepareStatement(PAGE_QUERY);
      ps.setInt(1, pageBean.getWebsiteKey());
      ps.setString(2,pageBean.getPageName());
      rs = ps.executeQuery();

      if(rs.next()){
        status=true;

      }
      else{
          status=false;
      }
      return status;
    }

      public boolean checkDefaultPageExistence(int websiteKey) throws Exception{
    	  PreparedStatement ps;
          ResultSet rs;
          ps = con.prepareStatement(DEFAULT_PAGE_QUERY);
          ps.setInt(1, websiteKey);
          rs = ps.executeQuery();

          if(rs.next()){
           
        	  return true;

          }
          else{
         	   return false;
            }
    	
    }

      public PageBean checkPageExistenceByPageName(PageBean pageBean) throws Exception{
    	  PreparedStatement ps;
          ResultSet rs;
          ps = con.prepareStatement(PAGE_QUERY);
          ps.setInt(1, pageBean.getWebsiteKey());
          ps.setString(2,pageBean.getPageName());
          rs = ps.executeQuery();

          if(rs.next()){
           
        	  pageBean.setPageKey(rs.getInt("page_key"));
        	  pageBean.setTemplateKey(rs.getInt("template_key"));
        	 

          }
          else{
        	  pageBean.setPageKey((0));
         	 
            }
          return pageBean;
    	  
      }

      public TemplateBean getTemplateKey(TemplateBean templateBean)throws Exception{    //returns the template key by using template name

        TemplateDAO templateDAO=new TemplateDAO();
       // return templateDAO.getTemplateKey(pb);
        //TemplateBean templateBean=new TemplateBean();
        templateBean=templateDAO.getTemplateByTemplateName(templateBean);
        return templateBean;
      }

      public void createPage(PageBean pb,String defaultPageStatus,boolean overWriteStatus)throws Exception{      //creates the page i.r inserts record in database


           PreparedStatement preparedStatement;
           if(overWriteStatus==true){
          	 preparedStatement = con.prepareStatement(DEFAULT_PAGE_UPDATE_QUERY);
          	 preparedStatement.setString(1,"N");
          	 preparedStatement.setInt(2,pb.getWebsiteKey());
          	 preparedStatement.executeUpdate();
           }
           preparedStatement = con.prepareStatement(PAGE_INSERT_QUERY);
           preparedStatement.setInt(1,pb.getWebsiteKey());
           preparedStatement.setInt(2,pb.getTemplateKey());
           preparedStatement.setString(3,pb.getPageName());
           preparedStatement.setString(4,"Y");
           preparedStatement.setString(5,defaultPageStatus);
           preparedStatement.executeUpdate();
  /*
           preparedStatement = con.prepareStatement(PAGE_QUERY);
           preparedStatement.setInt(1, pb.getWebsiteKey());
           preparedStatement.setString(2,pb.getPageName());
           rs = preparedStatement.executeQuery();

             if(rs.next()==true)
             {
               //pageKey=rs.getInt("pagekey");
                  pb.setPageKey(rs.getInt("pagekey"));             
             }
             else
             {
            //   pageKey=0;
          	   pb.setPageKey(0);             
                 
             }

             rs=templateCodeDAO.getTemplateByTemplateKey(pb.getTemplateKey());

             while(rs.next()==true)
             {
             blurbDAO.insertBlurbCode(pageKey,rs.getInt("blurbkey"));
             blurbDollarDAO.insertBlurbCode(pageKey,rs.getInt("blurbkey"));
          }

             return pb;
    */
           }
    public PageBean getPageByPageName(PageBean pageBean) throws Exception{

        PreparedStatement preparedStatement;
        ResultSet rs;
        TemplateCodeDAO templateCodeDAO=new TemplateCodeDAO();
        BlurbDAO blurbDAO=new BlurbDAO();
        BlurbDollarDAO blurbDollarDAO=new BlurbDollarDAO();
  	
    	preparedStatement = con.prepareStatement(PAGE_QUERY);
    	
    	System.out.println("Pagebean key w :"+pageBean.getWebsiteKey());
    	System.out.println("PageBean name :"+pageBean.getPageName());
    //	System.out.println("PageBean name :"+pageBean.getTemplateKey());
    //	System.out.println("PageBean name :"+pageBean.getPageKey());
    	
    	
        preparedStatement.setInt(1, pageBean.getWebsiteKey());
        preparedStatement.setString(2,pageBean.getPageName());
        rs = preparedStatement.executeQuery();
          if(rs.next()==true)
          {
            //pageKey=rs.getInt("pagekey");
               pageBean.setPageKey(rs.getInt("page_key"));             
               pageBean.setTemplateKey(rs.getInt("template_key"));             
                      
          }
          else
          {
         //   pageKey=0;
       	   pageBean.setPageKey(0);             
              
          }
          System.out.println("Template Key: "+pageBean.getTemplateKey());
          
          rs=templateCodeDAO.getCodeResultsetByTemplateKey(pageBean.getTemplateKey());
          System.out.println("Before If");
          while(rs.next())
          {
        	  System.out.println("In If");
        	 
        	  
          blurbDAO.insertBlurbCode(pageBean.getPageKey(),rs.getInt("blurb_type_key"));
          blurbDollarDAO.insertBlurbCode(pageBean.getPageKey(),rs.getInt("blurb_type_key"));
       }
          System.out.println("Before Return");
          System.out.println("key "+pageBean.getPageKey());
          System.out.println("name: "+pageBean.getPageName());
          System.out.println("websitekey: "+pageBean.getWebsiteKey());
          System.out.println("name: "+pageBean.getTemplateKey());
          
          
          
          return pageBean;   	 
   }

   public void deletePage(String pageName,int websiteKey)throws Exception{

    int row=0;
    PreparedStatement ps;
    boolean status;
    ps = con.prepareStatement(PAGE_DELETE_QUERY);      ps.setString(1,pageName);
	ps.setInt(2,websiteKey);
      row= ps.executeUpdate();
      
       
      if(row==0){
    	  status=false;
        System.out.println("0 rows deleted");
      }
      else{
    	  status=true;
        System.out.println(row+" : rows deleted");
      }
       
        
     // return status;
   }


   public void updatePage(String oldPageName,String pageName,int websiteKey)throws Exception{

     PreparedStatement ps;
     int row=0;
     boolean status;
     System.out.println("In upadetpage");
     ps = con.prepareStatement(PAGE_UPDATE_QUERY);
     ps.setString(1,pageName);
     ps.setString(2,oldPageName);
     ps.setInt(3,websiteKey);
     row=ps.executeUpdate();
     if(row==0){
   	  System.out.println("0 rows updated");
     }
     else{
   	
       System.out.println(row+" : rows updated");
     }

     

     }
/*
   public String getCode(PageBean pageBean)throws Exception{

     ResultSet rs,rs1;
   
     String tmp,code="";
     TemplateCodeDetailsDAO templateCodeDetailsDAO=new TemplateCodeDetailsDAO();
     rs=templateCodeDetailsDAO.getTemplateByTemplateKey(pageBean.getTemplateKey());
     BlurbDetailsDollarDAO blurbDetailsDAO=new BlurbDetailsDollarDAO();
     rs1=blurbDetailsDAO.getBlurbDetailsByPageKey(pageBean.getPageKey());
     while(rs.next()==true && rs1.next()==true){
        tmp=rs.getString("code");
        code=code.concat(tmp);
        tmp=rs1.getString("content");
        code=code.concat(tmp);
     }
     return code;
   }

*/
   /*
   public String getCode(String websiteName,String pageName,String templateName)throws Exception{

     PreparedStatement ps;
     ResultSet rs;
     ResultSet rs1;
     String tmp,code="";
     int pageKey=0,templateKey=0;
     System.out.println("********In PageDAO getCode() Method*******");
     WebsiteDAO websiteDAO=new WebsiteDAO();
     WebsiteBean websiteBean=new WebsiteBean();
     websiteBean=websiteDAO.getWebsiteByWebsiteName(websiteName);
     
     ps=con.prepareStatement(PAGE_QUERY);
     ps.setInt(1,websiteBean.getWebsiteKey());
     ps.setString(2,pageName);
     rs=ps.executeQuery();

     if(rs.next()==true)
     {
        pageKey=rs.getInt("pageKey");
        templateKey=rs.getInt("templateKey");
     }

     TemplateCodeDAO templateCodeDAO=new TemplateCodeDAO();
     rs=templateCodeDAO.getTemplateByTemplateKey(templateKey);
     BlurbDollarDAO blurbDetailsDAO=new BlurbDollarDAO();
     System.out.println("********In PageDel getCode() Method1*******");
     rs1=blurbDetailsDAO.getBlurbDetailsByPageKey(pageKey);
     while(rs.next()==true && rs1.next()==true)
      {
        tmp=rs.getString("code");
        code=code.concat(tmp);
        tmp=rs1.getString("content");
        code=code.concat(tmp);
      }
     return code;
   }
*/
   public StringBuffer getPageCode(PageBean pageBean)throws Exception{
	    StringBuffer code=new  StringBuffer();
	    String content="";
	    code=code.append("");
	    //String tmp=null;
		TemplateCodeDAO templateCodeDAO=new TemplateCodeDAO();
		System.out.println("1");
	    ResultSet rs=templateCodeDAO.getCodeResultsetByTemplateKey(pageBean.getTemplateKey());
	    System.out.println("1");
	    BlurbDollarDAO blurbDollarDAO=new BlurbDollarDAO();
	    ResultSet rs1=blurbDollarDAO.getBlurbDetailsByPageKey(pageBean.getPageKey());
	    while(rs.next() && rs1.next()){
	    	
	    	System.out.println(rs.getString("template_code"));
	    	System.out.println(rs1.getString("content"));
	    //	tmp=rs.getString("template_code");
         //   content=content.concat(tmp);
          // tmp=rs1.getString("content");
          // content=content.concat(tmp);
	       code=code.append(rs.getString("template_code"));
	       code=code.append(rs1.getString("content"));
	    	
	     }
	    System.out.println("Code in PDAO: "+code);
	    System.out.println("Content in PDAO: "+content);
	     
	     return code;
	   }

   public ArrayList getAllPageName(WebsiteBean websiteBean)throws Exception
   {
	   System.out.println("In Page DAO***");
     PreparedStatement ps=null;
     ResultSet rs;
     ArrayList<PageBean> list=new ArrayList<PageBean>();
     int websiteKey=websiteBean.getWebsiteKey(); 
     ps=con.prepareStatement(PAGE_NAME_QUERY);
     ps.setInt(1,websiteKey);
     rs=ps.executeQuery();
     while(rs.next()){
       PageBean pageBean=new PageBean();
       pageBean.setPageKey(rs.getInt("page_key"));
       pageBean.setPageName(rs.getString("page_name"));
       pageBean.setWebsiteKey(rs.getInt("website_key"));
       pageBean.setWebsiteKey(rs.getInt("template_key"));
       pageBean.setActiveFlag(rs.getString("active_flag"));
       list.add(pageBean);
     }
       System.out.println("List:"+list.size());
       
        return list;
   }

   public String getWebsiteName(int websiteKey)throws Exception{
       WebsiteDAO websiteDAO=new WebsiteDAO();
      return websiteDAO.getWebsiteNameByWebsiteKey(websiteKey);
  }
   /*public ResultSet getPageByWebsiteName(String pageName,String websiteName)throws Exception {
     PreparedStatement ps=null;
      WebsiteDAO websiteDAO=new  WebsiteDAO();
      int websiteKey=websiteDAO.getWebsiteKey(websiteName);
      ps = con.prepareStatement(PAGE_QUERY);
      ps.setInt(1,websiteKey);
      ps.setString(2,pageName);
      return  ps.executeQuery();

   }*/
   public PageBean getPageByPageNameAndWebsiteKey(String pageName,int websiteKey)throws Exception {
	   System.out.println("pageNmae"+pageName);
	   System.out.println("web key"+websiteKey);
		  
	     PreparedStatement ps=null;
	     PageBean pageBean=new PageBean(); 
	     ps = con.prepareStatement(PAGE_QUERY);
	     ps.setInt(1,websiteKey);
	     ps.setString(2,pageName);
	     ResultSet rs=ps.executeQuery();
	     if(rs.next())
	     {
	    	 pageBean.setPageKey(rs.getInt("page_key"));
	    	 pageBean.setPageName(rs.getString("page_name"));
	    	 pageBean.setWebsiteKey(rs.getInt("website_key"));
	    	 pageBean.setTemplateKey(rs.getInt("template_key"));
	    	 pageBean.setActiveFlag(rs.getString("active_flag"));
	    	 return pageBean;
	    	 
	     }
	    return  null;

	   }
   public PageBean getAllPageNameByWebsite(String websiteName)throws Exception
   {
	   System.out.println("In Page DAO***");
     PreparedStatement ps=null;
     ResultSet rs;
     WebsiteBean websiteBean=new WebsiteBean();
     WebsiteDAO websiteDAO=new WebsiteDAO();
     websiteBean=websiteDAO.getWebsiteByWebsiteName(websiteName);
     
     int websiteKey=websiteBean.getWebsiteKey(); 
     PageBean pageBean=new PageBean();
     System.out.println("website key in pagedao****:"+websiteName);
      
     ps=con.prepareStatement(PAGE_NAME_BY_WEBSITE_QUERY);
     ps.setInt(1,websiteKey);
     rs=ps.executeQuery();
     while(rs.next()){
           pageBean.setPageName(rs.getString("page_Name"));
     }
       System.out.println("page name in pageDAO: "+pageBean.getPageName());
       
        return pageBean;
   }
   public PageBean getDefaultPageByWebsite(String websiteName) throws Exception{
	     
	     PreparedStatement ps=null;
	     ResultSet rs;
	     WebsiteBean websiteBean=new WebsiteBean();
	     WebsiteDAO websiteDAO=new WebsiteDAO();
	     websiteBean=websiteDAO.getWebsiteByWebsiteName(websiteName);
	     
	     int websiteKey=websiteBean.getWebsiteKey(); 
	     PageBean pageBean=new PageBean();
	     System.out.println("website key in pagedao****:"+websiteName);
	      
	     ps=con.prepareStatement(DEFAULT_PAGE_BY_WEBSITE_QUERY);
	     ps.setInt(1,websiteKey);
	     rs=ps.executeQuery();
	     if(rs.next()){
	    	 pageBean.setPageKey(rs.getInt("page_key"));  
	    	 pageBean.setPageName(rs.getString("page_Name"));
	           
	           
	     }else{
	    	 pageBean.setPageKey(0);  
	    	 
	     }
	     
	      return pageBean; 
 }

   
}