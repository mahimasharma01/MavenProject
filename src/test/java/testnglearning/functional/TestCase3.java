package testnglearning.functional;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
	
	
	@Test(priority=1,groups= {"functional"})
	public void doUserReg() {
		
		System.out.println("Executing User reg Test");
		Assert.fail("User not registered successfully");
	}
	
	@Test(priority=2,dependsOnMethods= "doUserReg",groups= {"functional","bvt"})
	public void doLogin() {
		
		System.out.println("Executing Login Test");
		
	}
	
	@Test(priority=3,groups= {"bvt"})
	public void isSkip() {
		
		throw new SkipException("Skipping the test as the condition is not met");
	}
	
	

}
