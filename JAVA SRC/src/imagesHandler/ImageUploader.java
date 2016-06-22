package imagesHandler;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
public class ImageUploader {

  public void createImageFolder(String path)
  {
    File file=new File(path);
    file.mkdir();
  }
  public void uploadImageFile(String sourcePath,String destinationPath)throws Exception
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
        

  }

  public void uploadMultipleFile(ArrayList a,String destinationPath)throws Exception
  {
	  	Image image = null;
	  	String  sourcePath=null;
        try {
        		Iterator it = a.iterator();
        		while(it.hasNext())
        		{
        			//it.next();
        			sourcePath=(String)it.next();
        			int slashCnt = sourcePath.lastIndexOf("\\");
        			String filename = sourcePath.substring(slashCnt+1);
        			System.out.println("image Filename:..... "+filename);
        			System.out.println("image Filename:..... "+sourcePath);
        			
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
 }