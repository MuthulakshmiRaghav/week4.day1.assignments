package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceService {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Salesforce Customer service: 
		 * 1.Launch the browser 
		 * 2.Load the url as " https://login.salesforce.com/ " 
		 * 3.Enter the username as " ramkumar.ramaiah@testleaf.com " 
		 * 4. Enter the password as " Password$123 "
		 * 5.click on the login button 
		 * 6.click on the learn more option in the Mobile publisher 
		 * 7.Switch to the next window using Windowhandles. 
		 * 8.click on the confirm button in the redirecting page 
		 * 9.Get the title 
		 * 10.Get back to the parent window 
		 * 11.close the browser
		 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();

		// Enter the username and Password
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");

		// click on the login button
		driver.findElement(By.id("Login")).click();

		// click on the learn more option in the Mobile publisher
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		// Switch to the next window using Windowhandles
		Set<String> numOfWindows = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(numOfWindows);

		String firstWindow = listOfWindows.get(0);
		String secondWindow = listOfWindows.get(1);
		driver.switchTo().window(secondWindow);

		// click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

		// Get the title
		System.out.println(driver.getTitle());

		// Get back to the parent window
		driver.switchTo().window(firstWindow);

		// close the browsers
		// driver.quit();
	}

}
