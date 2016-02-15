import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.naming.TimeLimitExceededException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by whybe on 14.02.2016.
 */
public class TestPage {
    @Test
    public void Test() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
        List<WebElement> Element = driver.findElements(By.className("figure>img"));
        Actions action = new Actions(driver);
        for (int i = 0; i < Element.size(); i++) {
            action.moveToElement(Element.get(i));
            action.perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*=\"/users/" + (i+1) + "\"]")));
        }
    }
}