package page.object;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='login']/button")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement flashMessage;

    public LoginPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage typeIntoUsernameField(String username){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public SecureArea clickLoginButton(){
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        return new SecureArea();
    }

    public String getFlashMessage(){
        return flashMessage.getText();
    }
}
