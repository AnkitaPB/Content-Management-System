package delegate;

import java.sql.ResultSet;

import beans.BlurbTypeBean;
import dao.BlurbTypeDAO;

public class BlurbTypeDelegate {
  BlurbTypeDAO blurbTypeDAO=null;
  public BlurbTypeDelegate()
  {
         blurbTypeDAO=new BlurbTypeDAO();
  }
    public BlurbTypeBean getBlurbByBlurbType(String blurbType)throws Exception{
        BlurbTypeBean blurbTypeBean=new BlurbTypeBean();
        ResultSet rs=null;
        System.out.println("Before call:  "+blurbType);
        rs=blurbTypeDAO.getBlurbByBlurbType(blurbType);
        System.out.println("after rs");
        System.out.println("REs: "+rs.getInt(1));
        while(rs.next()){
          System.out.println("11");
          blurbTypeBean=new BlurbTypeBean();
          blurbTypeBean.setBlurbKey(rs.getInt("blurbkey"));
          System.out.println("1");
          blurbTypeBean.setBlurbType(rs.getString("blurbtype"));
          System.out.println("2");
        }
        System.out.println("Before call");
        return blurbTypeBean;

    }
    public int getBlurbKey(String blurbType)throws Exception{
      System.out.println("In getjhg "+blurbType);
      int i=blurbTypeDAO.getBlurbKey(blurbType);
      System.out.println("In i "+i);
      return i;
    }
}