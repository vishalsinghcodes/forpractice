package ForTest.forpracticeAugust;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForPopUP {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"F:\\\\Udemy Selenium\\\\WebDrivers\\\\Chrome\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://the-internet.herokuapp.com/");
		//https://the-internet.herokuapp.com/
		String un = "admin";
		String pw = "admin";
		String URL = "https://"+un+":"+pw+"@"+"the-internet.herokuapp.com/";
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
		
		//Hey Vishal I have added this code..........
		
		// Ok i got your cahnges sanchit
		


	}

}
