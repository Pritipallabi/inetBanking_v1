package com.inetBanking_testUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
        try {
		FileInputStream fs = new FileInputStream("./config.properties");
		pro = new Properties();
		pro.load(fs);
        }catch(Exception e){
        	
        	System.out.println(e.getMessage());
        	
        }
	}

	public String getUrl() {

		String url = pro.getProperty("baseUrl");
		return url;
	}

	public String getUsername() {

		String uname = pro.getProperty("username");
		return uname;
	}

	public String getpassword() {

		String pwd = pro.getProperty("password");
		return pwd;
	}

	public String getchropath() {

		String cro = pro.getProperty("chropath");
		return cro;
	}
	public String getfirefoxpath() {

		String firefox = pro.getProperty("firefoxPath");
		return firefox;
	}
	

}
