package delegate;

import java.sql.ResultSet;

import beans.BlurbBeanA;

import dao.BlurbDollarDAO;
public class BlurbDollarDelegate {
   BlurbDollarDAO blurbDollarDAO=null;
   public BlurbDollarDelegate() {
        blurbDollarDAO=new BlurbDollarDAO();
   }    
   public String getActiveFlag(int pageKey,int blurbKey)throws Exception
   {
  	  ResultSet rs=blurbDollarDAO.getActiveFlag(pageKey, blurbKey);
  	  return rs.getString("activeflag");
   }
   public void saveContent(BlurbBeanA blurbBeanA)throws Exception
   {
       blurbDollarDAO.saveContent(blurbBeanA);
   }
   public BlurbBeanA getBlurbContentByPageNameAndBlurbType(int websiteKey,String pageName, String blurbType)throws Exception
   { 
    	BlurbBeanA blurbBeanA=new BlurbBeanA();
    	blurbBeanA=blurbDollarDAO.getBlurbContentByPageNameAndBlurbType(websiteKey, pageName, blurbType);
       	System.out.println(blurbBeanA.getActiveFlag());
    	System.out.println(blurbBeanA.getContent());
     	System.out.println("*********");
    	return blurbBeanA;
    }
   /* public BlurbBeanA getBlurbContentByPageKeyAndBlurbKey(int pageKey,int blurbTypeKey)throws Exception
    {
    	BlurbBeanA blurbBeanA=new BlurbBeanA();
    	blurbBeanA=blurbDollarDAO.getBlurbContentByPageKeyAndBlurbKey(pageKey, blurbTypeKey);
        
    	return blurbBeanA;
    }*/
    
}