package variousConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningWindowHandle {

	WebDriver driver;
@Before
	public void launchingWindow() {
		System.setProperty("webdriver.chrome.driver", "driverr\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test
	public void windowHandleTest () throws InterruptedException {
		// To get an Unique Number for Windows like Mac Address
//		System.out.println(driver.getTitle());
//		String handle1 = driver.getWindowHandle();
//		System.out.println(handle1);
		
		driver.findElement(By.id("ybar-sbq")).sendKeys("xpath");
		driver.findElement(By.id("ybar-search")).click();
		Thread.sleep(3000);
//		System.out.println(driver.getTitle());
//		String handle2 = driver.getWindowHandle();
//		System.out.println(handle2);
		
		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		System.out.println(driver.getTitle());
		Set<String> handle3 = driver.getWindowHandles();
		System.out.println(handle3);
		// when we want to go to another Tab we can use for each
		for (String i : handle3) {
			System.out.println(i);
			driver.switchTo().window(i);
			
		}
		System.out.println(driver.getTitle());
		
	
	}
}
