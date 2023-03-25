package activities;

import configurations.BaseClass;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import java.util.List;

public class SettingsActivity {
    String temperatureButton = "com.weather.forecast.weatherchannel:id/tgTemperature_setting";
    String speedOmetr = "com.weather.forecast.weatherchannel:id/tv_wind_speed_format";
    String speedDistance="com.weather.forecast.weatherchannel:id/iv_arrow_distance";
    String timeFormat="com.weather.forecast.weatherchannel:id/tg_format_time_setting";
    String notificationActivate="com.weather.forecast.weatherchannel:id/tgNotifi_settings";
    private static MobileDriver driver;
    public SettingsActivity (MobileDriver Driver) {
        driver = Driver;
    }

    public void print_name(String field) {
        MobileElement temp = (MobileElement) driver.findElementByXPath(field.toString());
        System.out.println(temp.findElementByClassName("android.widget.TextView").getText());
    }

    public void selectTemp(boolean b) {
        MobileElement mobileElement = (MobileElement) driver.findElementByXPath(SettingsFields.TEMPERATURE).findElement(By.id(temperatureButton));
        System.out.println(mobileElement.getAttribute("checked"));
        if (!String.valueOf(b).equals(mobileElement.getAttribute("checked"))) {
            mobileElement.click();
        }
    }
    public void selectTime (boolean b){
        MobileElement mobileElement = (MobileElement) driver.findElementByXPath(SettingsFields.TIME).findElement(By.id(timeFormat));
        System.out.println(mobileElement.getAttribute("checked"));
        if (!String.valueOf(b).equals(mobileElement.getAttribute("checked"))) {
            mobileElement.click();
        }
    }
    public void setNotification (boolean b){
        MobileElement mobileElement = (MobileElement) driver.findElementByXPath(SettingsFields.NOTIFICATION).findElement(By.id(notificationActivate));
        System.out.println(mobileElement.getAttribute("checked"));
        if (!String.valueOf(b).equals(mobileElement.getAttribute("checked"))) {
            mobileElement.click();
        }
    }
        public void selectSpeed(String str) {
            MobileElement mobileElement = (MobileElement) driver.findElementByXPath(SettingsFields.WIND_SPEED);
            if (!str.contains(mobileElement.findElementById(speedOmetr).getText())) {
                switch (str) {
                    case "km":
                        selectspeed(str);
                        break;
                    case "m":
                        selectspeed(str);
                        break;
                    default:
                        try {
                            throw new Exception("parametr of speed does not exist");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                }
            }

        }

        private void selectspeed(String speed) {
            driver.findElementById(speedDistance).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            MobileElement element= (MobileElement) driver.findElementById("com.weather.forecast.weatherchannel:id/md_contentRecyclerView");
            List<MobileElement> elementList=element.findElements(By.className("android.widget.LinearLayout"));
            System.out.println("LinearLayout kol= "+ elementList.size());
            for(MobileElement l:elementList){
                if(l.findElement(By.className("android.widget.TextView")).getText().contains(speed)){
                    l.click();
                    break;
                }
            }
        }
        public void buttonDoneClick(){
            driver.findElementById("com.weather.forecast.weatherchannel:id/tvDone").click();
        }
    }
