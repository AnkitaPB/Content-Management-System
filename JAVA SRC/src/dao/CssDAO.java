package dao;

import java.sql.PreparedStatement;

public class CssDAO extends CommonDAO{

	protected static final String CSSPATH_QUERY ="update website set css_path=? where website_name=?";
	
	
	public CssDAO()
	  {
	    super();
	     super.initConnection();
	  }

	public void insertCssPath(String cssPath,String websiteName)throws Exception
	{		
        		  PreparedStatement ps=null;
                  ps = con.prepareStatement(CSSPATH_QUERY);
                  ps.setString(1,websiteName);
                  ps.executeUpdate();
    }
}
