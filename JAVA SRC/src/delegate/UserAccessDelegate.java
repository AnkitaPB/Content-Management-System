package delegate;
import java.util.ArrayList;

import dao.UserAccessDAO;
import beans.UserAccessBean;


public class UserAccessDelegate {
	UserAccessDAO userAccessDAO=null;
	public UserAccessDelegate()
	{
			userAccessDAO=new UserAccessDAO();
	}

	public void userAccessBean(UserAccessBean userBean)
	{
		 try{
		 userAccessDAO.createUserAccess(userBean);
		 
	       }
		 catch(Exception e){
			 System.out.println("Exception in user access delegate: "+e);
		 }
	}	 
	public ArrayList checkUserAccess(int userKey) throws Exception{
		ArrayList arrayList=new ArrayList();
		arrayList=userAccessDAO.checkUserAccess(userKey);
		return arrayList;
		}
	}
