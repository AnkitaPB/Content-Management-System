package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.UserBean;

public class UserDAO extends CommonDAO{
	
	protected static final String GET_USER_BY_USERNAME_QUERY =  "select * from user where (user_name = ?)";
	protected static final String INSERT_USER_QUERY =  "insert into user(user_name,password,email_address,question,answer)values(?,?,?,?,?)";
	protected static final String GET_USER_BY_UESRNAME_PASSWORD_QUERY =  "select * from user where (user_name = ? and password=?)";
	protected static final String CHANGE_PASSWORD_QUERY="update user set password=? where user_name=?";
	
	UserBean userBean=null;
	
	public UserDAO() {
		super();
		super.initConnection();
		
	}
	public UserBean getUserByUserName(String userName)throws Exception
	{
			PreparedStatement ps = con.prepareStatement(GET_USER_BY_USERNAME_QUERY);
			ps.setString(1,userName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()==true)
			{
				UserBean userBean=new UserBean();
				userBean.setUserKey(rs.getInt("user_Key"));
				userBean.setUserName(rs.getString("user_name"));
				userBean.setPassword(rs.getString("password"));
				userBean.setEmailAdderss(rs.getString("email_address"));
				userBean.setQuestion(rs.getString("question"));
				userBean.setAnswer(rs.getString("answer"));
				return userBean;
			}
			return null;	
	}
	
	public void registerUser(UserBean userBean)throws Exception
	{
			PreparedStatement ps1 = con.prepareStatement(INSERT_USER_QUERY);
    	 	ps1.setString(1,userBean.getUserName()); 
	    	ps1.setString(2,userBean.getPassword());
	    	ps1.setString(3,userBean.getEmailAdderss());
	    	ps1.setString(4,userBean.getQuestion());
	    	ps1.setString(5,userBean.getAnswer());
	       	ps1.executeUpdate();
	}
	
	public UserBean getUserByUserNamePassword(String userName,String passWord) throws Exception 	{		
		
		PreparedStatement ps = con.prepareStatement(GET_USER_BY_UESRNAME_PASSWORD_QUERY);
		ps.setString(1,userName);
		ps.setString(2,passWord);
		ResultSet rs = ps.executeQuery();
		if(rs.next()==true)
		{
			userBean =new UserBean();
			userBean.setUserKey(rs.getInt("user_key"));
			userBean.setUserName(rs.getString("user_name"));
			userBean.setPassword(rs.getString("password"));
			userBean.setEmailAdderss(rs.getString("email_address"));
			userBean.setQuestion("question");
			userBean.setAnswer("answer");

		}
		return userBean;			
	}
	public void changePassword(String username,String newPassword)throws Exception
	{
		PreparedStatement ps=con.prepareStatement(CHANGE_PASSWORD_QUERY);
		ps.setString(1, newPassword);
		ps.setString(2, username);
		ps.executeUpdate();
	}
	public void forgottenPassword(UserBean userBean)
	{
		
	}
}
