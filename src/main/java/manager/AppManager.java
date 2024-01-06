package manager;

import models.StudentDTO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

public interface AppManager {
 WebDriver wd = new ChromeDriver();


default void init(){

    wd.navigate().to("https://demoqa.com/");
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.manage().window().maximize();
}


    default void tearDown() {
        wd.quit();

    }


}
//document.querySelector('#adplus-anchor').style.display ='none'

//document.querySelector('#ad_unit').style.display='none'