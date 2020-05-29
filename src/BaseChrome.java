
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseChrome {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;
		
		//This will help to have absolute path 
		//File fsrc = new File("src");
		//File fs = new File(fsrc,"ApiDemos-debug.apk");
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Wolverine");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		//cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		//System.out.println(fs.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		return driver;
	}

}
