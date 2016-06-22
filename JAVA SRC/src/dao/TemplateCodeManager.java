package dao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegate.TemplateDelegate;

public class TemplateCodeManager extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public void init() throws ServletException{
		super.init();
		String str=this.getServletContext().getRealPath("/");
		System.out.println("Path:"+str);
		String path=str+"shared"+"/";
		TemplateDelegate temp=new TemplateDelegate(); 
		temp.loadTemplate(path);
		System.out.println("************************File writting is Done*******************************");
	}
	public TemplateCodeManager(){
		super();
	}   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}  	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
