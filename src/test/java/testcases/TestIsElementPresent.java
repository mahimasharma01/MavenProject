package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIsElementPresent {
	
	public static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
		/*try {
		driver.findElement(by);
		return true;
		}catch(Throwable t) {
			
			return false;
		}*/
		
		int size = driver.findElements(by).size();
		
		if(size==0) {
			return false;
		}else {
			
			return true;
		}
	}
	

	public static void main(String[] args) {


		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.wikipedia.org/");
		
		
	
		System.out.println(isElementPresent(By.xpath("//*[@id=\"www-wikipedia-org\"]/p/small[3]/a[234234]")));
	
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		System.out.println(isElementPresent(By.xpath("//*[@id=\"searchLanguage\"]")));

	}

}
