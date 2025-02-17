package com.bksoft.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) {

	}

	public void readPropertiesFile() {
		FileInputStream fis;
		Properties prop;
		try {
			fis = new FileInputStream(
					"C:\\Users\\bikashs\\eclipse-workspace\\seleniumPractice\\PropertiesFiles\\demo.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
