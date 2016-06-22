package delegate;

import dao.CssDAO;
import dao.WebsiteDAO;

public class CssDelegate {

	CssDAO cssDAO=null;

	  public CssDelegate()
	  {
	      cssDAO=new CssDAO();
	  }
	  
	  public void insertCssPath(String cssPath,String name)throws Exception
	  {
		  cssDAO.insertCssPath(cssPath,name);
	  }

	
}
