package eCommApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.function.DoubleUnaryOperator;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ECom_Test004 extends Base {
	
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
