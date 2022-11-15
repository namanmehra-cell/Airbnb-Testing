package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Project {
	WebDriver driver;
	String url = "https://www.airbnb.co.in/";
	String browser  = "chrome";
	
@Test
public void booting() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));;
	driver.get(url);
	driver.manage().window().maximize();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//driver.findElement(By.xpath("//button[@data-stid=\"location-field-destination-menu-trigger\"]")).click();
	driver.findElement(By.xpath("//div[text()=\"Add guests\"]")).click();
	WebElement element = driver.findElement(By.xpath("//input[@placeholder=\"Search destinations\"]"));
	element.sendKeys("Delhi");
	Actions action = new Actions(driver); 
	action.sendKeys(element,Keys.ARROW_DOWN).perform();
	Thread.sleep(1000);
	action.sendKeys(element,Keys.ENTER).perform();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@data-testid=\"calendar-day-16/11/2022\"]")).click();
	driver.findElement(By.xpath("//div[@data-testid=\"calendar-day-13/12/2022\"]")).click();
	driver.findElement(By.xpath("//div[@class='p1kudodg dir dir-ltr']")).click();
	WebElement elem1 =  driver.findElement(By.xpath("//button[@aria-label=\"increase value\"][1]"));
	action.doubleClick(elem1).perform();
	WebElement elem2 =  driver.findElement(By.xpath("//button[@data-testid='stepper-children-increase-button']"));
	action.click(elem2).perform();
	driver.findElement(By.xpath("//span[@class='_kaq6tx']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()=\"Filters\"]")).click();
	driver.findElement(By.xpath("//div[text()='Private room']")).click();
	driver.findElement(By.xpath("//footer[@class=\"_zgc1p6\"]//a")).click();
 driver.findElement(By.xpath("(//div[contains(@role,'group')])[6]")).click();
//	tags.get(1).click();
	ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(windows.get(1));
	js.executeScript("window.scrollBy(0,750)");
	System.out.println(driver.findElement(By.tagName("h1")).getText());
	driver.findElement(By.xpath("//button[@class='_qqb2vcb']//span[@class='t12u7nq4 dir dir-ltr']")).click();
}
@BeforeMethod
public void settingUp() {
	System.out.println("Setting up");
	driver = utilities.DriverType.open(browser);
}

}
