package eCommApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.function.DoubleUnaryOperator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ECom_Test005 extends Base {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	Thread.sleep(4000);
	int countS = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
	double sum=0;
	for(int i=0;i<countS;i++){
		String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
		double amount = getAmount(amount1);
		sum=sum+amount;	
						}
		System.out.println("Sum of :- " + sum);
		String totalValue = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double totalFinal = getTotalAmount(totalValue);
		Assert.assertEquals(totalFinal, sum);
		
		//Mobile Gestures
		WebElement chk = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(chk))).perform();
		WebElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	}
	
	public static double getAmount(String value){
		value = value.substring(1);
		double amount= Double.parseDouble(value);
		return amount;
	}
	public static double getTotalAmount(String totValue){
		totValue = totValue.substring(1);
		double totalV = Double.parseDouble(totValue);
		return totalV;
	}
}
