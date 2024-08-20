package magnetoWebsiteTesting;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Myfirsttest extends MyTesting {

	@BeforeTest
	public void mySetup() {
		Mysetupnew();
	}

	@Test(priority = 1)
	public void CreateAnAccount() {

		// xpath
//		WebElement createAccountPage = driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));

		// partialLinkText
//		WebElement createAccountPage = driver.findElement(By.partialLinkText("Account"));

		// linkText
//		WebElement createAccountPage = driver.findElement(By.linkText("Create an Account"));

		WebElement createAccountPage = driver
				.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
		createAccountPage.click();
		
		WebElement firstNameInput = driver.findElement(By.id("firstname"));
		WebElement lastNameInput = driver.findElement(By.id("lastname"));
		WebElement emailAddressInput = driver.findElement(By.id("email_address"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement createAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		
		firstNameInput.sendKeys(firstname);
		lastNameInput.sendKeys(lastname);
		emailAddressInput.sendKeys(firstname + lastname + randomnumber + domainName);
		passwordInput.sendKeys(password);
		confirmPassword.sendKeys(password);
		createAccountButton.click();

		WebElement messagealert = driver.findElement(By.className("messages"));

		String ActualMessage = messagealert.getText();
		Assert.assertEquals(ActualMessage, ExpectedMessage);

		emailAddressToLogin = firstname + lastname + randomnumber + domainName;

	}

	@Test(priority = 2)
	public void logOut() {
		driver.get(logoutPage);

		WebElement Messagelogout = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));

		String ActaulMessage = Messagelogout.getText();
		Assert.assertEquals(ActaulMessage, ExpectedMessage1);

	}

	@Test(priority = 3)
	public void loginTest() {
		WebElement LoginPage = driver.findElement(By.linkText("Sign In"));
		LoginPage.click();

		WebElement EmailLoginInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement LoginButton = driver.findElement(By.cssSelector(".action.login.primary"));

		EmailLoginInput.sendKeys(emailAddressToLogin);
		passwordInput.sendKeys(password);
		LoginButton.click();

		String Messagelogin = driver.findElement(By.className("logged-in")).getTagName();

		boolean ActualMessage = Messagelogin.contains("Welcome");
		Assert.assertEquals(ActualMessage, ExpectedMessage2);

	}

	@Test(priority = 4)

	public void addMenItem() throws InterruptedException {
		WebElement MenSection = driver.findElement(By.cssSelector("#ui-id-5"));
		MenSection.click();

		WebElement OlItemsContainer = driver.findElement(By.className("product-items"));
		List<WebElement> Items = OlItemsContainer.findElements(By.tagName("li"));

		int randomIndex = rand.nextInt(Items.size());
		Items.get(randomIndex).click();

		WebElement SizesContainer = driver
				.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
		List<WebElement> allSizes = SizesContainer.findElements(By.tagName("div"));
		
		int RandomSize = rand.nextInt(allSizes.size());
		allSizes.get(RandomSize).click();

		WebElement colorsContainer = driver
				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));

		List<WebElement> allColors = colorsContainer.findElements(By.tagName("div"));
		int RandomColor = rand.nextInt(allColors.size());

		allColors.get(RandomColor).click();

		WebElement addtocartbutton = driver.findElement(By.id("product-addtocart-button"));
		addtocartbutton.click();

		WebElement messegeAdded = driver.findElement(By.className("message-success"));
		assertEquals(messegeAdded.getText().contains("You added"), true);

	}

	@Test(priority = 5)
	public void addWomenItem() throws InterruptedException {
		WebElement WomenSection = driver.findElement(By.id("ui-id-4"));

		WomenSection.click();

		WebElement productITemsContainer = driver.findElement(By.className("product-items"));

		List<WebElement> AllItems = productITemsContainer.findElements(By.tagName("li"));

		int totalNumberOfItems = AllItems.size();
		int randomItem = rand.nextInt(totalNumberOfItems);

		AllItems.get(randomItem).click();

		WebElement theContainerOfSizes = driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));

		List<WebElement> ListOfSizes = theContainerOfSizes.findElements(By.className("swatch-option"));
		
		int numberofSizes = ListOfSizes.size();
		int randomSize = rand.nextInt(numberofSizes);
		ListOfSizes.get(randomSize).click();
		
		WebElement ColorsContainer = driver
				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> ListOfClors = ColorsContainer.findElements(By.tagName("div"));
		int numberOfColors = ListOfClors.size();

		int randomColor = rand.nextInt(numberOfColors);
		ListOfClors.get(randomColor).click();

		WebElement AddToCartButton = driver.findElement(By.id("product-addtocart-button"));

		AddToCartButton.click();

		Thread.sleep(5000);

		WebElement MessageAdded = driver.findElement(By.cssSelector(".message-success.success.message"));

		Assert.assertEquals(MessageAdded.getText().contains("You added"), true);

// review section 

		driver.navigate().refresh();

		WebElement ReviewSEction = driver.findElement(By.id("tab-label-reviews-title"));

		ReviewSEction.click();
		
		js.executeScript("window.scrollTo(0,1200)");

		Thread.sleep(2000);

		WebElement RatingStars = driver.findElement(By.cssSelector(".control.review-control-vote"));


		Thread.sleep(2000);

		String[] ids = { "Rating_1", "Rating_2", "Rating_3", "Rating_4", "Rating_5" };
		int randomIndex = rand.nextInt(ids.length);
		WebElement element = driver.findElement(By.id(ids[randomIndex]));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement nickname = driver.findElement(By.id("nickname_field"));
		nickname.sendKeys("Diaa");

		WebElement summary = driver.findElement(By.id("summary_field"));

		summary.sendKeys("test test test");

		WebElement review = driver.findElement(By.id("review_field"));

		review.sendKeys("hello this is a test");
		;

		WebElement submitReviewButton = driver.findElement(By.cssSelector(".action.submit.primary"));

		submitReviewButton.click();

		String actualTextforReview = driver.findElement(By.cssSelector(".message-success.success.message")).getText();
		Assert.assertEquals(actualTextforReview, expectedTextforReview);

	}


}
