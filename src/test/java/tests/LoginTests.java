package tests;

import driver.DriverUtils;
import org.testng.annotations.Test;
import page.object.LoginPage;


import static navigation.ApplicationsURLs.APPLICATION_URL;
import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

    @Test
    public void loginUsingBadPassword(){
        DriverUtils.navigateToPage(APPLICATION_URL);
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField("tomsmith")
                .typeIntoPasswordField("inocorrctPassword")
                .clickLoginButton();

        String message = loginPage.getFlashMessage();

        assertTrue(message.contains("Your password is invalid!"));

    }
}
