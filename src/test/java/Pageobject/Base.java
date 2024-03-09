package Pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome")String browser) {

		switch (browser.toLowerCase())
		{
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case"msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		}
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	public void explicit(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void zoomin() throws AWTException {

		Robot robot = new Robot();
		for (int i = 0; i < 2; i++) {			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
		}}
	
	public void scroll(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);		
	}
	@AfterClass

	public void teardown() {
		driver.close();
	}
}
