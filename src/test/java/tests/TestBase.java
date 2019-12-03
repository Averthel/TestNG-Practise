package tests;

import driver.DriverManager;

import driver.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();

    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.disposeDriver();

    }
}
