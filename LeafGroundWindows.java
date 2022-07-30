package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindows {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();

		// Click button to open home page in New Window
		driver.findElement(By.id("home")).click();

		Set<String> num1Windows = driver.getWindowHandles();
		List<String> list1OfWindows = new ArrayList<String>(num1Windows);

		String firstWindow = list1OfWindows.get(0);
		String secondWindow = list1OfWindows.get(1);
		driver.switchTo().window(secondWindow);
		driver.close();

		driver.switchTo().window(firstWindow);

		// Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		int openWindows = driver.getWindowHandles().size();
		System.out.println("Opened Windows are " + openWindows);

		// Close all except this window
		Set<String> num2Windows = driver.getWindowHandles();
		List<String> list2OfWindows = new ArrayList<String>(num2Windows);

		String firWindow = list2OfWindows.get(0);
		String secWindow = list2OfWindows.get(1);
		String thridWindow = list2OfWindows.get(2);
		driver.switchTo().window(thridWindow);
		driver.close();
		driver.switchTo().window(secWindow);
		driver.close();
		driver.switchTo().window(firWindow);

		// Wait for 2 new Windows to open
		driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		Set<String> set3Windows = driver.getWindowHandles();
		List<String> list3OfWindows = new ArrayList<String>(set3Windows);

		String fWindow = list3OfWindows.get(0);
		String sWindow = list3OfWindows.get(1);
		String tWindow = list3OfWindows.get(2);
		driver.switchTo().window(tWindow);
		System.out.println("Third Window Title is " + driver.getTitle());
		driver.switchTo().window(sWindow);
		System.out.println("Second Window Title is " + driver.getTitle());
		driver.switchTo().window(fWindow);
		System.out.println("First Window Title is " + driver.getTitle());

	}

}
