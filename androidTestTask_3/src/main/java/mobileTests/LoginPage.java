package mobileTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class LoginPage extends PagesBase  {

	
    public LoginPage(WebDriver driver) {
	        super(driver);
	    }

    
     @Test
     public void validLogin() {
		
		validLoginTest();
		
     	}
     
     @Test
    public void invalidLogin() {
		
		invalidLoginTest();
		
     	}
    
 }



