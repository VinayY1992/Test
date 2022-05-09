package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.KiteSignUp;
import Pojo.Browser;
import Utility.Screenshot;

public class SignUpTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser()
	{
		driver=Browser.browser("https://kite.zerodha.com");
	}
	@Test
	public void ClickOnSignUp() throws InterruptedException
	{
		KiteSignUp signup = new KiteSignUp(driver);
		signup.SignupTab();
		signup.SwitchToSignUp(driver);
	}
	@Test(priority = 1)
	public void zerodhaSignUp() throws InterruptedException
	{
		KiteSignUp signup = new KiteSignUp(driver);
		signup.SignupTab();
		signup.SwitchToSignUp(driver);
		String ActualTitle = signup.Pagetitle(driver);
		System.out.println(ActualTitle);
		String ExpectedTitle = "Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualTitle, ExpectedTitle);
		softAssert.assertTrue(signup.ZerodhaLogo());
		signup.EnterMobNum("8149443735");
		signup.SubmitMobNum();
		softAssert.assertAll();		
	}
	@Test
	public void OpenNriAccount()
	{
		KiteSignUp signup = new KiteSignUp(driver);
		signup.SignupTab();
		signup.SwitchToSignUp(driver);
		signup.NriAccount();
	}
	@Test(priority = 2)
	public void MenuBar()
	{
		KiteSignUp signup = new KiteSignUp(driver);
		signup.SignupTab();
		signup.SwitchToSignUp(driver);
		signup.Menubar();
	}
	@Test(dependsOnMethods  = {"MenuBar"})
	public void KiteZerodha()
	{
		KiteSignUp signup = new KiteSignUp(driver);
		signup.SignupTab();
		signup.SwitchToSignUp(driver);
		signup.Menubar();
		signup.OpenKite();
	}
	
	@AfterMethod
	public void screenshots() throws IOException
	{
		Screenshot.screenshot(driver,"zerodha");
	}

}
