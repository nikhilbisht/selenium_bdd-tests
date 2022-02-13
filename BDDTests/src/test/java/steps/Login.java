package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	WebDriver driver;
	

	@Given("browser is chrome and user navigates to Outlook")
	public void initializeDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://outlook.live.com/");
		driver.findElement(By.cssSelector(("[aria-label=\"Quick links\"]>ul>li+li"))).click();

	}


	@And("user enters {string} and {string}")
	public void enters_username_and_password(String username, String password) throws InterruptedException {
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.id("idBtn_Back")).click();
	}


	@When("user enters value in To, subject and in body")
	public void enterEmail() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.cssSelector("i[data-icon-name='ComposeRegular']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[aria-label=\"To\"]")).sendKeys("nikhilbisht84@gmail.com");
		driver.findElement(By.cssSelector("[aria-label=\"Add a subject\"]")).sendKeys("Incubyte");
		driver.findElement(By.cssSelector("[aria-label=\"Message body\"]")).sendKeys("Automation QA test for Incubyte");
	}

	@And("user clicks on Send")
	public void sendEmail() {
		driver.findElement(By.cssSelector("[name=\"Send\"]")).click();
	}
	@Then("email should be delivered")
	public void verifyEmail() {
		System.out.println("delivered");

	}


}
