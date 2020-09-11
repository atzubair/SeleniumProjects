package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import PageObjects.HomePageObjects;
import PageObjects.LoginPageObject;
import Resources.Base;

@RunWith(Cucumber.class)
public class stepDefinition extends Base{

	@Given("^Initialize the browser with firefox$")
	public void initialize_the_browser_with_firefox() throws Throwable {
		driver =initializeDriver ();// we are initializing the driver from base file

	}

	@Given("^Navigate to \"([^\"]*)\" sito$")
	public void navigate_to_sito(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);//we don't need to use get.proprty like in page factory and get the url from property file
						 // now we have the site name written in ".feature" file 

	
	}

	@Given("^Click on the login link in homepage to land on secure sign in page$")
	public void click_on_the_login_link_in_homepage_to_land_on_secure_sign_in_page() throws Throwable {
		HomePageObjects hp = new HomePageObjects(driver);// we are closing the pop up window with the method(winclose) that we created in HomePag	eObject class 
		//hp.winClose().click();// we are closing the pop up window with the method that we created in HomePageObject class  
		
		// the following code can be used for closing the pop up window.
		if(hp.getPopUpSize()>0)
		{
			hp.getPopUp().click();
		}
		hp.getSignin().click();// then we are clicking on the signin link to go the login page
	
	}

		
	 @When("^User eneters (.+) and (.+) and logs in$")
	    public void user_eneters_and_and_logs_in(String username, String password) throws Throwable {
		// we are creating an object of LoginPageObject to avail it's methods
			LoginPageObject lp = new LoginPageObject(driver);
			lp.typeUsername().sendKeys(username);					
			lp.typePassword().sendKeys(password);
					
			lp.logIn().click();
			}

	@Then("^verify that the user successfully logged in$")
	public void verify_that_the_user_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("login successful");
		}
	
	 @Then("^close browser$")
	 public void close_browser() throws Throwable {
			driver.close();
	    }
	

}