package utils;

import org.testng.annotations.DataProvider;

public class ClassDataProvider {

    @DataProvider
    public Object[][] incorrectLoginData(){
        Object[][] testDataArray = {
                {"tomsmith", "", "Your password is invalid!"},
                {"", "", "Your username is invalid!"},
                {"Andy", "SuperSecretPassword!", "Your username is invalid!"}
        };
        return testDataArray;
    }
}
