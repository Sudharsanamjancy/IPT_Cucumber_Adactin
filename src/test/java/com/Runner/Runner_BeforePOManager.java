package com.Runner;

import java.io.IOException;

import com.Base_Class.BaseClass;
import com.POM.Book_Hotel;
import com.POM.Home_Page;
import com.POM.Search_Hotel;
import com.POM.Select_Hotel;

public class Runner_BeforePOManager extends BaseClass {

	public static void main(String[] args) throws IOException {

		
		browsertype("chrome");
//		browser();
		getUrl("https://adactinhotelapp.com");

		Home_Page hp = new Home_Page(driver);
		Search_Hotel sh = new Search_Hotel(driver);
		Select_Hotel slH = new Select_Hotel(driver);
		Book_Hotel bh = new Book_Hotel(driver);

//			Home_Page
		sendKeystoElement(hp.getName(), "Sudharsanam");
		sendKeystoElement(hp.getPassword(), "8XXIFP");
		clickOnElement(hp.getLogin());
		
//			Search_Hotel
		clickOnElement(sh.getLocation());
		dropdown("byvalue", sh.getLocation(), "London");
		dropdown("byvalue", sh.getHotels(), "Hotel Sunshine");
		dropdown("byvalue", sh.getRoom(), "Double");
		dropdown("byvalue", sh.getNumbers(), "5");
		sendKeystoElement(sh.getCheckIn(), "19/06/2024");
		sendKeystoElement(sh.getCheckOut(), "20/06/2024");
		dropdown("byvalue", sh.getAdult_room(), "2");
		dropdown("byvalue", sh.getChild_room(), "1");
		clickOnElement(sh.getSubmit());

//			Select_Hotel
		clickOnElement(slH.getRadio());
		clickOnElement(slH.getSearch());

		sendKeystoElement(bh.getFname(), "Sudharsanam");
		sendKeystoElement(bh.getLname(), "Subramani");
		sendKeystoElement(bh.getAddress(), "Balaji Avenue Ramapuram");
		sendKeystoElement(bh.getCc(), "1234567890123456");
		dropdown("byvalue", bh.getCctype(), "VISA");
		dropdown("byvalue", bh.getCcmonth(), "2");
		dropdown("byvalue", bh.getCcyear(), "2024");

//			Book_Hotel
		sendKeystoElement(bh.getCvv(), "111");
		clickOnElement(bh.getBook());

		screenshot("MavenAdactin");
		
		closeBrowser();
	}

}
