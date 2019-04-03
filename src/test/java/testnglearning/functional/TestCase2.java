package testnglearning.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
	
	
	@Test(groups="bvt")
	public void validateTitles() {
		
		String expected_title = "Gmail.com";//excel
		String actual_title = "Yahoo.com";//website
		
		//Assert.assertEquals(actual_title, expected_title);
		Assert.assertTrue(false,"Button not found");
		
		/*if(expected_title.equals(actual_title)) {
			
			System.out.println("Test case pass");
		}else {
			
			System.out.println("Test case fail");
		}*/
		
	}

}
