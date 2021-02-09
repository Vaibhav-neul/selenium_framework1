package com.visionit.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configdataprovider {
	public static Properties p;

	public configdataprovider() throws IOException {
		File f = new File("./configfile/config.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
	}

	public String getusername() {
		return p.getProperty("username");
	}

	public String getpassword() {
		return p.getProperty("password");
	}

	public String geturl() {
		return p.getProperty("url");
	}
}
