package com.Runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import com.Base_Class.BaseClass;
import com.Helper.FileReaderManager;
import com.POM.Book_Hotel;
import com.POM.Home_Page;
import com.POM.Search_Hotel;
import com.POM.Select_Hotel;
import com.PageObjManager_SDP.Page_Object_Manager;

public class Runner_AfterPropertyFile extends BaseClass {
	
	public static WebDriver driver = getDriver("chrome");
	

	public static Page_Object_Manager pom = new Page_Object_Manager(driver);

	public static void main(String[] args) throws IOException {
		
		String url = FileReaderManager.getInstanceFRM().getInstanceCR().getUrl();
		getUrl(url);

		sendKeystoElement(pom.getHp().getName(), "Sudharsanam");
		sendKeystoElement(pom.getHp().getPassword(), "8XXIFP");
		clickOnElement(pom.getHp().getLogin());

//			Search_Hotel
		dropdown("byvalue", pom.getSh().getLocation(), "London");
		dropdown("byvalue", pom.getSh().getHotels(), "Hotel Sunshine");
		dropdown("byvalue", pom.getSh().getRoom(), "Double");
		dropdown("byvalue", pom.getSh().getNumbers(), "5");
		dropdown("byvalue", pom.getSh().getAdult_room(), "2");
		dropdown("byvalue", pom.getSh().getChild_room(), "1");
		clickOnElement(pom.getSh().getSubmit());

//			Select_Hotel
		clickOnElement(pom.getSlh().getRadio());
		clickOnElement(pom.getSlh().getSearch());

//			Book Hotel
		sendKeystoElement(pom.getBh().getFname(), "Sudhar");
		sendKeystoElement(pom.getBh().getLname(), "Sanam");
		sendKeystoElement(pom.getBh().getAddress(), "Ashtabujam road");
		
		String cardNo = FileReaderManager.getInstanceFRM().getInstanceCR().getCardnumber();
		sendKeystoElement(pom.getBh().getCc(), cardNo);
		
		String cardType = FileReaderManager.getInstanceFRM().getInstanceCR().getCardtype();
		dropdown("byvalue", pom.getBh().getCctype(), cardType);
		
		String expiryMonth = FileReaderManager.getInstanceFRM().getInstanceCR().getExpirymonth();
		dropdown("byvalue", pom.getBh().getCcmonth(), expiryMonth);
		
		String expiryYear = FileReaderManager.getInstanceFRM().getInstanceCR().getExpiryyear();
		dropdown("byvalue", pom.getBh().getCcyear(), expiryYear);
		
		String cVV = FileReaderManager.getInstanceFRM().getInstanceCR().getCvv();
		sendKeystoElement(pom.getBh().getCvv(), cVV);
		
		
		clickOnElement(pom.getBh().getBook());

		screenshot("Maven Adactin");
	}

}
