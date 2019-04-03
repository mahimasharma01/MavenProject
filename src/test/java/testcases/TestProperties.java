package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestProperties.class);

	public static void click(String key) {

		if (key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		} else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		} else if (key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key))).click();
		}

		log.info("Clicking on an Element : " + OR.getProperty(key));

	}

	public static void type(String locator, String value) {

	}

	/*
	 * 
	 * log4j API - jar Logger - getLogger Log4j Appenders - log4j.properties
	 * 
	 * 
	 */

	public static void main(String[] args) throws IOException {

		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");

		fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");

		OR.load(fis);
		log.info("OR Properties file loaded");

		fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");

		Config.load(fis);
		log.info("Config Properties file loaded");

		if (Config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox launched");

		} else if (Config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched");

		} else if (Config.getProperty("browser").equals("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			log.info("IE Launched");

		}

		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigating to : " + Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		click("nxtBtn_CSS");
		// click("subBtn_XPATH");
		driver.findElement(By.xpath(OR.getProperty("nxtBtn_XPATH"))).click();
		log.info("Clicking on an Element :  " + OR.getProperty("nxtBtn_XPATH"));

		/*
		 * // driver.findElement(By.xpath(OR.getProperty("username_XPATH"))).click();
		 * System.out.println(OR.getProperty("username_XPATH"));
		 * 
		 * // driver.get(Config.getProperty("testsiteurl"))
		 * System.out.println(Config.getProperty("testsiteurl"));
		 */
	}

}
