package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import beans.AccessibleWebsiteAndPageBean;
import beans.TemplateBean;
import beans.UserAccessBean;
import beans.WebsiteBean;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class WebsiteDAO extends CommonDAO {


  protected static final String WEBSITE_QUERY ="select * from website where website_name=?";
  protected static final String WEBSITE_KEY_QUERY ="select website_key from website where website_name=?";
  
  protected static final String WEBSITE_INSERT_QUERY ="insert into website(website_name,active_flag,css_path,javascript_path,created_date,last_modified) values(?,?,?,?,?,?)";
 // protected static final String WEBSITE_DELETE_QUERY ="delete from website where website_name=?";
//  protected static final String WEBSITE_UPDATE_QUERY ="update website set website_name=? where website_name like ?";
  protected static final String WEBSITE_DELETE_QUERY ="update website set active_flag='N' where website_name=?";
  protected static final String WEBSITE_UPDATE_QUERY ="update website set website_name=? where website_name like ?";
  
  protected static final String GET_WEBSITE_NAME_QUERY="select website_name from website where website_key=?";
  protected static final String WEBSITE_ACCESS_QUERY ="select * from user_access where website_key=? and user_key=?";
  protected static final String GET_ALL_ACCESSIBLE_WEBSITE_QUERY ="select * from user_access u,website w ,page p where u.user_key=? and u.website_key=w.website_key and w.active_flag='Y' and u.website_key=p.website_key and p.active_flag='Y' order by w.website_name";
  protected static final String WEBSITE_NAME_LIST_QUERY="SELECT website_name FROM cms.website w,cms.user_access u where w.website_key=u.website_key and w.active_flag='Y' and u.user_key=?";
  protected static final String WEBSITE_DATE_UPDATE_QUERY="update website set last_modified=? where website_name=?";
  
  
  public WebsiteDAO()
  {
    super();
     super.initConnection();
  }
  
  

  public ArrayList getWebsiteNameByUserKey(int userKey)throws Exception
    {
  	  ArrayList<String> a=new ArrayList<String>();
  	  PreparedStatement ps;
  	  ResultSet rs;
  	  ps=con.prepareStatement(WEBSITE_NAME_LIST_QUERY);
  	  
  	  ps.setInt(1,userKey);
  	  rs=ps.executeQuery();
  	  while(rs.next()==true)
  	  {
  		  String websiteName;
  		  websiteName= rs.getString("website_name");
  		  
  		  if (websiteName!=null)
  			  a.add(websiteName);
  	  }
  	  
  	    return a;
  	}

  
  
  public void createWebsite(String websiteName)throws Exception{//creates the page i.r inserts record in database

		
      PreparedStatement ps=null;
      String imageFilePath=websiteName+"\\images\\";
 	  String cssFilePath="/CMS/"+websiteName+"/css/cssContents.css";
 	  String javascriptFilePath="/CMS/"+websiteName+"/javascript/javascriptContents.js";
 	  System.out.println("css path in dao: "+cssFilePath);
	        Calendar cal=Calendar.getInstance();
	        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");		
 		
      ps = con.prepareStatement(WEBSITE_INSERT_QUERY);
                System.out.println("In create websiteDao");
                System.out.println("Inwebdao "+websiteName);
                ps.setString(1,websiteName.toLowerCase());
                ps.setString(2,"Y");
                ps.setString(3,cssFilePath);
                ps.setString(4,javascriptFilePath);
                ps.setString(5, sdf.format(cal.getTime()));
                ps.setString(6, sdf.format(cal.getTime()));                        
                ps.executeUpdate();
                System.out.println("Website Name in WebDAO  :  "+websiteName);
                /*             
                if(rs.next())
                {
                	websitebean.setWebsiteName(websiteName);
                	websitebean.setWebsiteKey(rs.getInt("website_key"));
                	websitebean.setActiveFlag(rs.getString("active_flag"));
                	
                	return websitebean;
                }
                return null;
     */           	
               // wb.setStatus(true);
              
}
  public boolean checkWebsiteExistence(String websiteName)throws Exception{//check whether page already exist or not
         boolean status=false;
         ResultSet rs;
         PreparedStatement ps;
          //super.initConnection();
         //WEBSITE_QUERY ="select * from website_details where websitename=?";
                   ps = con.prepareStatement(WEBSITE_QUERY);
                  ps.setString(1,websiteName);
                  rs = ps.executeQuery();
                  if(rs.next()){
                      status=true; //Already present
                      }
                  else{
                        status=false;
                 }


      return status;
  }

  


public int deleteWebsite(WebsiteBean wb)throws Exception{

        PreparedStatement ps;
      int row=0;
        //super.initConnection();
      //query ="delete from website_details where websitename=?";
        ps = con.prepareStatement(WEBSITE_DELETE_QUERY);
            ps.setString(1,wb.getWebsiteName());
            row= ps.executeUpdate();
            if(row==0){
                    System.out.println("0 rows deleted");
                 }
          else{
                     System.out.println(row+" : rows deleted");
               }
           return row;
}

public void updateWebsiteModifiedDate(String websiteName)throws Exception
{
	PreparedStatement ps;
	ResultSet rs=null;
	Calendar cal=Calendar.getInstance();
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");	
      ps = con.prepareStatement(WEBSITE_DATE_UPDATE_QUERY);
          ps.setString(1,sdf.format(cal.getTime()));
          ps.setString(2,websiteName);
          ps.executeUpdate();
          
          AccessibleWebsiteAndPageBean access=new AccessibleWebsiteAndPageBean();  
    	  access.setModifiedDate(sdf.format(cal.getTime()));
    	  System.out.println("Last date set in web DAO : "+access.getModifiedDate());
    

}
public void updateWebsiteName(WebsiteBean wb,String newWebsiteName)throws Exception{

            PreparedStatement ps;
        //super.initConnection();
        //query ="update website_details set websitename=? where websitename like ?";
          ps = con.prepareStatement(WEBSITE_UPDATE_QUERY);
              ps.setString(1,newWebsiteName);
              ps.setString(2,wb.getWebsiteName());
              ps.executeUpdate();
}


public String getWebsiteNameByWebsiteKey(int websiteKey) throws Exception{
  PreparedStatement ps;
  ResultSet rs;
  ps=con.prepareStatement(GET_WEBSITE_NAME_QUERY);
  ps.setInt(1,websiteKey);
  rs=ps.executeQuery();
  if(rs.next()==true)
  {
  return rs.getString("website_name");
  }
  else
    return "NO WEBSITE FOUND";
}

public WebsiteBean getWebsiteByWebsiteName(String websiteName) throws Exception{
  PreparedStatement ps;
  ResultSet rs;
  WebsiteBean websiteBean=new WebsiteBean(); 
  ps=con.prepareStatement(WEBSITE_QUERY);
  ps.setString(1,websiteName);
  rs=ps.executeQuery();
  if(rs.next()==true)
  {
   
	  websiteBean.setWebsiteKey(rs.getInt("website_key"));
	  websiteBean.setWebsiteName(rs.getString("website_name"));
	  websiteBean.setActiveFlag(rs.getString("active_flag"));
	  websiteBean.setCssPath(rs.getString("css_path"));
	  
	  return websiteBean;
  
  }
  else
    return null;
}
public boolean checkWebsiteAccess(int webKey,int userKey)throws Exception{//check whether page already exist or not
    boolean status=false;
    ResultSet rs;
    PreparedStatement ps;
    ps = con.prepareStatement(WEBSITE_ACCESS_QUERY);
    ps.setInt(1,webKey);
    ps.setInt(2,userKey);
    System.out.println("in dao webKey "+webKey);
    
    System.out.println("in dao userKey "+userKey);
    rs = ps.executeQuery();
      if(rs.next()){
        status=true; //Having Access
      }
      else{
                status=false;
      }
      System.out.println("Status in dao: "+status);
       ps.close();
       rs.close();

return status;
}

public void createUserAccess(UserAccessBean userBean)throws Exception
{
  UserAccessDAO userAccessDAO=new UserAccessDAO();
  userAccessDAO.createUserAccess(userBean);
}


public WebsiteBean getWebsiteByWebsiteKey(int key)throws Exception{

    PreparedStatement ps;
    ResultSet rs;
    WebsiteBean wb=null;

    wb=new WebsiteBean();
    ps=con.prepareStatement(GET_WEBSITE_NAME_QUERY);
    ps.setInt(1,key);
    rs=ps.executeQuery();

    if(rs.next()){
      wb.setWebsiteName(rs.getString("website_name"));
      wb.setWebsiteKey(rs.getInt("website_key"));
      return wb;
    }

    return null;
}
public TemplateBean getTemplateByTemplateKey(int templateKey) throws Exception{
	 
	 TemplateBean templateBean=new TemplateBean();
	 TemplateDAO templateDAO=new TemplateDAO();
	 templateBean=templateDAO.getTemplateByTemplateKey(templateKey);
	 return templateBean;
}

public ArrayList getWebsiteByUserKey(int userKey) throws Exception{

    PreparedStatement ps;
    ResultSet rs;
    ps=con.prepareStatement(GET_ALL_ACCESSIBLE_WEBSITE_QUERY);
    ps.setInt(1,userKey);
    rs=ps.executeQuery();
    ArrayList websiteList=new ArrayList(); 
  
    while(rs.next()){
    	  AccessibleWebsiteAndPageBean access=new AccessibleWebsiteAndPageBean();  
    	  access.setWebsiteKey(rs.getInt("website_key"));
    	  access.setWebsiteName(rs.getString("website_name"));
    	 access.setPageName(rs.getString("page_name"));
    	 access.setCreatedDate(rs.getString("created_date"));
    	 access.setModifiedDate(rs.getString("last_modified"));
    	//  System.out.println("in website dao: website name is: "+access.getWebsiteName());
    	  websiteList.add(access);
    	 
    }
    return websiteList;

	
}
public int deleteWebsite(String websiteName)throws Exception{

    PreparedStatement ps;
  int row=0;
    //super.initConnection();
  //query ="delete from website_details where websitename=?";
    ps = con.prepareStatement(WEBSITE_DELETE_QUERY);
        ps.setString(1,websiteName);
        row= ps.executeUpdate();
        if(row==0){
                System.out.println("0 rows deleted");
             }
      else{
                 System.out.println(row+" : rows deleted");
           }
       return row;
}



public void renameWebsite(String oldWebsiteName,String newWebsiteName)throws Exception{

        PreparedStatement ps;
    //super.initConnection();
    //query ="update website_details set websitename=? where websitename like ?";
      ps = con.prepareStatement(WEBSITE_UPDATE_QUERY);
      ps.setString(1,newWebsiteName);
      ps.setString(2,oldWebsiteName);
      ps.executeUpdate();
}


}