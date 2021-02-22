package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {

    public WebDriver driver;
    protected WebDriverWait wait;
    private WebDriver.Navigation navigate;

    public BasePage(WebDriver driver) {
        this.driver=driver;
        wait=new WebDriverWait(driver,10);
        navigate=driver.navigate();
    }

    public void open(String partialUrl){
        driver.get("http://automationpractice.com/index.php"+partialUrl);
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void goTo(String url)
    {navigate.to(url);}

    public void refreshPage(){
        navigate.refresh();
    }

    public void openLinkInNewTab(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.sendKeys(Keys.chord(Keys.COMMAND,Keys.ENTER));

    }

    public void switchToTab(String tabTitle){
        Set<String> tabsHandles = driver.getWindowHandles();

        for(String tabHandle:tabsHandles)
        {
            driver.switchTo().window(tabHandle);
            if(driver.getTitle().equalsIgnoreCase(tabTitle))
                break;
        }
    }

    public void fillField(By locator, String input){
        driver.findElement(locator).sendKeys(input);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
}
