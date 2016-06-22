package delegate;

import java.util.HashMap;
import beans.ErrorBean;
import beans.UserBean;
import dao.UserDAO;

public class UserDelegate {
	
	UserDAO userDAO=null;
	ErrorBean errorBean;
	HashMap<String, ErrorBean> errorHashMap=new HashMap<String, ErrorBean>();
	
	
	public UserDelegate() {
		userDAO =new UserDAO();
	}
	
	public void registerUser(UserBean userBean)throws Exception{
		userDAO.registerUser(userBean);
	}
	
	public UserBean getUserByUserNamePassword(String userName,String passWord) throws Exception 	{
		return userDAO.getUserByUserNamePassword(userName, passWord);
	}
	
	public UserBean getUserByUserName(String userName)throws Exception
	{
		return userDAO.getUserByUserName(userName);
	}
	public void addErrorToHashmap(String errorKey,String errorMessage)
    {
    	errorBean=new ErrorBean();
       	errorBean.setErrorKey(errorKey);
       	errorBean.setErrorMsg(errorMessage);
       	errorHashMap.put(errorBean.getErrorKey(),errorBean);
    }
	
	public void addToHashmap(String Key,String Message)
    {
    	errorBean=new ErrorBean();
       	errorBean.setErrorKey(Key);
       	errorBean.setErrorMsg(Message);
       	errorHashMap.put(errorBean.getErrorKey(),errorBean);
    }
	
	public Boolean isUserNameAvailable(String userName)throws Exception
	{
		 	
		UserBean userBean=userDAO.getUserByUserName(userName);
		if(userBean==null)		//Username already present
		{
			System.out.println("available un");
			return true;
		}
		System.out.println("not un ");
		return false;
	}
	
