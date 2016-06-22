package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.UserAccessBean;
public class UserAccessDAO extends CommonDAO {
	protected static final String USERACCESS_INSERT_QUERY ="insert into user_access(user_key,website_key) values(?,?)";
	protected static final String USERACCESS_QUERY ="select * from user_access where user_key=?";
	public UserAccessDAO()
	{
		super();
		super.initConnection(); 
	}
	public void createUserAccess(UserAccessBean userBean)throws Exception{//creates the page i.r inserts record in database
		PreparedStatement ps;
		System.out.println("In User Acces");
        //query="insert into website_details(websitename) values(?)";
         ps = con.prepareStatement(USERACCESS_INSERT_QUERY);
         ps.setInt(1,userBean.getUserKey());
         ps.setInt(2,userBean.getWebsiteKey());
         System.out.println("WE###"+userBean.getWebsiteKey());
         System.out.println("In create websiteDao:");   
         ps.executeUpdate();
            
    }
	
	public ArrayList checkUserAccess(int userKey)throws Exception
	{
		PreparedStatement ps;
		ArrayList<UserAccessBean> list=new ArrayList<UserAccessBean>();
		UserAccessBean userAccessBean=new UserAccessBean();
		ps=con.prepareStatement(USERACCESS_QUERY);
		ps.setInt(1,userKey);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			userAccessBean.setUserKey(rs.getInt("user_key"));
			userAccessBean.setWebsiteKey(rs.getInt("website_key"));
			list.add(userAccessBean);
		}
		return list; //return userKey, WebsitKey Arralist
		
				
	}



}
