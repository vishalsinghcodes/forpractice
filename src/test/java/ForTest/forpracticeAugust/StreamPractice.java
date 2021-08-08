package ForTest.forpracticeAugust;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamPractice {

	public static void main(String[] args) throws IOException {
		String path = "F:\\Udemy Selenium\\Excel for Apache POI practice\\Book1.xlsx";
		String pathfile = "C:\\Users\\Vishal Singh\\eclipse-workspace\\forpracticeAugust\\abc.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(path);
		FileInputStream fis2 = new FileInputStream(pathfile);
		prop.load(fis2);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		String finalString = null;

		int noofsheets = workbook.getNumberOfSheets();

		for (int i = 0; i < noofsheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Link")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> ri = sheet.iterator();
				Row rowone = ri.next();

				Iterator<Cell> ci = rowone.cellIterator();

				int k = 0, count = 0;
				while (ci.hasNext()) {
					k++;
					if (ci.next().getStringCellValue().equalsIgnoreCase("Link"))
						count = k;
				}

				while (ri.hasNext()) {
					Row reqrow = ri.next();
					if (reqrow.getCell(0).getStringCellValue().equalsIgnoreCase("Prime Minister")) {
						Iterator<Cell> cii = reqrow.cellIterator();
						finalString = reqrow.getCell(count - 1).getStringCellValue();
					}
				}

			}

		}

		System.out.print(finalString);

		System.setProperty("webdriver.chrome.driver",
				"F:\\\\Udemy Selenium\\\\WebDrivers\\\\Chrome\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(finalString, Keys.ENTER);

	}

}
