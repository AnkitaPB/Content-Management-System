package cssHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CssUploader {

	public void createCssFolder(String path)
	{
		File file=new File(path);
		file.mkdir();
		
	}
	public String createCssFile(String path)throws IOException
	{
		  File f;
		  String cssPath=path+"//CSSFile.css";
	      f=new File(path+"//CSSFile.css");
	      f.createNewFile();
	      System.out.println(" ");
	      return cssPath;
	}
	public void uploadCssFile(String cssFilePath,String destinationPath)
	{

			try 
			{
			        File inputFile = new File(cssFilePath);
		            File outputFile = new File(destinationPath+"/CSSFile.css");
		            System.out.println("D Path  "+destinationPath );
		            
		            System.out.println("Destination Path  "+destinationPath );
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
		            System.err.println("FileStreamsTest: " + e);
		     }
    }
		
	
}
		