	public HashMap validateLogin(String userName,String passWord)throws Exception{
		
		if(userName==""){
			addErrorToHashmap("userName","Required");
	    }
		if(passWord==""){
			addErrorToHashmap("password","Required");
	    }
	    return errorHashMap;
}
	public HashMap<String, ErrorBean> validateUsername(UserBean userBean)throws Exception{
		if(userBean.getUserName()==""){
			addErrorToHashmap("userName","Required");
	    }
		else
		{
			if(userBean.getUserName().length()<3){
				addErrorToHashmap("userName","Too Short");
			}
			for(int i=0;i<userBean.getUserName().length();i++)
			{
				char ch=userBean.getUserName().charAt(i);
				
				if((ch<'a'||ch>'z')&&(ch<'A'||ch>'Z')&&(ch<'0'||ch>'9')&&(ch!='.'))
				{
					addErrorToHashmap("userName","Sorry, only letters (a-z), numbers (0-9), and periods (.) are allowed.");
				}
			}
		}
		return errorHashMap;
	}
	public HashMap validateForgottenPasswordForm(UserBean userBean,String newPassword,String confirmPassword)throws Exception
	{
		if(userBean.getUserName()==""){
			addErrorToHashmap("nameMissing","Required");
	    }
		if(userBean.getAnswer()==""){
	    	addErrorToHashmap("answer","Required");
	    }
		if(newPassword==""){
	    	addErrorToHashmap("password","Required");
	    }
	    else if(newPassword.length()<5)
		{
	    	addErrorToHashmap("password","Too Short");
		}
	    if(confirmPassword==""){
	    	addErrorToHashmap("confirmPassword","Required");
	    }
	    else
	    {
		   if(newPassword.length()==confirmPassword.length())
		   {
			   for(int i=0;i<newPassword.length();i++)
			   {
				   if(newPassword.charAt(i)!=confirmPassword.charAt(i))
				   {
					   addErrorToHashmap("confirmPassword","Not Matching");
			       	  	break;
				   }
			   }
		   }
		   else
		   {
			   addErrorToHashmap("confirmPassword","Not Matching");
		   }
	    }
		return errorHashMap;
	}
	public HashMap validateChangePasswordForm(UserBean userBean,String newPassword,String confirmPassword)throws Exception
	{
		if(userBean.getUserName()==""){
			addErrorToHashmap("nameMissing","Required");
	    }
		if(userBean.getPassword()==""){
			addErrorToHashmap("pwdMissing","Required");
	    }
		if(newPassword==""){
	    	addErrorToHashmap("password","Required");
	    }
	    else if(newPassword.length()<5)
		{
	    	addErrorToHashmap("password","Too Short");
		}
	    if(confirmPassword==""){
	    	addErrorToHashmap("confirmPassword","Required");
	    }
	    else
	    {
		   if(newPassword.length()==confirmPassword.length())
		   {
			   for(int i=0;i<newPassword.length();i++)
			   {
				   if(newPassword.charAt(i)!=confirmPassword.charAt(i))
				   {
					   addErrorToHashmap("confirmPassword","Not Matching");
			       	  	break;
				   }
			   }
		   }
		   else
		   {
			   addErrorToHashmap("confirmPassword","Not Matching");
		   }
	    }
		return errorHashMap;
	}
	public HashMap validateRegistration(UserBean userBean,String confirmPassword)throws Exception{
		
		/*if(userBean.getUserName()==""){
			addErrorToHashmap("userName","Required");
	    }
		else
		{
			if(userBean.getUserName().length()<3){
				addErrorToHashmap("userName","Too Short");
			}
			for(int i=0;i<userBean.getUserName().length();i++)
			{
				char ch=userBean.getUserName().charAt(i);
				
				if((ch<'a'||ch>'z')&&(ch<'A'||ch>'Z')&&(ch<'0'||ch>'9')&&(ch!='.'))
				{
					addErrorToHashmap("userName","Sorry, only letters (a-z), numbers (0-9), and periods (.) are allowed.");
				}
			}
		}*/
		validateUsername(userBean);
		if(userBean.getAnswer()==""){
	    	addErrorToHashmap("answer","Required");
	    }
	    if(userBean.getPassword()==""){
	    	addErrorToHashmap("password","Required");
	    }
	    else if(userBean.getPassword().length()<5)
		{
	    	addErrorToHashmap("password","Too Short");
		}
	    if(confirmPassword==""){
	    	addErrorToHashmap("confirmPassword","Required");
	    }
	    else
	    {
		   if(userBean.getPassword().length()==confirmPassword.length())
		   {
			   for(int i=0;i<userBean.getPassword().length();i++)
			   {
				   if(userBean.getPassword().charAt(i)!=confirmPassword.charAt(i))
				   {
					   addErrorToHashmap("confirmPassword","Not Matching");
			       	  	break;
				   }
			   }
		   }
		   else
		   {
			   addErrorToHashmap("confirmPassword","Not Matching");
		   }
	    }
	    
	    if(userBean.getEmailAdderss()==""){
	    	addErrorToHashmap("emailAddress","Required");
	    }
	    else
	    {
		    int iat=userBean.getEmailAdderss().indexOf('@');
		    int idot=userBean.getEmailAdderss().indexOf('.');
		    int lemail=userBean.getEmailAdderss().length();
		    System.out.println("iat="+iat+"  idot"+idot+"  lemail="+lemail);
		    if((iat==-1 || iat==0 ||iat==lemail-1)||(idot==-1 ||idot==0 ||idot==lemail-1))		// @ or . not present or present at starting or ending
		    {	
		    	addErrorToHashmap("emailAddress","Invalid");
		    }
		    else
		    {
			    if(userBean.getEmailAdderss().indexOf('@',iat+1)!=-1)		//multiple @
			    {	
			    	addErrorToHashmap("emailAddress","Invalid");
			    }
			    if(userBean.getEmailAdderss().charAt(iat-1)=='.'||userBean.getEmailAdderss().charAt(iat+1)=='.')	//consecutive @ and  .
			    {	
			    	addErrorToHashmap("emailAddress","Invalid");
			    }
			    if(userBean.getEmailAdderss().charAt(idot-1)=='.'||userBean.getEmailAdderss().charAt(idot+1)=='.')		//consecutive  .
			    {	
			    	addErrorToHashmap("emailAddress","Invalid");
			    }
			    if(userBean.getEmailAdderss().indexOf('.',iat+2)==-1)		//. must be present after @
			    {	
			    	addErrorToHashmap("emailAddress","Invalid");
			    }
		    }
	    }
	    return errorHashMap;
	}
	public void changePassword(String username,String newPassword)throws Exception
	{
		userDAO.changePassword(username,newPassword);
	}
	/*public void forgottenPassword(UserBean userBean,String newPassword)throws Exception
	{
		UserBean existingUserBean=userDAO.getUserByUserName(userBean.getUserName());
		if(existingUserBean.getQuestion().equalsIgnoreCase(userBean.getQuestion()))
			
		userDAO.forgottenPassword(userBean,newPassword);
	}*/
}
