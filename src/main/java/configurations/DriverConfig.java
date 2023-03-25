package configurations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverConfig {
    private static AndroidDriver driver;
    public static AndroidDriver create(EMULATORS emulators){
        switch (emulators){
            case PIXELBASICS:createPixelBasics();
        }
        return driver;
    }

    private static void createPixelBasics() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");//указываем версию Android
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Имя OS
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");//Сообщаем, что будет использоваться эмулятор
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1800);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.weather.forecast.weatherchannel");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.weather.forecast.weatherchannel.activities.SettingActivity");
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
