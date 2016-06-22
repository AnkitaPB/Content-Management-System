package fileUploadHandler;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
public class FilesUploader {

  public void createFolders(String path)throws Exception
  {
    File websiteFolder=new File(path);
    websiteFolder.mkdir();
    
	File imageFolder=new File(path+"\\images");
    imageFolder.mkdir();
   
    File cssFile=new File(path+"\\css");
    cssFile.mkdir();
  	cssFile=new File(path+"\\css\\cssContents.css");
	cssFile.createNewFile();
	
    File javascriptFile=new File(path+"/javascript");
    javascriptFile.mkdir();
    javascriptFile=new File(path+"\\javascript\\javascriptContents.js");
    javascriptFile.createNewFile();
   
  }
  /*public void uploadImageFile(String sourcePath,String destinationPath)throws Exception
  {
	  		Image image = null;
	  		try 
	  		{
	  			int slashCnt = sourcePath.lastIndexOf("\\");
	  			String filename = sourcePath.substring(slashCnt+1);
	  			File sourceimage = new File(sourcePath);
	  			image = ImageIO.read(sourceimage);
	  			String path=destinationPath+"\\"+filename;
	  			File file= new File(path);
	  			file.createNewFile();
	  			BufferedImage bi = (BufferedImage)image; // retrieve image
	  			File outputfile = new File(path);
	  			ImageIO.write(bi,"jpg",outputfile);
	  		}
	  		catch (Exception e) {
	  		}
        

  }*/

  public void uploadMultipleFile(ArrayList a,String destinationPath)throws Exception
  {
	  	Image image = null;
	  	String  sourcePath=null;
        try {
        		Iterator it = a.iterator();
        		while(it.hasNext())
        		{
        			
        			sourcePath=(String)it.next();
        			int slashCnt = sourcePath.lastIndexOf("\\");
        			String filename = sourcePath.substring(slashCnt+1);
        			
        			File sourceimage = new File(sourcePath);
        			image = ImageIO.read(sourceimage);
        			String path=destinationPath+"\\"+filename;
        			System.out.println("Path imagefile.... "+path);
        			File file= new File(path);
        			file.createNewFile();

        			BufferedImage bi = (BufferedImage)image; // retrieve image
        			File outputfile = new File(path);
        			ImageIO.write(bi,"jpg",outputfile);
        		}
        	}
        catch (Exception e) {
        }
  }

  public void uploadCssFile(String sourcePath,String destinationPath)
	{

			try 
			{
			        File inputFile = new File(sourcePath);
		            File outputFile = new File(destinationPath+"/css/cssContents.css");
		            //System.out.println("Destination Path  "+destinationPath );
		            FileInputStream fis = new FileInputStream(inputFile);
      
		            FileOutputStream fos = new FileOutputStream(outputFile);
		
		            int c;
		            	
		            while ((c = fis.read()) !=-1) {
		               fos.write(c);
		            }

		            fis.close();
		            fos.close();
		     } 
			   
			 catch (IOException e) {
		            System.err.println("FileStreamsTest CSS: " + e);
		     }
  }
	
  
  public void uploadJavascriptFile(String sourcePath,String destinationPath)
	{

			try 
			{
			        File inputFile = new File(sourcePath);
		            File outputFile = new File(destinationPath+"/javascript/javascriptContents.js");
		            //System.out.println("Destination Path  "+destinationPath );
		            FileInputStream fis = new FileInputStream(inputFile);
      
		            FileOutputStream fos = new FileOutputStream(outputFile);
		
		            int c;
		            	
		            while ((c = fis.read()) !=-1) {
		               fos.write(c);
		            }

		            fis.close();
		            fos.close();
		     } 
			   
			 catch (IOException e) {
		            System.err.println("FileStreamsTest Javascript: " + e);
		     }
  }  

}

