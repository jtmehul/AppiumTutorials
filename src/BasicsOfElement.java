import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;


public class BasicsOfElement extends Base {

	public static void main (String args[]) throws MalformedURLException, InterruptedException{
		AndroidDriver<AndroidElement> driver = Capabilities();
		// xpath id className, androidUIautomator //xpath synta //tagName[@attribute='value']			
		driver.findElementByXPath(("//android.widget.TextView[@text='Preference']")).click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click(); //using id
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click(); // xpath with index
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello Automation"); //classname
		//android.widget.Button 
		// here we are using bring all elements and then picking second element
		driver.findElementsByClassName("android.widget.Button").get(1).click();	
	}
}
