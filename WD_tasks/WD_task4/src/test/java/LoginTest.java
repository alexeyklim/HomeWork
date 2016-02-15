import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by whybe on 14.02.2016.
 */
public class LoginTest {
    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage = new LoginPage(driver);

    @BeforeTest
    public void GetReady() {
       // driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement toLoginPage = driver.findElement(By.cssSelector("a[href=\"/login\"]"));
        toLoginPage.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    @DataProvider
    public Object[][] LoginData() {
        return new Object[][]{
                new Object[]{"", ""},
                new Object[]{"wrong name", "wrong pass"},
                new Object[]{"wrong name", "SuperSecretPassword!"},
                new Object[]{"tomsmitn", "wrong pass"},
                new Object[]{"tomsmith", "SuperSecretPassword!"},
        };
    }


    @Test(dataProvider = "LoginData")
    public void loginTest(String username, String password) {
    loginPage.loginAs(username, password);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flash")));
        if (driver.getPageSource().contains("Secure Area")) {
            loginPage.pressButtonOut();

        }
    }


    @AfterTest
    public void teardown() {
        driver.quit();

    }
}
