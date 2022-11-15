package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverType {
	public static WebDriver open(String browserType) {
		if(browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Automation Softs\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "C:\\Automation Softs\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
}