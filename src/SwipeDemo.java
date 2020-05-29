import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;



public class SwipeDemo extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		//driver.findElementByAndroidUIAutomator("content-desc(\"9\")").click();
		//We can write xpath with @attribute='value' without worring about tagName
		driver.findElementByXPath("//*[@content-desc='9']").click();
		TouchAction ta = new TouchAction(driver);
	    WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
	    WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
	    //Long press for atleast for 1 second on element then swap to destination then release
		 ta.longPress(longPressOptions().withElement(element(first)).
				 withDuration(ofSeconds(2))).
				 moveTo(element(second)).release().perform();	
	}

}
