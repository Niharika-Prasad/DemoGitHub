package githubdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public static WebDriver driver;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://gmail.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);

		}
	}
	
	@Test(priority = 1)
	public void doLogin() {

		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("niharikaprasad.cse@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();

	}


	@AfterSuite
	public void tearDown() {

		driver.quit();

	}

}
