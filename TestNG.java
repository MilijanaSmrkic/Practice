package task4;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG {

	public static WebDriver driver;
	SoftAssert sa = new SoftAssert();

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chromedriver.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.l8test.com");
		driver.manage().window().maximize();
	}

	@Test
	public void testInputField() {

		boolean field = driver.findElement(By.xpath("//*[@id=\"form1\"]/input")).isDisplayed();
		sa.assertEquals(field, true);
		if (field == false) {
			TakesScreenshot testInputField = ((TakesScreenshot) driver);
		}

		field = driver.findElement(By.xpath("//*[@id=\"form1\"]/input")).isEnabled();
		sa.assertEquals(field, true);
		if (field == false) {
			TakesScreenshot testInputField = ((TakesScreenshot) driver);
		}

		String isEmpty = driver.findElement(By.xpath("//*[@id=\"form1\"]/input")).getText();
		sa.assertEquals(isEmpty, "");
		if (isEmpty != "") {
			TakesScreenshot testInputField = ((TakesScreenshot) driver);
		}

		driver.findElement(By.xpath("//*[@id=\"form1\"]/input")).sendKeys("asdfghjklu");
		String text = driver.findElement(By.xpath("//*[@id=\"form1\"]/input")).getText();
		sa.assertEquals(text, "asdfghjklu");
		if (text != "asdfghjklu") {
			TakesScreenshot testInputField = ((TakesScreenshot) driver);
		}

		driver.findElement(By.xpath("//*[@id=\"form1\"]/input")).clear();
		text = driver.findElement(By.xpath("//*[@id=\"form1\"]/input")).getText();
		sa.assertEquals(text, "");
		if (text != "") {
			TakesScreenshot testInputField = ((TakesScreenshot) driver);
		}

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		format.setTimeZone(TimeZone.getTimeZone("CST"));
		String currentTime = format.format(calendar.getTime());

		driver.findElement(By.xpath("//*[@id=\"form1\"]/input")).sendKeys(currentTime);
		String checkTime = driver.findElement(By.xpath("//*[@id=\"form1\"]/input")).getText();
		sa.assertEquals(checkTime, currentTime);
		if (checkTime != currentTime) {
			TakesScreenshot testInputField = ((TakesScreenshot) driver);
		}

		sa.assertAll();
		driver.close();

	}

}
