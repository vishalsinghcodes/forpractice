package ForTest.forpracticeAugust;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoIT {
	
	public static void main(String [] abc) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"F:\\\\Udemy Selenium\\\\WebDrivers\\\\Chrome\\\\chromedriver.exe");
		ChromeOptions c = new ChromeOptions();
		c.addArguments("--disable-notification");
		
		WebDriver driver = new ChromeDriver(c);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://smallpdf.com/jpg-to-pdf");
		Thread.sleep(2000L);
		driver.findElement(By.cssSelector("div[class*='sc-2xfn8l-0 bxyVaO sxq67w-0 sc-1c9rd1d-0 ccSOtz']")).click();
		//driver.findElement(By.cssSelector("#file-upload")).click();
		//driver.findElement(By.name("file")).click();
		driver.findElement(By.xpath("//span[text()='Choose Files']")).click();
		Thread.sleep(2000L);
		Runtime.getRuntime().exec("F:\\AutoIT Scripts\\fileuploadforautoit.exe");
		
	}

}
