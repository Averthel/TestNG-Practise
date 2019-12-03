package tests;

import driver.DriverUtils;
import org.testng.annotations.Test;
import page.object.LoginPage;
import utils.ClassDataProvider;

import static navigation.ApplicationsURLs.APPLICATION_URL;
import static org.testng.Assert.assertTrue;

public class LoginTestsDA {

    @Test(dataProviderClass = ClassDataProvider.class, dataProvider = "incorrectLoginData")
    public void asUserLoginUsingIncorrectCredentialsDataProviderVariant(String username, String password, String expectedWarning){
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
