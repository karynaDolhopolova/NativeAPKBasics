package configurations;

import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseClass {
    public static AndroidDriver driver;

    @BeforeClass
    public static void b() {
        driver = DriverConfig.create(EMULATORS.PIXELBASICS);
    }

    @AfterClass
    public static void a() throws InterruptedException {
        Thread.sleep(20000);
        driver.quit();
    }
}
