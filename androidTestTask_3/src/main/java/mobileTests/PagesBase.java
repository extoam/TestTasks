package mobileTests;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PagesBase {
	
	private String validEmail = "testfract2@yandex.ru";
    private String Password = "qwerty1234";
	
    private String invalidEmail = "invalidemail";
    private String randomPassword = "12345";
    private String expectedErrorMessage = "Email address invalid";
	
	

	 protected WebDriver driver;

	    public PagesBase(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    public LoginPage validLoginTest() {
	    	WebElement emailLoginButton = driver.findElement(By.id("de.komoot.android:id/button_mail_login"));
	    	emailLoginButton.click();
	    	
	    	WebElement emailTextField = (WebElement) (new WebDriverWait(driver,60))
	    			.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("de.komoot.android:id/txt_user_name")));
	    	emailTextField.sendKeys(validEmail);
	    	
	    	WebElement passwordTextField = driver.findElement(By.id("de.komoot.android:id/txt_password"));
	    	passwordTextField.sendKeys(Password);
	    	
	    	WebElement loginButton =driver.findElement(By.id("de.komoot.android:id/btn_login"));
	    	loginButton.click();
	    	
	    	WebElement logoutButton =driver.findElement(By.id("de.komoot.android:id/btn_logout"));
	    	logoutButton.click();
	    	
	    	return new LoginPage(driver);
	    }
	    
	    
	    public LoginPage invalidLoginTest() {
			WebElement emailLoginButton = driver.findElement(By.id("de.komoot.android:id/button_mail_login"));
			emailLoginButton.click();
			
			WebElement emailTextField = (WebElement) (new WebDriverWait(driver,60))
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("de.komoot.android:id/txt_user_name")));
			emailTextField.sendKeys(invalidEmail);
			
			WebElement passwordTextField = driver.findElement(By.id("de.komoot.android:id/txt_password"));
			passwordTextField.sendKeys(randomPassword);
			
			WebElement loginButton =driver.findElement(By.id("de.komoot.android:id/btn_login"));
			loginButton.click();
			
			WebElement errorMessage = (WebElement) (new WebDriverWait(driver,60))
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("de.komoot.android:id/message")));
			assertEquals(errorMessage.getText(), expectedErrorMessage);	
			return new LoginPage(driver);
		}
	    
	   
	}

