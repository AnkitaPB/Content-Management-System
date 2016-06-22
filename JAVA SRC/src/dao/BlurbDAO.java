package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.BlurbBean;
import beans.BlurbBeanA;

public class BlurbDAO extends CommonDAO{

  protected static final String BLURB_CODE_INSERT_QUERY="insert into blurb(page_key,blurb_type_key,content,active_flag)values(?,?,?,?);";
  protected static final String BLURB_CODE_QUERY="select content from blurb where page_key=?";
  protected static final String PUT_CODE ="update blurb set content=?,active_flag=? where (page_key=? and blurb_type_key=?)";
  protected static final String BLURB_CODE_FOR_WEBSITE_QUERY="select * from blurb b,website w,page p where b.active_flag='Y' and w.active_flag='Y' and p.active_flag='Y' and p.page_key=b.page_key and w.website_key=p.website_key and w.website_name=? and p.page_name=? and b.blurb_type_key=?";
  protected static final String DELETE_BLURB="update blurb set active_flag='N' where page_key=?";
  public BlurbDAO(){
    super();
    super.initConnection();
  }
  public void saveContent(BlurbBeanA blurbBeanA)throws Exception{
	   //  System.out.println("*******Content*******AF***: "+activeFlag);
	      PreparedStatement ps = con.prepareStatement(PUT_CODE);
	      StringBuffer content=new StringBuffer();
	      content=blurbBeanA.getContent();
	      String updatedContent= content.toString().trim();
	      ps.setString(1,updatedContent);
	      ps.setString(2,blurbBeanA.getActiveFlag());
	      ps.setInt(3,blurbBeanA.getPageKey() );
	      ps.setInt(4, blurbBeanA.getBlurbTypeKey());
	      ps.executeUpdate();
	      System.out.println("In put cide Method Child DAo");
	    }

  public void insertBlurbCode(int pageKey,int blurbKey)throws Exception
  {
    PreparedStatement preparedStatement;
    System.out.println("page key in insert blurb code: "+pageKey);
    System.out.println("blurb Key: "+blurbKey);
    preparedStatement = con.prepareStatement(BLURB_CODE_INSERT_QUERY);
       preparedStatement.setInt(1,pageKey);
       preparedStatement.setInt(2,blurbKey);
       preparedStatement.setString(3,"<font color=#cccccc size=30>Insert Text Here</font>");
       preparedStatement.setString(4,"Y");
       preparedStatement.executeUpdate();
       System.out.println("Data Inserted into Blurb");
  }

  public ResultSet getBlurbByPageKey(int pageKey)throws Exception{

    PreparedStatement preparedStatement;
    preparedStatement=con.prepareStatement(BLURB_CODE_QUERY);
    preparedStatement.setInt(1,pageKey);
    return preparedStatement.executeQuery();
  }
  public void putCode(int pageKey,int blurbKey,String content,String activeFlag)throws Exception{
    System.out.println("*******Content**********: "+content);
      PreparedStatement ps = con.prepareStatement(PUT_CODE);
      ps.setString(1,content);
      ps.setString(2,activeFlag);
      ps.setInt(3,pageKey );
      ps.setInt(4, blurbKey);

      ps.executeUpdate();
      System.out.println("In put cide Method Child DAo");
    }
  public BlurbBean getBlurbByPageKeyAndBlurbTypeKey(String websiteName,String pageName,String blurbType)throws Exception{

	    PreparedStatement preparedStatement;
	    ResultSet rs;
	    BlurbBean blurbBean=new BlurbBean();
	    BlurbTypeDAO blurbTypeDAO=new BlurbTypeDAO();
	     int blurbTypeKey=blurbTypeDAO.getBlurbKey(blurbType);//get blurb_type key using blurbType
	    /* WebsiteDAO websiteDAO=new WebsiteDAO();
	     WebsiteBean websiteBean=new WebsiteBean();
	     websiteBean=websiteDAO.getWebsiteByWebsiteName(websiteName);// get website key
	   */
	     System.out.println("in page dao blurb_type_key is: "+blurbTypeKey+"Blurbtype is:"+blurbType);
	     System.out.println("In pagedao pagename is"+pageName);
	     preparedStatement=con.prepareStatement(BLURB_CODE_FOR_WEBSITE_QUERY);
	    preparedStatement.setString(1,websiteName);
	    preparedStatement.setString(2,pageName);
	    preparedStatement.setInt(3,blurbTypeKey);
	    rs=preparedStatement.executeQuery();
	    if(rs.next()){
	         blurbBean.setContent(rs.getString("content"));
	         blurbBean.setBlurbKey(rs.getInt("blurb_key"));
	         
	     }
	    else{
	    	System.out.println("No content found for this blurb");
	    }
	    return blurbBean;
}
  }