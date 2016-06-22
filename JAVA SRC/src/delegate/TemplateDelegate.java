package delegate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import dao.TemplateDAO;
import beans.TemplateBean;
//Super Delegate is remaining 
public class TemplateDelegate {
	//Object bn=new Object();
	
	   private static TemplateDAO templateDAO=null;
	   private TemplateBean templateBean=null;
/*		public static TemplateDAO getInstance(){
			return dao;
		}*/
	   	public TemplateDelegate()
		{
				templateDAO=new TemplateDAO();
		}
	    public  void loadTemplate(String str)
		{
				int i,j;
				String code[]=new String[4];
		        String filenames[] = new String[]{"template1.jsp","template2.jsp","template3.jsp","template4.jsp","template5.jsp"};
			    Writer output = null;
			    File file = null;
			    try
			    {
			     templateDAO.templateRecordCreation();	
			         	    	   
			        ArrayList list=templateDAO.templateRecordCreation();
			         for(i=0;i<list.size();i++)
			         {    	    
			        	 templateBean=(TemplateBean)list.get(i);
			    	    code[i]=templateBean.getTemplateCode();
		    	   
		             }
		           	  for(j=0;j<filenames.length;j++){
			    	  file = new File(str+filenames[j]);
			    	  output = new BufferedWriter(new FileWriter(file));
			          output.write(code[j]);
			          output.close();
			        }
			    }
			    catch(Exception e)
			    {
			    	System.out.println("In TEMPLATE_DELEGATE"+e);
			    }
		}
	    public TemplateBean getTemplateByTemplateKey(int templateKey) throws Exception{
	    	return templateDAO.getTemplateByTemplateKey(templateKey);
	    	
	    	
	    }
}


