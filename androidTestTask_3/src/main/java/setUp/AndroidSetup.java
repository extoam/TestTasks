package setUp;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {
	
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.0.2-beta.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.0");
        capabilities.setCapability("deviceName", "Nexus 6");
        capabilities.setCapability("app", "/Users/antanina/Downloads/komoot.apk");
        capabilities.setCapability("appPackage", "com.komoot.android");
        capabilities.setCapability("appActivity", "com.komoot.android.SplashActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }
}