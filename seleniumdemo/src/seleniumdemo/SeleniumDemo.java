package seleniumdemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\web drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = "https://www.highcharts.com/demo/line-ajax";

		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = driver.findElement(By.xpath(
				".//*[@id='container']/div/*[name()='svg']/*[name()='g'][7]/*[name()='g'][4]/*[name()='path'][19]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				".//*[@id='container']/div/*[name()='svg']/*[name()='g'][7]/*[name()='g'][4]/*[name()='path'][19]")));
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='container']/div/*[name()='svg']/*[name()='g'][15]//*[name()='tspan'][7]")));
		String session_count1 = driver
				.findElement(
						By.xpath(".//*[@id='container']/div/*[name()='svg']/*[name()='g'][15]//*[name()='tspan'][7]"))
				.getText();
		System.out.println("Session count 1: " + session_count1);
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='highslide-maincontent']")));
		String session_count2 = driver.findElement(By.xpath(".//div[@class='highslide-maincontent']")).getText();

		System.out.println("Session count 2: " + session_count2);
		if (session_count2.contains(session_count1))
			System.out.println("Test Case Passed");
		else
			System.out.println("Test Case Failed");

		driver.close();

	}

}
