package TestMDSInzenjering;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NevalidnoLogovanje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//instaciranje browser drivera
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		//odlazak na demo.netbox.dev stranicu
		 driver.get("https://demo.netbox.dev/");
		 
		 
		 WebElement login = driver.findElement(By.linkText("Log In"));
	     login.click();
	   
       
	     WebElement usernameField = driver.findElement(By.id("id_username")); 
         usernameField.sendKeys("TestUser1");

         WebElement passwordField = driver.findElement(By.id("id_password")); 
         passwordField.sendKeys("StrongPassword1234");

        
         WebElement clikbutton = driver.findElement(By.cssSelector(".w-100"));
         clikbutton.click();
         
         String expectedErrorText = "Please enter a correct username and password. Note that both fields may be case-sensitive.";
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
             By.cssSelector("ul.errorlist.nonfield > li")));

         String actualErrorText = errorMessage.getText();

         if (actualErrorText.equals(expectedErrorText)) {
             System.out.println("Test passed: Correct error message displayed.");
         } else {
             System.out.println("Test failed: Unexpected error message.");
             System.out.println("Expected: " + expectedErrorText);
             System.out.println("Actual: " + actualErrorText);
         }
        
     
     }
 }
