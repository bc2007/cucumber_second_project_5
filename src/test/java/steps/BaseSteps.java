package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class BaseSteps {

    WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.getDriver();
    }

    @Given("user is on {string}")
    public void user_is_on(String url) {
        driver.get(url);
        Assert.assertEquals(url, driver.getCurrentUrl());
    }


}