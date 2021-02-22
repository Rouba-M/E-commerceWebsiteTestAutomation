import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTests {

    public WebDriver driver;


    @BeforeAll
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }



    @BeforeEach
    public void setUp() {
        driver=new ChromeDriver();

        //Run Chrome browser in headless mode
        //driver=new ChromeDriver(getChromeOptions());
    }


    @AfterEach
    public void tearDown() {
        if(driver!=null)
        {
            driver.quit();
        }

    }


    private ChromeOptions getChromeOptions(){
        return new ChromeOptions().setHeadless(true);
    }
}
