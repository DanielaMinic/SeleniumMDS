package TestMDSInzenjering;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KreiranjeKorisnika {

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
	     
	     WebElement clickhere = driver.findElement(By.linkText("Click here"));
	     clickhere.click();
	       
		 
         WebElement usernameField = driver.findElement(By.id("id_username")); 
         usernameField.sendKeys("TestUser");

         WebElement passwordField = driver.findElement(By.id("id_password")); 
         passwordField.sendKeys("StrongPassword12");

         
         WebElement clikbutton = driver.findElement(By.cssSelector(".mt-4"));
         clikbutton.click();
         
         

       }
 }

