package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		title.length();
		
		driver.getTitle().length();
		
		/*WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("trainer@way2automation.com");*/
		
		//html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span
		
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("trainer@way2automation.com");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span"))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']"))).sendKeys("asdfsdf");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span")).click();
		
		System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]/div[2]/div")).getText());
		
		
		
		//driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span")).click();

	
		
		
		
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("asdfsdfsd");

	}

}
