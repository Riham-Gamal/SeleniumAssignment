package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	static Properties properties = new Properties();
	
	public PropertiesFile(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "//src/main/java/config/config.properties"));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + System.getProperty("user.dir") + "//src/main/java/config/config.properties");
		}		
	}
	
	public String getBrowser() {
		String browser = properties.getProperty("browserName");
		if(browser != null) return browser;
		else throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

}
