package gluecode;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class StepDef1 
{
	public Shared sh;
	//Dependency injection via constructor
	public StepDef1(Shared sh)
	{
		this.sh=sh;
	}
	@Given("open a browser")
	public void open_a_browser()
	{
	    WebDriverManager.chromedriver().setup();
	    		sh.driver = new ChromeDriver();
	    sh.driver.manage().window().maximize();
	}

	@When("launch a site")
	public void launch_a_site() 
	{
	    sh.driver.get("https://www.amazon.in");
	}

	@Then("check home page display or not")
	public void check_home_page_display_or_not()
	{
	    sh.home = new HomePage(sh.driver);
	    sh.home.isHomePageDisplayed();
	}

	@When("Enter a valid product {string} in search box")
	public void enter_a_valid_product_in_search_box(String name)throws Exception
	{
	    sh.home.enterProductNameInSearchBox(name);
	    Thread.sleep(3000);
	}

	@Then("click on search button")
	public void click_on_search_button()throws Exception 
	{
	    sh.home.clickOnSearchButton();
	    Thread.sleep(2000);
	}

	@Then("check the displayed product {string} your search product same or not")
	public void check_the_displayed_product_your_search_product_same_or_not(String name)
	{
	   sh.home.checkDisplayResult(name);
	}

	
	
}
