import manager.AppManager;
import manager.HelperBase;

import manager.HelperStudent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase implements AppManager, HelperStudent,HelperBase {


    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        init();
    }



    @AfterSuite(alwaysRun = true)
    public void stop() {
       // tearDown();

    }
}
