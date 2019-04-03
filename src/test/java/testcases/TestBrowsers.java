package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {

	public static String browser = "chrome";
	public static WebDriver driver;
	

	public static void main(String[] args) {
		
	
		
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browser.equals("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}

		
		//driver.get("http://way2automation.com");
		driver.navigate().to("http://way2automation.com");
		driver.manage().window().maximize();
		/*String title = driver.getTitle();
		System.out.println(title.length());
		*/
		
		/*
		Options opt = driver.manage();
		Window win = opt.window();
		win.maximize();*/
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle().length());
		
		
		driver.close(); //current browser
		driver.quit(); // current browser + all related windows in the same session

	}

}
