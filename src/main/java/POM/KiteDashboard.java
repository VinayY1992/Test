package POM;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class KiteDashboard {
	@FindBy(xpath="//li[@data-balloon='7']")private WebElement MarketWatchlist;
	@FindBy(xpath="//input[@icon='search']")private WebElement ClickOnSearch;
	//@FindBy(xpath="(//span[@class='symbol'])[1]")private WebElement add;
	@FindBy(xpath="(//button[@type='button'])[5]")private WebElement AddShare;
	@FindBy(xpath="//span[@class='nice-name']")private List<WebElement> MoveOnShare;
	@FindBy(xpath="//button[@class='button-blue buy']")private WebElement BuyShare;
	@FindBy(xpath="//label[@class='su-switch-control']")private WebElement SwitchToSell;
	@FindBy(xpath="(//input[@type='number'])[1]")private WebElement AddQty;
	//@FindBy(xpath="//input[@label='Market']")private WebElement RadioMarket;
public KiteDashboard(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void MW(WebDriver driver)
{
	@SuppressWarnings("deprecation")
	WebDriverWait wait=new WebDriverWait(driver,5000);
	wait.until(ExpectedConditions.visibilityOf(MarketWatchlist));
	MarketWatchlist.click();	
}
public void SearchBox(String share)
{
	ClickOnSearch.sendKeys(share);
	
}
public void ClickAdd(WebDriver driver)
{
	WebDriverWait wait=new WebDriverWait(driver,2000);
	wait.until(ExpectedConditions.visibilityOf(AddShare));
	Actions buy = new Actions(driver);
	buy.moveToElement(AddShare);
	buy.perform();
}
public void moveonshare(WebDriver driver,int i)
{
	
	WebDriverWait wait=new WebDriverWait(driver,2000);
	wait.until(ExpectedConditions.visibilityOf(MoveOnShare.get(i)));
	System.out.println(MoveOnShare.size());
 Actions buy = new Actions(driver);
 buy.moveToElement(MoveOnShare.get(i));
 buy.perform();
}
public void ClickOnBuy(WebDriver driver)
{
	BuyShare.click();
}
public void switchToSell(WebDriver driver)
{
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 5000);
	wait.until(ExpectedConditions.visibilityOf(SwitchToSell));
	SwitchToSell.click();
}
public void AddQauantity(String user)
{
	AddQty.sendKeys(user);
}
/*public void Radiobutton(WebDriver driver)
{
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 5000);
	wait.until(ExpectedConditions.visibilityOf(RadioMarket));
	RadioMarket.click();
}*/


}