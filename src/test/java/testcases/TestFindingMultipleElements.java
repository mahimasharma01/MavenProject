package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingMultipleElements {

	public static void main(String[] args) {


		////*[@id="load_form"]/div/div[1]/p/a
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.wikipedia.org/");
		
		//driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[1]/tbody/tr/td/table/tbody/tr[2]/td[3]/select")).sendKeys("Cheese");
	
		
		
		
		
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		Select select = new Select(dropdown);
		
		//select.selectByVisibleText("Germany");
		select.selectByValue("hi");
		
		
		/*
		 * 1st - 0th index
		 * n? (length) - 
		 * last value = n-1
		 * 
		 */
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		System.out.println("Total values in dropdown are : "+values.size());

		//last - 60th , 1st value = 0th
		System.out.println(values.get(7).getAttribute("value"));
		
		for(int i=0; i<values.size(); i++) {
			
			System.out.println(values.get(i).getAttribute("lang"));
		}
		
		System.out.println("-----Printing all links-----------");
		
		
		
		WebElement block = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[11]/div[3]"));
		//block.findElements(by)
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		
		System.out.println("Total links are : "+links.size());
		
		for(WebElement link: links) {
			
			System.out.println(link.getText()+" -- URL is: --"+link.getAttribute("href"));
		}
		
		
		
		
	}

}
