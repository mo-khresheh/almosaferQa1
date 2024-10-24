import static org.testng.Assert.assertEquals;
import java.security.PublicKey;
import java.sql.Driver;
import java.time.LocalDate;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();
	String almosaferURL = "https://www.almosafer.com/en";
	Random rand = new Random();

	@BeforeTest
	public void MySetup() {

		driver.manage().window().maximize();

		driver.get(almosaferURL);

		WebElement preferedcountryButton = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		preferedcountryButton.click();

	}

	@Test(priority = 1, enabled = false)
	public void ChecktheEnglishLanguagIsDefault() {

		String ActualLanguag = driver.findElement(By.tagName("html")).getAttribute("lang");

		String ExpectedLanguag = "en";

		assertEquals(ActualLanguag, ExpectedLanguag);

	}

	@Test(priority = 2, enabled = false)
	public void ChecktheDefaultCurrencyIsSAR() {

		String ActualCurrency = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/div[1]/div/button")).getText();
		String ExpectedCurrency = "SAR";

		assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() {

		String ActaulContactNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		String ExpectedContactNumber = "+966554400000";

		assertEquals(ActaulContactNumber, ExpectedContactNumber);

	}

	@Test(priority = 4, enabled = false)
	public void QitafLogoisDispalyed() {

		boolean ActualQitafLogo = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG"))
				.isDisplayed();
		boolean ExpectedQitafLogo = true;

		assertEquals(ActualQitafLogo, ExpectedQitafLogo);

	}

	@Test(priority = 5, enabled = false)
	public void CheckHotelTabIsNotSelected() {

		String ActualHotelTabIsNotSelected = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]")).getAttribute("aria-selected");
		String ExpectedHotelTabIsNotSelected = "false";

		assertEquals(ActualHotelTabIsNotSelected, ExpectedHotelTabIsNotSelected);

	}

	@Test(priority = 6, enabled = false)
	public void CheckDepatureDate() {

		int Today = LocalDate.now().getDayOfMonth();
		int Tomowrow = LocalDate.now().plusDays(1).getDayOfMonth();

		String ActualDepatureDate = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText();
		String ExpectedDepatureDate = Integer.toString(Tomowrow);

		assertEquals(ActualDepatureDate, ExpectedDepatureDate);

	}

	@Test(priority = 7, enabled = false)
	public void CheckReturnDate() {

		int Today = LocalDate.now().getDayOfMonth();
		int AfterTomowrow = LocalDate.now().plusDays(2).getDayOfMonth();

		String ActualReturnDate = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();
		String ExpectedReturnDate = Integer.toString(AfterTomowrow);

		assertEquals(ActualReturnDate, ExpectedReturnDate);

	}

	@Test(priority = 8)
	public void RandomlyChangeTheLanguage() {

		String[] Mywebsites = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
		int randomIndexLanguage = rand.nextInt(Mywebsites.length);
		driver.get(Mywebsites[randomIndexLanguage]);

		
		if (driver.getCurrentUrl().equals("https://www.almosafer.com/ar")) {

			String Language = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "ar";
            
			assertEquals(Language, ExpectedLanguage);
			
		} else {

			String Language = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "en";
			assertEquals(Language, ExpectedLanguage);
			
			
		}

	}
}