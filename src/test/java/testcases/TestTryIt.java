package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTryIt {
	
	public static WebDriver driver;

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".\\screenshot\\"+fileName));

	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

		driver.switchTo().frame("iframeResult");

		// driver.findElement(By.xpath("/html/body/button")).click();

		//java script function of a website
		((JavascriptExecutor) driver).executeScript("myFunction()");

		//injecting our own javascript
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
				driver.findElement(By.xpath("//*[@id=\"mySubmit\"]")));

		driver.switchTo().defaultContent();

		System.out.println("----Printing Frames count-----");

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		System.out.println(frames.size());

		for (WebElement frame : frames) {

			System.out.println(frame.getAttribute("id"));
		}

		
		captureScreenshot();
	}

}
