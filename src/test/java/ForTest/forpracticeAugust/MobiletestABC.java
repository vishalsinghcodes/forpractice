package ForTest.forpracticeAugust;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobiletestABC {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"F:\\\\Udemy Selenium\\\\WebDrivers\\\\Chrome\\\\chromedriver.exe");
		DesiredCapabilities dc = new DesiredCapabilities().chrome();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.acceptInsecureCerts();
		ChromeOptions c = new ChromeOptions();
		c.addArguments("--disable-notifications");
		c.addArguments("--headless");
		c.merge(dc);
		WebDriver driver = new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// driver.get("https://the-internet.herokuapp.com/");
		// driver.get("https://jqueryui.com/droppable/");
		// driver.get("https://www.lenskart.com/");

//		///div[@class=' footer_top_agile_w3ls gffoot footer_style']/table//tr/td[last()]/ul/li/a

		List<WebElement> urls = driver.findElements(
				By.xpath("//div[@class=' footer_top_agile_w3ls gffoot footer_style']/table//tr/td[last()]/ul/li/a"));

		for (WebElement e : urls) {
			String url = e.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int sc = conn.getResponseCode();
			if (sc<=400) {
				System.out.println(url +" is working");
			}else
				System.out.println(url +" is not working");
		}

		Thread.sleep(2000);
		driver.close();

	}

}
