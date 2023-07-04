package com.PageObjManager_SDP;

import org.openqa.selenium.WebDriver;

import com.POM.Book_Hotel;
import com.POM.Home_Page;
import com.POM.Search_Hotel;
import com.POM.Select_Hotel;

public class Page_Object_Manager {
	
	public WebDriver driver;
	
	private Home_Page hp;
	private Search_Hotel sh;
	private Select_Hotel slH;
	private Book_Hotel bh;
	
	public Page_Object_Manager(WebDriver driver1) {
		this.driver=driver1;
	}
	public Home_Page getHp() {
		hp=new Home_Page(driver);
		return hp;
	}
	public Search_Hotel getSh() {
		sh=new Search_Hotel(driver);
		return sh;
	}
	public Select_Hotel getSlh() {
		slH=new Select_Hotel(driver);
		return slH;
	}
	public Book_Hotel getBh() {
		bh=new Book_Hotel(driver);
		return bh;
	}

}
