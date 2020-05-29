package eCommApp;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.DoubleUnaryOperator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ECom_Test006 extends Base {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	AndroidDriver<AndroidElement> driver = Capabilities();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
	driver.hideKeyboard();
	driver.findElementByXPath("//*[@text='Female']").click();
	driver.findElementById("android:id/text1").click();
	//Here we are scrolling into the list to select desired value from the list
	driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
	driver.findElementByXPath("//*[@text='Argentina']").click();
	driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(4000);
	//Mobile Gestures
	WebElement chk = driver.findElement(By.className("android.widget.CheckBox"));
	TouchAction t = new TouchAction(driver);
	t.tap(tapOptions().withElement(element(chk))).perform();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	Thread.sleep(7000);
	Set<String> cont = 	driver.getContextHandles();
	for(String contextName : cont){
		System.out.println(contextName);
	}
	//Switching to context ie. to the web view
	driver.context("WEBVIEW_com.androidsample.generalstore");
	WebElement ele = driver.findElement(By.xpath("//input[@name='q']"));
	ele.sendKeys("Hello");
	ele.sendKeys(Keys.ENTER);
	// Create class KeyEvent to press android back button
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	// Switching back to Native app mode
	//driver.context("NATIVE_APP");
	//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
	
	}	
}
