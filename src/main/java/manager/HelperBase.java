package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public interface HelperBase extends AppManager{


    default void click(By locator) {
        wd.findElement(locator).click();
    }

     default void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    default void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    default boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }
        default void clean () {
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.querySelector('#adplus-anchor').style.display ='none'");

        }
    default void cleanFooter () {
        JavascriptExecutor js = (JavascriptExecutor) wd;
         js.executeScript("document.querySelector('footer').style.display ='none'");

    }
    default void cleanDiv () {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#fixedban').style.zIndex=-1");

    }

    }

    //adplus-anchor
//document.querySelector('#google_center_div').style.display='none'
//#ad_unit
//document.querySelector('.OUTBRAIN').style.display='none'
//#google_ads_iframe_\/21849154601\,22343295815\/Ad\.Plus-728x90_0