import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;

public class UIAutomatorTest extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		//driver.findElementByAndroidUIAutomator("attribute("value")");
		// Java does not accepts double quote in double qoute so prove \ in it
		// AndroidUIAutomator does not exists in Selenium, it is only in Appium - Interview question
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		//Validate all clickable objects
		//driver.findElementByAndroidUIAutomator("new UISelector().property(value)");
		// Here we are getting multiple elements that why we are using findElements 
		driver.findElementsByAndroidUIAutomator("new UISelector().clickable(true)").size();
		//System.out.println(driver.findElementsByAndroidUIAutomator("new UISelector().clickable(true)").size(););		
	}

}
