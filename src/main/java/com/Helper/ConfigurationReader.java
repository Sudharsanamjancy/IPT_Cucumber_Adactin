package com.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	public static Properties p;

	public ConfigurationReader() throws IOException {
		File f = new File(
				"C:\\Users\\sudha\\eclipse-workspace-June-IPT\\Adactin_Maven\\src\\main\\java\\com\\Properties\\Adactin.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
	}

	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}

	public String getUrl() {
		String url = p.getProperty("url");
		return url;
	}

	public String getCardnumber() {
		String cardnumber = p.getProperty("cardnumber");
		return cardnumber;
	}

	public String getCardtype() {
		String cardtype = p.getProperty("cardtype");
		return cardtype;
	}

	public String getExpirymonth() {
		String expirymonth = p.getProperty("expirymonth");
		return expirymonth;
	}

	public String getExpiryyear() {
		String expiryyear = p.getProperty("expiryyear");
		return expiryyear;
	}

	public String getCvv() {
		String cvv = p.getProperty("cvv");
		return cvv;
	}

}
