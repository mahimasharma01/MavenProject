package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabandPopup {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.hdfcbank.com/");

		System.out.println("---Generating window ids from first window----");
		Set<String> winids = driver.getWindowHandles();// 1st
		Iterator<String> iterate = winids.iterator();

		String first_window = iterate.next();
		System.out.println(first_window);

		driver.findElement(By.cssSelector("#loginsubmit")).click();

		System.out.println("---Generating window ids from second window----");

		winids = driver.getWindowHandles();// 1st
		iterate = winids.iterator();

		System.out.println(iterate.next()); // 1st
		String second_window = iterate.next(); // 2nd
		System.out.println(second_window);

		driver.switchTo().window(second_window);

		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[3]/a")).click();

		System.out.println("---Generating window ids from third window----");

		winids = driver.getWindowHandles();// 1st
		iterate = winids.iterator();

		System.out.println(iterate.next()); // 1st
		System.out.println(iterate.next());
		String third_window = iterate.next();// 3rd
		System.out.println(third_window);

		driver.switchTo().window(third_window);

		System.out.println(driver.getTitle().contains("JetPrivilege HDFC Bank Signature Chip Debit Card"));

		
		/*driver.close();//3rd
		driver.switchTo().window(second_window);
		driver.close();
		driver.switchTo().window(first_window);
		driver.close();*/
		
		driver.quit();
		
	}

}
