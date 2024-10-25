import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();

	String myWebsite = "https://magento.softwaretestingboard.com/";

	String myWebsite2 = "https://www.google.com";

	String[] firstNames = { "ahmad", "ali", "anas", "omar", "ayat", "alaa", "sawsan", "Rama" };
	String[] LastNames = { "Khaled", "mustafa", "Mohammad", "abdullah", "malek", "omar" };

	Random rand = new Random();

	int RandomIndexForTheFirstName = rand.nextInt(firstNames.length);
	int RandomIndexForTheLastName = rand.nextInt(LastNames.length);
	int randomNumberForTheEmail = rand.nextInt(564548);
	
	String UserFirstName = firstNames[RandomIndexForTheFirstName];
	String UserLastName = LastNames[RandomIndexForTheLastName];
	
	
	String domainName = "@gmail.com"; 

	

	@BeforeTest
	public void mySetup() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get(myWebsite);
//		driver.navigate().to(myWebsite2);
//		driver.navigate().back();
//		driver.navigate().forward();
//		System.out.println(driver.getCurrentUrl().toUpperCase());
//		System.out.println(driver.getTitle());
//		Thread.sleep(5000);
//	driver.navigate().refresh(); 
		
		

	}

	@Test(priority = 1)
	public void signUp() throws InterruptedException {
		
		

	

		// take the full text only work with the (a)tag
		driver.findElement(By.linkText("Create an Account")).click();

		Thread.sleep(5000);

		driver.navigate().refresh();

		// //take the part of the text only work with the (a)tag eza mtkasel w mosh 7abb
		// tktob el klmeh kamleh
		driver.findElement(By.partialLinkText("Create an Account")).click();

		WebElement FirstNameInput = driver.findElement(By.id("firstname"));
		FirstNameInput.sendKeys(UserFirstName);
		WebElement LastNameInput = driver.findElement(By.id("lastname"));
		LastNameInput.sendKeys(UserLastName);
		WebElement EmailInput = driver.findElement(By.id("email_address"));
		EmailInput.sendKeys(UserFirstName+UserLastName+randomNumberForTheEmail+domainName);
		WebElement PasswordInput = driver.findElement(By.id("password"));
		PasswordInput.sendKeys("ilovemyMom1233@44");
		WebElement ConfirmPasswordInput = driver.findElement(By.id("password-confirmation"));
		ConfirmPasswordInput.sendKeys("ilovemyMom1233@44");
		
		Thread.sleep(4000);
		WebElement CreateAnAccountbutton = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));

		CreateAnAccountbutton.click();
		;

	}
	
	@Test(priority = 2)
	
	public void Logout() throws InterruptedException {
		
		Thread.sleep(5000);
		String LogoutURl = "https://magento.softwaretestingboard.com/customer/account/logout/";
		driver.get(LogoutURl);
				
				
	}
	
	
	
    @Test(priority = 3)
	
	public void Login() throws InterruptedException {
		
    	Thread.sleep(5000);
    	String LoginURL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
    	driver.get(LoginURL);
    	
    	WebElement EmailInput = driver.findElement(By.id("email"));
		EmailInput.sendKeys(UserFirstName+UserLastName+randomNumberForTheEmail+domainName);
		WebElement PasswordInput = driver.findElement(By.id("pass"));
		PasswordInput.sendKeys("ilovemyMom1233@44");
		
		Thread.sleep(4000);
		WebElement SignInbutton = driver.findElement(By.xpath("//*[@id=\"send2\"]"));

		SignInbutton.click();
		;
				
				
	}
	
	
	
	
}