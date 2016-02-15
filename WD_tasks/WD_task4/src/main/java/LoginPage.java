import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by whybe on 14.02.2016.
 */
public class LoginPage {
    private WebDriver driver;
    private By nameLocator = By.id("username");
    private By passLocator = By.id("password");
    private By buttonInLocator = By.cssSelector(".radius");
    private By buttonOutLocator = By.cssSelector(".button.secondary.radius");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage typeUsername(String username) {
        WebElement name  = driver.findElement(nameLocator);
        name.clear();
        name.sendKeys(username);
        return this;
    }
    public LoginPage typePassword(String password) {
        WebElement pass = driver.findElement(passLocator);
        pass.clear();
        pass.sendKeys(password);
        return this;
    }

    public LoginPage pressButtonOut() {
        driver.findElement(buttonOutLocator).click();
        return this;
    }

    public LoginPage pressButtonIn(){
        driver.findElement(buttonInLocator).click();
        return this;
    }

    public LoginPage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return pressButtonIn();
    }

}

