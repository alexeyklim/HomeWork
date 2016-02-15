import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by whybe on 15.02.2016.
 */
public class TestPage {
    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void setup() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
    }



    @Test
    public void Test() {
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        WebElement textField = driver.findElement(By.id("tinymce"));
        textField.clear();
        textField.click();
        textField.sendKeys("Привет, ");

        driver.switchTo().defaultContent().findElement(By.id("mceu_3")).click();

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        textField.click();
        textField.sendKeys("МИР! ");

        driver.switchTo().defaultContent().findElement(By.id("mceu_3")).click();

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        textField.click();
        textField.sendKeys("Я умею работать с фреймами.");

        String a = textField.getText();
        Assert.assertTrue((a.contains("Привет, ")&&a.contains("МИР! ")
                &&a.contains("Я умею работать с фреймами.")), "Строка \""+a+"\" не соответствует условию.");

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
