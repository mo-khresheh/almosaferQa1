import static org.testng.Assert.assertEquals;
import java.security.PublicKey;
import java.sql.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();
	String almosaferURL = "https://www.almosafer.com/en";

	@BeforeTest
	public void MySetup() {

		driver.manage().window().maximize();

		driver.get(almosaferURL);

		WebElement preferedcountryButton = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		preferedcountryButton.click();

	}

	@Test(priority = 1)
	public void ChecktheEnglishLanguagIsDefault() {

		String ActualLanguag = driver.findElement(By.tagName("html")).getAttribute("lang");

		String ExpectedLanguag = "en";

		assertEquals(ActualLanguag, ExpectedLanguag);

	}

	@Test(priority = 2)
	public void ChecktheDefaultCurrencyIsSAR() {

		String ActualCurrency = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/div[1]/div/button")).getText();
		String ExpectedCurrency = "SAR";

		assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3)
	public void CheckContactNumber() {

		String ActaulContactNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		String ExpectedContactNumber = "+966554400000";

		assertEquals(ActaulContactNumber, ExpectedContactNumber);

	}

	@Test(priority = 4)
	public void QitafLogoisDispalyed() {

		boolean ActualQitafLogo = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
		boolean ExpectedQitafLogo = true;

		assertEquals(ActualQitafLogo, ExpectedQitafLogo);

	}

}
