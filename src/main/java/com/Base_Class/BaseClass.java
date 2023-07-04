package com.Base_Class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String value;

	public static WebDriver browsertype(String type) {
		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "" + "\\Driver\\chromedriver.exe");

			driver = new ChromeDriver();
		}
		else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;

	}

	public static WebDriver getDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;

	}

	public static WebDriver browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void sendKeystoElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void clearElement(WebElement element) {
		element.clear();

	}

	public static void getUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void closeCurrenttab() {
		driver.close();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void navigateTo(String url) {
		driver.get(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void alertToaccept() {
		driver.switchTo().alert().accept();
	}

	public static void alertTodismiss() {
		driver.switchTo().alert().dismiss();
	}

	public static void alert(String type, String value) {
		if (type.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (type.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		} else if (type.equalsIgnoreCase("prompt")) {
			driver.switchTo().alert().sendKeys(value);

		}
	}
	public static void getText() {
		System.out.println(driver.switchTo().alert().getText());
	}

	public static void sendkeysToalert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void mouseClick() {
		Actions a = new Actions(driver);
		a.click().build().perform();

	}

	public static void rightClickUsingMouse(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();
	}
	public static void rightClick() {
		Actions a = new Actions(driver);
		a.contextClick().build().perform();
	}

	public static void doubleClick() {
		Actions a = new Actions(driver);
		a.doubleClick().build().perform();
	}

	public static void moveToelement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).build().perform();
		;
	}

	public static void dragAnddrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
	}

	public static void release() {
		Actions a = new Actions(driver);
		a.release().build().perform();
	}

	public static void clickAndhold(WebElement target) {
		Actions a = new Actions(driver);
		a.clickAndHold(target).build().perform();
		
	}
	
	public static void action(WebElement element, WebElement element1) {
		Actions a = new Actions(driver);
		a.clickAndHold(element).build().perform();
		a.moveToElement(element1).build().perform();
		a.click().build().perform();
	}

	public static void dropdown(String type, WebElement element, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("byvalue")) {
			s.selectByValue(value);
		} else if (type.equalsIgnoreCase("byvisibletext")) {
			s.selectByVisibleText(value);
		} else if (type.equalsIgnoreCase("byindex")) {
			int data = Integer.parseInt(value);
			s.selectByIndex(data);
		}
	}

	public static void screenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\sudha\\eclipse-workspace-June-IPT\\Adactin_Cucumber\\Screenshots\\" + name + ".png");
		FileUtils.copyFile(source, destination);
	}
	
	public static void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	
	public static void explicitWait(int sec, WebElement element, String condition) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		
		if (condition.equalsIgnoreCase("visibility")) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		else if (condition.equalsIgnoreCase("clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));

			
		}
	}
	
	
	public static void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);

	}
	public static void switchFrameById(String id) {
		driver.switchTo().frame(id);

	}
	public static void switchFrameByElement(WebElement element) { 
		driver.switchTo().frame(element);
		
	}
	
	public static void frameout() {
		driver.switchTo().defaultContent();
	}
	public static void downkey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void enterkey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void upkey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	public static void scroll(String value) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(value);
	}
	
	
//	bcbs
	public void javaScriptClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void javaScriptScrollToElement(WebElement element) {
		if (element != null) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true)", element);
		}
	}
	
	public static void javaScriptScrollUp(WebElement element) {
		if (element != null) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(false)", element);
		}
	}
	
	public static void windowHandle(String window) {
		Set<String> wh = driver.getWindowHandles();
		for (String string : wh) {

			System.out.println(driver.switchTo().window(string).getTitle());
		}

		String s = window;

		for (String string1 : wh) {

		if (driver.switchTo().window(string1).getTitle().equalsIgnoreCase(s)) {
				break;
			}
		}
	}

	
//		public static String DataDriven(String path,int sheet,int index_row,int index_cell) throws IOException {
//			File f=new File(path);
//			FileInputStream fis=new FileInputStream(f);
//			Workbook wb=new XSSFWorkbook(fis);
//			Sheet sheetAt = wb.getSheetAt(sheet);
//			Row row = sheetAt.getRow(index_row);
//			Cell cell = row.getCell(index_cell);
//			CellType cellType = cell.getCellType();
//			if (cellType.equals(CellType.STRING)) {
//				 value = cell.getStringCellValue();
//			} else if (cellType.equals(CellType.NUMERIC)) {
//				double numericCellValue = cell.getNumericCellValue();
//				int val = (int) numericCellValue;
//				value =String.valueOf(val);
//			}
//			return value;
//			}
//			

}
