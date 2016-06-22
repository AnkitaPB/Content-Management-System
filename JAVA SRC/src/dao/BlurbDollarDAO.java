package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import beans.BlurbBeanA;

public class BlurbDollarDAO extends CommonDAO{
  protected static final String BLURB_CODE_INSERT_QUERY="insert into blurb$(page_key,blurb_type_key,content,active_flag)values(?,?,?,?);";
  //protected static final String BLURB_CODE_QUERY="select content from blurb_$ where page_key=? and active_flag='Y'";
  protected static final String BLURB_CODE_QUERY="select content from blurb$ where page_key=? and active_flag='Y'";
  protected static final String GET_ACTIVEFLAG_QUERY ="select active_flag from blurb$ where (page_key=? and blurb_type_key=?)";
  protected static final String PUT_CODE ="update blurb$ set content=?,active_flag=? where (page_key=? and blurb_type_key=?)";
  protected static final String GET_BLURB_CONTENT= " select b.blurb$_key,b.page_key,b.blurb_type_key,b.content,b.active_flag from blurb$ b,blurb_type t,page p  where p.active_flag='Y' and t.blurb_type_key=b.blurb_type_key and p.page_key=b.page_key  and p.page_name=? and p.website_key=? and t.blurb_type=?";
  protected static final String BLURB_CONTENT= "select * from blurb$ where page_key=? and blurb_type_key=?"; 
  public BlurbDollarDAO(){
    super();
    super.initConnection();
  }

 /*  public BlurbBeanA getBlurbContentByPageKeyAndBlurbKey(int pageKey,int blurbTypeKey)throws Exception{
	   PreparedStatement preparedStatement;
	   BlurbBeanA blurbBeanA=new BlurbBeanA();
	   StringBuffer content=new StringBuffer();
       preparedStatement = con.prepareStatement(BLURB_CONTENT);
       preparedStatement.setInt(1, pageKey);
       preparedStatement.setInt(2, blurbTypeKey);
       ResultSet rs=preparedStatement.executeQuery();
       if(rs.next()){
    	   blurbBeanA.setBlurbAKey(rs.getInt("blurb$_key"));
    	   blurbBeanA.setBlurbTypeKey(rs.getInt("blurb_type_key"));
    	   content=content.append(rs.getString("content"));
    	   blurbBeanA.setContent(content);
    	   blurbBeanA.setPageKey(rs.getInt("page_key"));
    	   blurbBeanA.setActiveFlag(rs.getString("active_flag"));
    	  
    	   return blurbBeanA;   
       }
       return null;
   }*/
   
  public void insertBlurbCode(int pageKey,int blurbKey)throws Exception
  {
	   PreparedStatement preparedStatement;
       preparedStatement = con.prepareStatement(BLURB_CODE_INSERT_QUERY);
       preparedStatement.setInt(1,pageKey);
       preparedStatement.setInt(2,blurbKey);
       preparedStatement.setString(3,"<font color=#cccccc size=30>Insert Text Here</font>");
       preparedStatement.setString(4,"Y");
       preparedStatement.executeUpdate();
    }
  public BlurbBeanA getBlurbContentByPageNameAndBlurbType(int websiteKey,String pageName, String blurbType)throws Exception{
	
	   PreparedStatement preparedStatement;
	   StringBuffer content=new StringBuffer();
	   BlurbBeanA blurBeanA=new BlurbBeanA();
	   preparedStatement=con.prepareStatement(GET_BLURB_CONTENT);
	   preparedStatement.setString(1,pageName);
	   preparedStatement.setInt(2,websiteKey);
	   preparedStatement.setString(3,blurbType);
	   ResultSet rs=preparedStatement.executeQuery();
	   if(rs.next())
	   {
	    	blurBeanA.setBlurbAKey(rs.getInt("blurb$_key"));
	    	blurBeanA.setBlurbTypeKey(rs.getInt("page_key"));
	    	blurBeanA.setPageKey(rs.getInt("blurb_type_key"));
	    	content=content.append(rs.getString("content"));
	    	blurBeanA.setContent(content);
	    	blurBeanA.setActiveFlag(rs.getString("active_flag"));
	      	return blurBeanA;
	   }
	   return null;
  }
  public void saveContent(BlurbBeanA blurbBeanA)throws Exception{
	      System.out.println("!!!!!!Content:  "+blurbBeanA.getContent() );
	      System.out.println("Active Flag: "+blurbBeanA.getActiveFlag());
	      System.out.println("page key: "+blurbBeanA.getPageKey());
	      System.out.println("blurb_type_key: "+blurbBeanA.getBlurbTypeKey());
	      
	      StringBuffer content=new StringBuffer();
	      content=blurbBeanA.getContent();
	      String updatedContent= content.toString().trim();
	      System.out.println("Content => "+updatedContent);
	      PreparedStatement ps = con.prepareStatement(PUT_CODE);
	      ps.setString(1,updatedContent);
	      ps.setString(2,blurbBeanA.getActiveFlag());
	      ps.setInt(3,blurbBeanA.getPageKey() );
	      ps.setInt(4, blurbBeanA.getBlurbTypeKey());
	      int i=ps.executeUpdate();
	      System.out.println("Row Updated:  "+i);
}

 public ResultSet getBlurbDetailsByPageKey(int pageKey)throws Exception{
    PreparedStatement preparedStatement;
    System.out.println("In GetBlurbDetailspageKey");
    preparedStatement=con.prepareStatement(BLURB_CODE_QUERY);
    preparedStatement.setInt(1,pageKey);
    return preparedStatement.executeQuery();
 }
 public ResultSet getActiveFlag(int pageKey,int blurbKey)throws Exception
 {
	   PreparedStatement ps = con.prepareStatement(GET_ACTIVEFLAG_QUERY);
	   ps.setInt(1,pageKey);
	   ps.setInt(2,blurbKey);
	   return ps.executeQuery();
 }
    
}