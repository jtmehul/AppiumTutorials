import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class DragAndDrop  extends Base{

	public static void main(String[] args) throws MalformedURLException  {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		//Long press on a dot to start drag, then drop over another dot.
		//The destination dot will append the drag's textual conversion to the EditText
		TouchAction ta = new TouchAction(driver);
		//long press / move to / release
		/// io.appium.android.apis:id/drag_dot_2
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
		
		ta.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		// Another way to write above code - drived from official website of appium
		// You can use below mentined steps if you dont have to use any additional steps such as withDuration methods
		//ta.longPress(element(source)).moveTo(element(destination)).release().perform();
	}

}
