package tests;

import driver.DriverUtils;
import model.IncorrectLoginTestData;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import page.object.LoginPage;

import static navigation.ApplicationsURLs.APPLICATION_URL;
import static org.testng.Assert.assertTrue;

public class LoginTestsFA extends TestBase {


    private IncorrectLoginTestData incorrectLoginTestData;

    public LoginTestsFA(IncorrectLoginTestData incorrectLoginTestData){
        this.incorrectLoginTestData = incorrectLoginTestData;
    }

    @Test
    public void asUserLoginUsingIncorrectCredentials() {
        DriverUtils.navigateToPage(APPLICATION_URL);
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField(incorrectLoginTestData.getUsername())
                .typeIntoPasswordField(incorrectLoginTestData.getPassword())
                .clickLoginButton();

        String message = loginPage.getFlashMessage();

        assertTrue(message.contains(incorrectLoginTestData.getExpectedWarning()));

    }
    @Factory
    public static Object[] factoryMethod() {
        LoginTestsFA firstTestToExecute = new LoginTestsFA(new IncorrectLoginTestData("", "", "Your username is invalid!"));
        LoginTestsFA secondTestToExecute = new LoginTestsFA(new IncorrectLoginTestData("tomsmith", "", "Your password is invalid!"));
        LoginTestsFA thirdTestToExecute = new LoginTestsFA(new IncorrectLoginTestData("", "SuperSecretPassword! ", "Your username is invalid!"));
        return new Object[]{
                firstTestToExecute,
                secondTestToExecute,
                thirdTestToExecute
        };
    }



}
