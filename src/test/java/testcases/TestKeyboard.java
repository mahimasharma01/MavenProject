package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyboard {
	
	
	
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		
		driver.findElement(By.id("identifierId")).sendKeys("java@way2automation.com");
		
		driver.findElement(By.xpath("//*[@id=\"initialView\"]/div[2]")).click();
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		driver.findElement(By.id("identifierId")).clear();
		
		Thread.sleep(3000);
		driver.findElement(By.id("identifierId")).click();
		
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
		//action.sendKeys(Keys.ENTER).perform();
		

		
	}

}
