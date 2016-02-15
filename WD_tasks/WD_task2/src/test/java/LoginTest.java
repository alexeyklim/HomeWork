import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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


    @Test
    public void TestTrueLoginData() {

        WebElement username = driver.findElement(By.id(usernameID));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id(passwordID));
        password.sendKeys("SuperSecretPassword!");
        WebElement button = driver.findElement(By.cssSelector(".radius"));
        button.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='flash success']")));
        WebElement buttonLogOut = driver.findElement(By.cssSelector(".button.secondary.radius"));
        buttonLogOut.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='flash success']")));

    }

    @Test
    public void TestFakeLoginData() {

        WebElement username = driver.findElement(By.id(usernameID));
        username.sendKeys("blablabla");
        WebElement password = driver.findElement(By.id(passwordID));
        password.sendKeys("123123");
        WebElement button = driver.findElement(By.cssSelector(buttonInID));
        button.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='flash error']")));


    }



    @AfterTest
    public void teardown() {
        driver.quit();

    }

}
