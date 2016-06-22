package delegate;

import beans.BlurbBean;
import beans.BlurbBeanA;
import dao.BlurbDAO;

public class BlurbDelegate {
  BlurbDAO  blurbDAO=null;
  public BlurbDelegate ()
  {
        blurbDAO=new BlurbDAO();

   }
  public void saveContent(BlurbBeanA blurbBeanA )throws Exception
  {
    blurbDAO.saveContent(blurbBeanA);
  }
  public BlurbBean getBlurbByPageKeyAndBlurbTypeKey(String websiteName,String pageName,String blurbType) throws Exception{
	  return blurbDAO.getBlurbByPageKeyAndBlurbTypeKey(websiteName,pageName,blurbType);
  }

}

