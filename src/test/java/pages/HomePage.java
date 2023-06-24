package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath="//a[@aria-label='Amazon.in']")private WebElement home;
	@FindBy(id="twotabsearchtextbox")private WebElement search;
	@FindBy(xpath="//input[@type='submit']") private WebElement button;
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")private WebElement checkElement;
	
	public HomePage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void isHomePageDisplayed()
	{
		String name = home.getAttribute("aria-label");
		if(name.contains("Amazon.in"))
		{
			System.out.println("Test passed home page is displayed");
		}
		else
		{
			System.out.println("Test failed home page is not displayed");
		}
			
	}
	public void enterProductNameInSearchBox(String name)
	{
		search.sendKeys(name);
	}
	public void clickOnSearchButton()
	{
		button.click();
	}
	public void checkDisplayResult(String productname)
	{
		String element =checkElement.getText();
		if(productname.equals(element))
		{
			System.out.println("Test passed given product name matched");
		}
		else
		{
			System.out.println("Test failed given product name not matched");
		}
	}
}
