package com.Runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.Base_Class.BaseClass;
import com.POM.Book_Hotel;
import com.POM.Home_Page;
import com.POM.Search_Hotel;
import com.POM.Select_Hotel;
import com.PageObjManager_SDP.Page_Object_Manager;

public class Runner_AfterPOManager extends BaseClass {

	public static WebDriver driver = getDriver("chrome");
//	public static WebDriver driver = getDriver("firefox");
//	public static WebDriver driver = getDriver("edge");



	public static Page_Object_Manager pom = new Page_Object_Manager(driver);

	public static void main(String[] args) throws IOException {

		getUrl("https://adactinhotelapp.com");

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
		sendKeystoElement(pom.getBh().getCc(), "1234567890123456");
		dropdown("byvalue", pom.getBh().getCctype(), "VISA");
		dropdown("byvalue", pom.getBh().getCcmonth(), "2");
		dropdown("byvalue", pom.getBh().getCcyear(), "2022");
		sendKeystoElement(pom.getBh().getCvv(), "123");
		clickOnElement(pom.getBh().getBook());

		screenshot("1");
	}

}
