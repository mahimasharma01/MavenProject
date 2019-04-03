package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestKeywords {

	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestProperties.class);
	public static WebDriver driver;

	public static void click(String key) {

		try {
			if (key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(key))).click();
			} else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(key))).click();
			} else if (key.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(key))).click();
			}

			log.info("clicking on " + key);
		} catch (Throwable t) {

			log.info("Error while clicking on an element: " + key);
		}
	}
	
	
	
	public static void type(String key,String value) {

		try {
			if (key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
			} else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
			} else if (key.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
			}

			log.info("Typing in and Element " + key+" entered the value as: "+value);
		} catch (Throwable t) {

			log.info("Error while Typing in an element: " + key);
		}
	}
	
	

	public static void main(String[] args) throws IOException {

		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");

		fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");

		OR.load(fis);
		log.info("OR Properties file loaded !!!");

		fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");

		Config.load(fis);
		log.info("Config properties file loaded");

		type("username_XPATH","asdfsfs");
		type("password_ID","asdfsfs");
		click("submit_CSS");

	}

}
