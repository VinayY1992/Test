package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.KiteLogin;
import Pojo.Browser;
import Utility.Excel;
import Utility.Screenshot;

public class LoginTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser()
	{
		driver = Browser.browser("https://kite.zerodha.com");
	}
	@Test(priority=0)
	public void LoginWithValidCredentials() throws EncryptedDocumentException, IOException, InterruptedException
	{
		KiteLogin kitelogin = new KiteLogin(driver);
		kitelogin.UserId(Excel.getdata("Sheet1", 0, 1));
		kitelogin.password(Excel.getdata("Sheet1", 1, 1));
		kitelogin.submitbutton();
		Thread.sleep(2000);
		kitelogin.Enterpin(Excel.getdata("Sheet1", 2, 1));
		kitelogin.ContinueButton();
	}
	@Test(priority=1)
	public void ClickOnSubmitButtonOnly()
	{
		KiteLogin kitelogin = new KiteLogin(driver);
		kitelogin.submitbutton();
	}
	@Test(priority=2)
	public void SignUpTab()
	{
		KiteLogin kitelogin = new KiteLogin(driver);
		kitelogin.Signup();
		Set<String> a = driver.getWindowHandles();
		ArrayList<String> i=new ArrayList(a);
		driver.switchTo().window(i.get(1));
	}
	@Test(priority=3)
	public void ForgotPassClick()
	{
		KiteLogin kitelogin = new KiteLogin(driver);
		kitelogin.ForgotPass();
		kitelogin.ForgotID();
	}
	
	@AfterMethod
	public void screenshots() throws IOException
	{
		Screenshot.screenshot(driver,"zerodha");
	}

}
