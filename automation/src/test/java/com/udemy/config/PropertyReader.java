package com.udemy.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
FileReader reader;

public void loadProperties() throws IOException {
	reader=new FileReader("config.properties");
	Properties prop = new Properties();
	prop.load(reader);
	Property.userName=prop.getProperty("userName").trim();
	Property.password=prop.getProperty("password").trim();
	}

}
