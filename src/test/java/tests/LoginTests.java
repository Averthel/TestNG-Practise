package tests;

import driver.DriverUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.object.LoginPage;


import static navigation.ApplicationsURLs.APPLICATION_URL;
import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

    @Parameters({"username", "password", "expectedWarning"})
    @Test
    public void asUserLoginUsingIncorrectCredentials(String username, String password, String expectedWarning){
        DriverUtils.navigateToPage(APPLICATION_URL);
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField(username)
                .typeIntoPasswordField(password)
                .clickLoginButton();

        String message = loginPage.getFlashMessage();

        assertTrue(message.contains(expectedWarning));

    }
}
