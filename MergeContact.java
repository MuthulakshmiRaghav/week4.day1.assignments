package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * //Pseudo Code 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 2.Enter UserName and Password Using Id Locator 
		 * 3. Click on Login Button using Class Locator 
		 * 4. Click on CRM/SFA Link 
		 * 5. Click on contacts Button 
		 * 6. Click on Merge Contacts using Xpath Locator 
		 * 7. Click on Widget of From Contact 
		 * 8. Click on First Resulting Contact 
		 * 9. Click on Widget of To Contact 
		 * 10. Click on Second Resulting Contact 
		 * 11. Click on Merge button using Xpath Locator 
		 * 12. Accept the Alert 13. Verify the title of the page
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		// 2.Enter UserName and Password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 3. Click on Login Button
		driver.findElement(By.className("decorativeSubmit")).click();

		// 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// 6. Click on Merge Contacts
		driver.findElement(By.xpath("//li/a[text()='Merge Contacts']")).click();

		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//span[@class='requiredField'])[1]/following::a")).click();

		// Switch to Second Window
		Set<String> numOfWindows = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(numOfWindows);

		String firstWindow = listOfWindows.get(0);
		String secondWindow = listOfWindows.get(1);
		driver.switchTo().window(secondWindow);
		Thread.sleep(3000);

		// 8. Click on First Resulting Contact
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		// 9. Click on Widget of To Contact
		driver.switchTo().window(firstWindow);
		driver.findElement(By.xpath("//td/span[text()='To Contact']//following::a")).click();

		// 10. Click on Second Resulting Contact
		Set<String> numOfWindows2 = driver.getWindowHandles();
		List<String> listOfWindows2 = new ArrayList<String>(numOfWindows2);

		String firstWindow2 = listOfWindows2.get(0);
		String secondWindow2 = listOfWindows2.get(1);
		driver.switchTo().window(secondWindow2);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(firstWindow2);

		// 11. Click on Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// 13. Verify the title of the page
		System.out.println(driver.getTitle());
		
		

	}

}
