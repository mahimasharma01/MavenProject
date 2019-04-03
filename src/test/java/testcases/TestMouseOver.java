package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {

	public static WebDriver driver;

	public static boolean isElementPresent(By by) {
		/*
		 * try { driver.findElement(by); return true; }catch(Throwable t) {
		 * 
		 * return false; }
		 */

		int size = driver.findElements(by).size();

		if (size == 0) {
			return false;
		} else {

			return true;
		}
	}

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");

		if (isElementPresent(By.xpath("/html/body/div[2]/div/div/button"))) {

			driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		}

		WebElement menu = driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[3]/ul/li[3]/span"));

		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();

		driver.findElement(By.linkText("Shirts")).click();

	}

}
