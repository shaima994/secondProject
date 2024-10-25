import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases2 {
	
   WebDriver driver = new ChromeDriver();
   Actions action = new Actions(driver);
   
   String myWebsite = "https://automationteststore.com/";
   
   
   
   String[] firstNames = {"Rama", "Leen", "Malak" ," Omar", "Mohammad", "Ahmad"};
   String[] lastNames = {"Khaled", "Abdallah", "Ali", "Alaa", "Rami"} ;
   
   Random rand = new Random();
   
   @BeforeTest 
    public void mySetup(){
	   
	   driver.manage().window().maximize();
	   driver.get(myWebsite);
	   
	   
   }
   
   
	   @Test(priority = 1)
		public void signUp() throws InterruptedException {

			int RandomIndexForTheFirstName = rand.nextInt(firstNames.length);
			int RandomIndexForTheLastName = rand.nextInt(lastNames.length);

			String UserFirstName = firstNames[RandomIndexForTheFirstName];
			String UserLastName = lastNames[RandomIndexForTheLastName];

			int randomNumberForTheEmail = rand.nextInt(564);

			String domainName = "@gmail.com";

			String email = UserFirstName + UserLastName + randomNumberForTheEmail + domainName;

			;

			// take the full text only work with the (a)tag
			driver.findElement(By.linkText("Login or register")).click();

			WebElement SignUpButton = driver.findElement(By.xpath("//button[@title='Continue']"));

			SignUpButton.click();

			Thread.sleep(2000);

			WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
			FirstNameInput.sendKeys(UserFirstName);
			WebElement LastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
			LastNameInput.sendKeys(UserLastName);
			WebElement EmailInput = driver.findElement(By.id("AccountFrm_email"));
			EmailInput.sendKeys(email);
			WebElement AdressInput = driver.findElement(By.id("AccountFrm_address_1"));
			AdressInput.sendKeys("amman city - tlaa al ali");
			WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
			CityInput.sendKeys("capital city");

			WebElement CountryInput = driver.findElement(By.id("AccountFrm_country_id"));

			Select selector2 = new Select(CountryInput);
			
			int randomCountry = rand.nextInt(1, 240);

			selector2.selectByIndex(randomCountry);
			
			Thread.sleep(3000);

			WebElement ZoneIdInput = driver.findElement(By.id("AccountFrm_zone_id"));
			Select selector = new Select(ZoneIdInput);
			int randomState = rand.nextInt(1, 6);

			selector.selectByIndex(randomState);

			WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
			PostalCodeInput.sendKeys("13310");
	WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));

	LoginNameInput.sendKeys(UserFirstName+UserLastName+randomNumberForTheEmail);
	WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
	PasswordInput.sendKeys("iLoveMyMom123@");
	WebElement ConfirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
	ConfirmPasswordInput.sendKeys("iLoveMyMom123@");


	WebElement AgreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));
	AgreeCheckBox.click();

	WebElement ContinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));

	ContinueButton.click();



		}

		@Test(priority = 2)

		public void Logout() throws InterruptedException {

			Thread.sleep(5000);
			
			  WebElement logout =
			  driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a/div"));
			  action.moveToElement(logout).moveToElement(driver.findElement(By.xpath("/html/body/div/"
			  		+ "header/div[1]/div/div[2]/div/div[2]/div/ul/li/ul/li[10]"))).click().build().perform();
			 
			

		}
		
		
		
		

	}

	   

   
   
   
   

	
	
