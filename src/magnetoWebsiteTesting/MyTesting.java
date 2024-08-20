package magnetoWebsiteTesting;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTesting {
	
	WebDriver driver = new ChromeDriver();

	String myWebsite = "https://magento.softwaretestingboard.com/";
	String logoutPage = "https://magento.softwaretestingboard.com/customer/account/logout/";
	Random rand = new Random();
	String checkout = "https://magento.softwaretestingboard.com/checkout/cart/";

	String password = "iLoveMyMom!234k";

	String emailAddressToLogin = "";
	
	// first names
			String[] first_Names = { "Alice", "Bob", "Charlie", "David", "Eve", "Fay", "Grace" };
			// last names
			String[] Last_Names = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia" };

			int randomIndexForTheFirstName = rand.nextInt(first_Names.length);
			int randomIndexForTheLastName = rand.nextInt(Last_Names.length);
			String firstname = first_Names[randomIndexForTheFirstName];
			String lastname = Last_Names[randomIndexForTheLastName];
				int randomnumber = rand.nextInt(9876);

			String domainName = "@gmail.com";
			String ExpectedMessage = "Thank you for registering with Main Website Store.";
			String ExpectedMessage1 = "You are signed out";
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			String expectedTextforReview = "You submitted your review for moderation.";
			boolean ExpectedMessage2 = true;
		
	public void Mysetupnew() {
		driver.manage().window().maximize();
		driver.get(myWebsite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		
	}


}
