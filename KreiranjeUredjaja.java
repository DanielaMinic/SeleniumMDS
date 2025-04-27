package TestMDSInzenjering;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;





public class KreiranjeUredjaja {

	public static void main(String[] args) {
        // Set up ChromeDriver
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize(); 

        
        driver.get("https://demo.netbox.dev/");

        
        WebElement login = driver.findElement(By.linkText("Log In"));
        login.click();

        
        WebElement usernameField = driver.findElement(By.id("id_username"));
        usernameField.sendKeys("TestUser");

        WebElement passwordField = driver.findElement(By.id("id_password"));
        passwordField.sendKeys("StrongPassword12");

        
        WebElement loginButton = driver.findElement(By.cssSelector(".w-100"));
        loginButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        WebElement devicesMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Devices']/ancestor::a")));
        devicesMenu.click();

        WebElement deviceTypesLink = driver.findElement(By.linkText("Device Types"));
        deviceTypesLink.click();

        WebElement addButton = driver.findElement(By.linkText("Add"));
        addButton.click();

        WebElement manufacturerInput = driver.findElement(By.id("id_manufacturer-ts-control"));
        manufacturerInput.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_manufacturer-opt-4")));
        WebElement ciscoOption = driver.findElement(By.id("id_manufacturer-opt-4"));
        ciscoOption.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_model"))).clear();
        driver.findElement(By.id("id_model")).sendKeys("Model1");            
        
        WebElement platformeInput = driver.findElement(By.id("id_default_platform-ts-control"));
        platformeInput.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_default_platform-opt-4")));
        WebElement fourthOption = driver.findElement(By.id("id_default_platform-opt-4"));
        fourthOption.click();


        WebElement descriptionField = driver.findElement(By.id("id_description"));
        descriptionField.sendKeys("This is description");
        
        WebElement tagInput = driver.findElement(By.id("id_tags-ts-control"));
        tagInput.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_tags-opt-1")));
        WebElement alphaOption = driver.findElement(By.id("id_tags-opt-1"));
        alphaOption.click();
        
        WebElement heightField = driver.findElement(By.id("id_u_height"));
        heightField.sendKeys("2");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_part_number"))).clear();
        driver.findElement(By.id("id_part_number")).sendKeys("100");   
        
        WebElement parentInput = driver.findElement(By.id("id_subdevice_role-ts-control"));
        parentInput.click();

        
        WebElement childOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[@id='id_subdevice_role-ts-dropdown']//div[text()='Parent']")));
        childOption.click();
        
        WebElement airflowInput = driver.findElement(By.id("id_airflow-ts-control"));
        airflowInput.click();

        
        WebElement frontOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[@id='id_airflow-ts-dropdown']//div[text()='Front to rear']")));
        frontOption.click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_weight"))).clear();
        driver.findElement(By.id("id_weight")).sendKeys("10");  
        
        WebElement weightInput = driver.findElement(By.id("id_weight_unit-ts-control"));
        weightInput.click();

        
        WebElement weightOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[@id='id_weight_unit-ts-dropdown']//div[text()='Kilograms']")));
        weightOption.click();
        
        WebElement file1Input = driver.findElement(By.id("id_front_image"));
        file1Input.sendKeys("C:\\Users\\Daniela\\Desktop\\front.jpg");
        
        WebElement file2Input = driver.findElement(By.id("id_rear_image"));
        file2Input.sendKeys("C:\\Users\\Daniela\\Desktop\\rear.jpg");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_comments"))).clear();
        driver.findElement(By.id("id_comments")).sendKeys("Ovo su komentari!");  
        
        WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("_create")));
        createButton.click();
        
        }
	}

        