package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.PageBean;
import beans.TemplateBean;
public class TemplateDAO extends CommonDAO {
	public Statement stat;
    public ResultSet rs;
    protected static final String TEMPLATE_QUERY ="select * from template";
    protected static final String GET_TEMPLATE_QUERY ="select * from template where template_name=?";
    protected static final String GET_TEMPLATE ="select * from template where template_key=?";

    public TemplateDAO() {
					super();
					super.initConnection();
					 
    }
    public ArrayList  templateRecordCreation() throws Exception {
    			  super.initConnection();
    			  ArrayList tempList=new ArrayList();
				  //query="select * from template_details ";   
				  stat=con.createStatement();
				  rs=stat.executeQuery(TEMPLATE_QUERY);
		          while(rs.next()){
			        	 TemplateBean  templateBean=new TemplateBean ();
			        	 templateBean.setTemplateKey(rs.getInt(1));
			        	 templateBean.setTemplateName(rs.getString(2));
			        	 templateBean.setTemplateCode(rs.getString(3));
			        	 tempList.add(templateBean);
			        	 
				   }
		 
					   
				  return tempList;
		   }
    
    public TemplateBean getTemplateByTemplateName(TemplateBean templateBean)throws Exception{        //returns the template key by using template name

        
          PreparedStatement ps;
          ResultSet rs;
          System.out.println("Template name in templateDao:"+templateBean.getTemplateName());
          //TemplateBean templateBean=new TemplateBean();
          ps= con.prepareStatement(GET_TEMPLATE_QUERY);
           ps.setString(1,templateBean.getTemplateName());
            rs = ps.executeQuery();

            if(rs.next()){
           	 templateBean.setTemplateKey(rs.getInt("template_key"));
           	 templateBean.setTemplateName(rs.getString("template_name"));
           	 templateBean.setTemplateCode(rs.getString("template_code"));
           	 templateBean.setTemplatePath(rs.getString("template_path"));
           	 
              //tempKey=rs.getInt("template_key");
              System.out.println("Temp key in DAO:" +templateBean.getTemplateKey());
          }

            else{
           	 templateBean.setTemplateKey(0);
           	  //tempKey=0;
                System.out.println("Invalid template name");
            }

            return templateBean;
       // return tempKey;
      }


    public TemplateBean getTemplateByTemplateKey(int templateKey)throws Exception{        //returns the template key by using template name

      //  int tempKey=0;
          PreparedStatement ps;
          ResultSet rs;
          TemplateBean templateBean=new TemplateBean();
          ps= con.prepareStatement(GET_TEMPLATE);
           ps.setInt(1,templateKey);
            rs = ps.executeQuery();

            if(rs.next()){
           	 templateBean.setTemplateKey(rs.getInt("template_key"));
           	 templateBean.setTemplateName(rs.getString("template_name"));
           	 templateBean.setTemplateCode(rs.getString("template_code"));
           	 templateBean.setTemplatePath(rs.getString("template_path"));
           	 
              //tempKey=rs.getInt("template_key");
              System.out.println("Temp key in DAO:"+templateKey);
          }

            else{
           	 templateBean.setTemplateKey(0);
           	  //tempKey=0;
                System.out.println("Invalid template name");
            }

            return templateBean;
       // return tempKey;
      }
	  
	}

