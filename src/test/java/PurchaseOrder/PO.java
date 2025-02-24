package PurchaseOrder;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PO {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://qualiantracker.dyndns.org:9090/grpmain/security/Login");
		driver.findElement(By.id("user")).sendKeys("Openbravo");
		driver.findElement(By.id("password")).sendKeys("12");
		driver.findElement(By.id("buttonOK")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr//td//img[@name='isc_Bmain']")));
		driver.findElement(By.xpath("//tr//td//img[@name='isc_Bmain']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr//td//input[@name='value']")));
		driver.findElement(By.xpath("//tr//td//input[@name='value']")).sendKeys("Purchase order and contracts summary");
		Thread.sleep(2000);
		List<WebElement> list = driver
				.findElements(By.xpath("//nobr[contains(text(),'Purchase Order and Contracts Summary')]"));
		for (WebElement row : list) {
			String PO = row.getText();
			if (PO.equalsIgnoreCase("Purchase Order and Contracts Summary")) {
				row.click();
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='OBToolbarIconButton_icon_newDoc OBToolbarIconButton']")));
		driver.findElement(By.xpath("//td[@class='OBToolbarIconButton_icon_newDoc OBToolbarIconButton']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr//td//img[@name='isc_14Lmain']")));
		driver.findElement(By.xpath("//table//tr//td//img[@name='isc_14Lmain']")).click();
		driver.quit();

	}
}
