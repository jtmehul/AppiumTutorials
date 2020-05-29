package eCommApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ECom_Test003 extends Base {
	
	public static void main(String[] args) throws MalformedURLException {
	AndroidDriver<AndroidElement> driver = Capabilities();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
	driver.hideKeyboard();
	driver.findElementByXPath("//*[@text='Female']").click();
	driver.findElementById("android:id/text1").click();
	//Here we are scrolling into the list to select desired value from the list
	driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
	driver.findElementByXPath("//*[@text='Argentina']").click();
	driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	
	driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	//driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));");

	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
			+ "resourceId(\"com.androidsample.generalstore:id/rvProductList\"))."
			+ "scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
	
	int count=  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	
    for(int i=0;i<count;i++)
    {
    String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

    		if(text.equalsIgnoreCase("Jordan 6 Rings"))
    			{
    				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
    				break;
    			}
    }
    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    String lastpageText= driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
    Assert.assertEquals("Jordan 6 Rings", lastpageText);
	}
}
