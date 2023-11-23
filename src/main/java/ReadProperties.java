import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws IOException  {
	
		File myPropertyFile = new File(System.getProperty("user.dir")+ "\\Config\\qa.properties");
		FileReader fileReader = new FileReader(myPropertyFile);
		Properties properties = new Properties();
		properties.load(fileReader); 
		String url = properties.getProperty("BASE_URL");
		System.out.println(url);
		
		
	}

}
 