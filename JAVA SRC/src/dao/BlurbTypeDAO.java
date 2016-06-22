package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BlurbTypeDAO extends CommonDAO {
   protected static final String BLURB_QUERY ="select * from blurb_type where blurb_type=?";
   public BlurbTypeDAO()
   {
   super();
  super.initConnection();
   }
   public ResultSet getBlurbByBlurbType(String blurbType)throws Exception
   {
        System.out.println("Before dao call");
        PreparedStatement pre=null;
        ResultSet rs;
        System.out.println("end jh");



        pre=con.prepareStatement(BLURB_QUERY);
        pre.setString(1,blurbType);
        System.out.println("end call");
        rs=pre.executeQuery();
        System.out.println("res :"+rs.getInt(1));
        return rs;

   }
   public int getBlurbKey(String blurbType)throws Exception{
     PreparedStatement ps;
     ResultSet rs;
     int key;
     ps=con.prepareStatement(BLURB_QUERY);
     ps.setString(1,blurbType);
     rs=ps.executeQuery();
     if(rs.next()){
        key=rs.getInt(1);
        return key;
     }
     System.out.println("In getjhg ");
     return 0;
   }
}