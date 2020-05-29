import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class BrowseChrome extends BaseChrome{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get("https://facebook.com");
		driver.findElementByXPath("//input[@name='email']").sendKeys("abc@gmail.com");
		driver.findElementByXPath("//input[@name='pass']").sendKeys("Ac123");
		driver.findElementByXPath("//button[@name='login']").click();
	}

}
