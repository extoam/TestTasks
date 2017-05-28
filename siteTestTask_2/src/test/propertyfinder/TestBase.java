package test.propertyfinder;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
 


    public class TestBase {
	
	
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  HSSFWorkbook workbook;
	  HSSFSheet sheet;
	  HSSFCell cell;
	  private XSSFWorkbook wb;

	  @BeforeTest
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.propertyfinder.ae";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  

	  protected void openSite() {
			driver.get(baseUrl + "/");
		    driver.findElement(By.name("q")).click();
		    driver.findElement(By.name("q")).clear();
		}

		
	  protected void searchFirstAreaFromFile() throws IOException {
			
			// Input 1st value from the file (Marina Dubai)	
			ArrayList<String> area=ReadDataFromFile.readExcelDataFile(1);
			driver.findElement(By.name("q")).sendKeys(area.get(0));
		}
	  protected void selectSearchParameters() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    driver.findElement(By.xpath("//form[@id='search-form-property']/div[4]/div/div/div/div/ul/li[2]")).click();

	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#bedroom_group > div.pure-u-1-2 > div.ms-parent > button.ms-choice")).click();
	    driver.findElement(By.xpath("//div[@id='bedroom_group']/div/div/div/ul/li[4]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
	    driver.findElement(By.xpath("//div[@id='bedroom_group']/div[2]/div/div/ul/li[10]")).click();
	  }
	  
	  protected void submitSearch() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	}

		

	  protected void sortSearchResultLowPrice() throws InterruptedException {
			Thread.sleep(5000);
		    driver.findElement(By.cssSelector("div.sort > div.ms-parent > button.ms-choice")).click();
		    driver.findElement(By.xpath("//section[@id='serp-nav']/div/div/div/div/ul/li[3]")).click();
		    Thread.sleep(5000);
		}	
	  
	  protected void scrollDown() {
			WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section[3]/section/ul/li[27]"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}

	  protected void openLastSearchResult() throws InterruptedException {
			Thread.sleep(5000); 
		    driver.findElement(By.xpath("/html/body/div[2]/div[1]/section[3]/section/ul/li[27]")).click();
		    Thread.sleep(2000);
		}

	
	  protected void verifyApartmentIsTwoBerdroom() {
				try {
			      assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/section[2]/section[2]/div/section[1]/table/tbody/tr[5]")).getText(), "Bedrooms 2");
			      System.out.println("Appartment has "+ driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/section[2]/section[2]/div/section[1]/table/tbody/tr[5]")).getText()); 
			    } catch (Error e) {
			      verificationErrors.append(e.toString());
			      System.out.println("Appartment doesn't have 2 bedrooms, it has "+ driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/section[2]/section[2]/div/section[1]/table/tbody/tr[5]")).getText()); 

			    }
			}
	 

	@AfterTest
		public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      Assert.fail(verificationErrorString);
		    }
		  }
}
	
	
	


