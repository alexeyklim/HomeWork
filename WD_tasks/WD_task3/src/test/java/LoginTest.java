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

import java.util.concurrent.TimeUnit;

/**
 * Created by whybe on 12.02.2016.
 */
public class LoginTest {

    protected WebDriver driver;
    protected String usernameID = "username";
    protected String passwordID = "password";
    protected String buttonInID =".radius";
    protected String buttonOutID =".button.secondary.radius";
    private StringBuffer verificationErrors = new StringBuffer();

    @DataProvider
    public Object [][] LoginData() {
        return new Object[][] {
                new Object[] {"",""},
                new Object[] {"wrong name","wrong pass"},
                new Object[] {"wrong name", "SuperSecretPassword!"},
                new Object[] {"tomsmitn","wrong pass"},
                new Object[] {"tomsmith","SuperSecretPassword!"},
        };

    }



    @BeforeTest
    public void GetReady() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement toLoginPage = driver.findElement(By.cssSelector("a[href=\"/login\"]"));
        toLoginPage.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test(dataProvider = "LoginData")
    public void TestTrueLoginData(String name, String pass) {
        try {
            WebElement username = driver.findElement(By.id(usernameID));
            username.clear();
            username.sendKeys(name);

            WebElement password = driver.findElement(By.id(passwordID));
            password.clear();
            password.sendKeys(pass);

            WebElement button = driver.findElement(By.cssSelector(buttonInID));
            button.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if (driver.getPageSource().contains("Secure Area")) {
                new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flash")));
                WebElement buttonLogOut = driver.findElement(By.cssSelector(buttonOutID));
                buttonLogOut.click();
                new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flash")));
            }
        }catch (Error e) {
            verificationErrors.append(e.toString());

        }
    }

    @AfterTest
    public void teardown() {
        driver.quit();

    }

}
