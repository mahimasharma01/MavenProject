package testnglearning.functional;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest
	public void createDBConnection() {
		
		System.out.println("Creating DB Conn");
	}
	
	@AfterTest
	public void closeDBConn() {
		
		System.out.println("Closing DB Conn");
		
	}

	
	@BeforeMethod
	public void launchBrowser() {
		
		System.out.println("Launching browser");
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		System.out.println("Closing Browser");
	}
	
	@Test(priority=1,groups="functional")
	public void doUserReg() {
	
		System.out.println("Executing User reg Test");
		
		
		Assert.fail("User reg test failed");
		
	}
	
	@Test(priority=2,groups="functional")
	public void doLogin() {
		System.out.println("Executing Login Test");
		Assert.fail("Login test failed");
	}
	
	
}
