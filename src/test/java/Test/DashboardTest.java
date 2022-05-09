package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.KiteDashboard;
import POM.KiteLogin;
import Pojo.Browser;
import Utility.Excel;

public class DashboardTest {
	WebDriver driver;
	@BeforeMethod
	public void LaunchBrowser()
	{
		driver = Browser.browser("https://kite.zerodha.com");
	}
	@Test(priority=-1)
	public void EnterToDashboard() throws EncryptedDocumentException, IOException, InterruptedException
	{
		KiteLogin kitelogin = new KiteLogin(driver);
		KiteDashboard kitedashboard = new KiteDashboard(driver); 
		kitelogin.UserId(Excel.getdata("Sheet1", 0, 1));
		kitelogin.password(Excel.getdata("Sheet1", 1, 1));
		kitelogin.submitbutton();
		Thread.sleep(2000);
		kitelogin.Enterpin(Excel.getdata("Sheet1", 2, 1));
		kitelogin.ContinueButton();
		kitedashboard.MW(driver);	
		kitedashboard.SearchBox("tatamotors");
		kitedashboard.moveonshare(driver,1);
		kitedashboard.ClickAdd(driver);
		
		
		kitedashboard.ClickOnBuy(driver);
		Thread.sleep(5000);
		kitedashboard.switchToSell(driver);
		
		kitedashboard.AddQauantity("20");
		//kitedashboard.Radiobutton(driver);
	}
}
