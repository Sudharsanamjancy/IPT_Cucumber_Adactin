package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Hotel {
	
public WebDriver driver;
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotels;
	
	@FindBy(id="room_type")
	private WebElement room;
	
	@FindBy(id="room_nos")
	private WebElement numbers;
	
	@FindBy(id="datepick_in")
	private WebElement checkIn;
	
	@FindBy(id="datepick_out")
	private WebElement checkOut;
	
	@FindBy(id="adult_room")
	private WebElement adult_room;
	
	@FindBy(id="child_room")
	private WebElement child_room;
	
	@FindBy(id="Submit")
	private WebElement submit;

	public Search_Hotel(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	public WebElement getLocation() {
		return location;
	}

	public void setLocation(WebElement location) {
		this.location = location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public void setHotels(WebElement hotels) {
		this.hotels = hotels;
	}

	public WebElement getRoom() {
		return room;
	}

	public void setRoom(WebElement room) {
		this.room = room;
	}

	public WebElement getNumbers() {
		return numbers;
	}

	public void setNumbers(WebElement numbers) {
		this.numbers = numbers;
	}

	public WebElement getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(WebElement checkIn) {
		this.checkIn = checkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(WebElement checkOut) {
		this.checkOut = checkOut;
	}

	public WebElement getAdult_room() {
		return adult_room;
	}

	public void setAdult_room(WebElement adult_room) {
		this.adult_room = adult_room;
	}

	public WebElement getChild_room() {
		return child_room;
	}

	public void setChild_room(WebElement child_room) {
		this.child_room = child_room;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}
}