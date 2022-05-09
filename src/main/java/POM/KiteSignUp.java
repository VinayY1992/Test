package POM;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteSignUp {

	@FindBy(xpath="(//a[@target=\"_blank\"])[3]") private WebElement signupTab;
	@FindBy(xpath="//img[@class='logo-img']")private WebElement logo;
	@FindBy(xpath="//input[@id='user_mobile']")private WebElement MobileNum;
	@FindBy(xpath="//div[@id='menu_btn']")private WebElement menubar;
	@FindBy(xpath="(//a[@href='https://support.zerodha.com'])[1]")private WebElement support;
	@FindBy(xpath="(//a[@class='nav-links'])[1]")private WebElement pricing;
	@FindBy(xpath="(//a[@class='nav-links'])[2]")private WebElement about;
	@FindBy(xpath="//button[@type='submit']")private WebElement Submit;
	@FindBy(xpath="//a[text()='Want to open an NRI account?']")private WebElement OpenNriAccount;
	@FindBy(xpath="(//a[@class='text-center'])[1]")private WebElement Kite;
	public KiteSignUp(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void SwitchToSignUp(WebDriver driver)
	{
		String b = driver.getWindowHandle();
		driver.switchTo().window(b);
		Set<String> a = driver.getWindowHandles();
		ArrayList<String> i = new ArrayList(a);
		driver.switchTo().window(i.get(1));
	}
	public void SignupTab()
	{
		signupTab.click();
	}
	public void SupportTab()
	{
		support.click();
	}
	public void PricingTab()
	{
		pricing.click();
	}
	public void AboutZerodha()
	{
		about.click();
	}
	public void NriAccount()
	{
		OpenNriAccount.click();
	}
	public void Menubar()
	{
		menubar.click();
	}
	public void OpenKite()
	{
		Kite.click();
	}
	
	public String Pagetitle(WebDriver driver)
	{
		String ActualTitle= driver.getTitle();
		return ActualTitle;
	}
	public boolean ZerodhaLogo()
	{
		return logo.isDisplayed();
	}
	public void EnterMobNum(String user)
	{
		MobileNum.sendKeys(user);
	}
	public void SubmitMobNum()
	{
		Submit.click();
	}
	
}
