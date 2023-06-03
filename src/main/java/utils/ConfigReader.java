package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties initializeProperty() {
		Properties prop = new Properties();
		File file = new File("C:\\Users\\bhatt\\eclipse-workspace\\TutorialsNinjaBDDframework\\srs\\test\\resource\\config\\config.properties");
		try {
			FileInputStream files = new FileInputStream (file);
			prop.load(files);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		return prop;
		
	}

}
