package com.TestRunner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.Base_Class.BaseClass;
import com.Helper.FileReaderManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)  // cucumber along with Junit

@CucumberOptions(features="C:\\Users\\sudha\\eclipse-workspace-June-IPT\\Adactin_Cucumber\\src\\test\\java\\com\\Feature\\Adactin.feature",

glue = "com.StepDef",  // stepde path

//tags = ("@smokeTest, @sanityTest"), // to run particular tag

tags = "@smokeTest",
// ("~@smokeTest", "~@sanityTest") ----------> to neglect more than one tag

plugin = {"pretty", // print in console
//		
		"html:Report/Cucumberhtml.html",// genreate report
//		
		"json:Report/Cucumber.json"},
//
//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},   // cucumber report

monochrome = true,  // to remove special char removed and give normal english

strict = true, // exception will throw if we have error	

dryRun = false)


public class Runner_Class  extends BaseClass{
		
	public static WebDriver driver; // null

	@BeforeClass
	public static void set_Up() throws IOException {
		
		String browser = FileReaderManager.getInstanceFRM().getInstanceCR().getBrowser();
		
		driver = BaseClass.browsertype(browser);   
	}
		
	@AfterClass
	public static void tear_Down() {
		
		driver.close();

	}
	
}
