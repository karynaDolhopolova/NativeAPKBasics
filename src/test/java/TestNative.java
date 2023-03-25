import activities.SettingsActivity;
import activities.SettingsFields;
import configurations.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNative extends BaseClass {

    static SettingsActivity settingsActivity;

    @BeforeClass
    public static void bTestNative() {
        settingsActivity = new SettingsActivity(driver);
        preSettings();
    }
    @Test
    public void test1() throws InterruptedException {
        for(int i=0;i<7;i++){
            Thread.sleep(1000);
            System.out.println(driver.currentActivity());
        }
    }
    private static void preSettings(){
        settingsActivity.print_name(SettingsFields.TEMPERATURE);
        settingsActivity.print_name(SettingsFields.WIND_SPEED);
        settingsActivity.selectTemp(true);
        settingsActivity.selectSpeed("km");
        settingsActivity.selectTime(true);
        settingsActivity.setNotification(true);
        settingsActivity.buttonDoneClick();
    }
}
