package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin {
	@FindBy(xpath="//input[@id='userid']") private WebElement userid;
	@FindBy(xpath="//input[@id='password']") private WebElement pass;
	@FindBy(xpath="//button[@type='submit']") private WebElement sub;
	@FindBy(xpath="//input[@id='pin']") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement Continue;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy(xpath="(//a[@target=\"_blank\"])[3]") private WebElement signup;
	@FindBy(xpath="//img[@alt='Kite']") private WebElement kitelogo;
	@FindBy(xpath="//label[@for='radio-31']")private WebElement forgotID;
	
	public KiteLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void UserId(String id)
	{
		userid.sendKeys(id);
	}
	public void password(String Pass)
	{
		pass.sendKeys(Pass);
	}
	public void submitbutton()
	{
		sub.click();
	}
	public void Enterpin(String Pinid)
	{
		pin.sendKeys(Pinid);
	}
	public void ContinueButton()
	{
		Continue.click();
	}
	public void ForgotPass()
	{
		forgot.click();
	}
	public void Signup()
	{
		signup.click();
	}
	public void Logo()
	{
		kitelogo.click();
	}
	public void ForgotID()
	{
		forgotID.click();
	}

}
