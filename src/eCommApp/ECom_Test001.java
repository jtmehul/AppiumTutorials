package eCommApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ECom_Test001 extends Base {
	
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
	//capturing toast message name attribute will give value of toast message 
	//String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
	//System.out.println(toastMessage);
	
	
	
	
	}

}
