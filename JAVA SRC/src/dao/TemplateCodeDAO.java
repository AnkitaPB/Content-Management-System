package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TemplateCodeDAO extends CommonDAO{

   protected static final String TEMPLATE_CODE_QUERY="select * from template_code where template_key=?";

  public TemplateCodeDAO(){
    super();
    super.initConnection();
  }
  public ResultSet getCodeResultsetByTemplateKey(int templateKey)throws Exception{

	    PreparedStatement preparedStatement;
	    preparedStatement = con.prepareStatement(TEMPLATE_CODE_QUERY);
	    preparedStatement.setInt(1,templateKey);
	    ResultSet rs=preparedStatement.executeQuery();
	   	return rs;
  }
	    

}