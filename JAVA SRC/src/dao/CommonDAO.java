package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class CommonDAO {

  private String url,driver,user,pass,db;
  protected Connection con;

  CommonDAO()
  {
     url = "jdbc:mysql://localhost:3306/";
     driver = "com.mysql.jdbc.Driver";
     user = "root";
       pass = "root";
       db = "cms";
  }

  public void initConnection(){

    try{
            Class.forName(driver);
               con = DriverManager.getConnection(url+ db,user,pass);
          }
        catch(Exception e){
              System.out.println("In database connection:  "+e);
        }
  }
}