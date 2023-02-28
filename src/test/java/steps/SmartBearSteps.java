package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SmartBearLoginPage;
import pages.WebOrdersPage;
import utils.Driver;
import utils.Waiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SmartBearSteps {


    WebDriver driver;
    SmartBearLoginPage smartBearLoginPage;
    WebOrdersPage webOrdersPage;


    @Before
    public void setup(){
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        webOrdersPage = new WebOrdersPage();
    }


    @When("user enters username as {string}")
    public void user_enters_username_as(String username) {
        smartBearLoginPage.usernameInputBox.sendKeys(username);
    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
        smartBearLoginPage.passwordInputBox.sendKeys(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_Login_button() {
        smartBearLoginPage.loginButton.click();
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String message) {
        Assert.assertEquals(message, smartBearLoginPage.errorMessage.getText());
    }


    @Then("user should be routed to {string}")
    public void user_should_be_routed_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }


    @Then("validate below menu items are displayed")
    public void validate_below_menu_items_are_displayed(DataTable dataTable) {
        List<String> expectedText = dataTable.asList();
        for (int i = 0; i < webOrdersPage.menuItems.size(); i++) {
            Assert.assertEquals(expectedText.get(i), webOrdersPage.menuItems.get(i).getText());
        }
    }


    @When("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        switch (button){
            case "Check All":
                webOrdersPage.checkAllButton.click();
                break;
            case "Uncheck All":
                webOrdersPage.uncheckAllButton.click();
                break;
            case "Process":
                webOrdersPage.processButton.click();
                break;
            case "Delete Selected":
                webOrdersPage.deleteButton.click();
                break;
            default:
                throw new RuntimeException("Button Not Found");
        }
    }


    @Then("all rows should be checked")
    public void all_rows_should_be_checked() {
        for (WebElement row : webOrdersPage.rowsCheckers) {
            Assert.assertTrue(row.isSelected());
        }
    }


    @Then("all rows should be unchecked")
    public void all_rows_should_be_unchecked() {
        for (WebElement row : webOrdersPage.rowsCheckers) {
            Assert.assertFalse(row.isSelected());
        }
    }


    @When("user clicks on {string} menu item")
    public void user_clicks_on_menu_item(String item) {
        switch(item) {
            case "Order":
                webOrdersPage.menuItems.get(2).click();
                break;
            case "View all orders":
                webOrdersPage.menuItems.get(0).click();
                break;
            case "View all products":
                webOrdersPage.menuItems.get(1).click();
                break;
            default:
                throw new RuntimeException("Menu item not found!");
        }
    }


    @When("user selects {string} as product")
    public void user_selects_as_product(String product) {
        switch(product) {
            case "MyMoney":
                webOrdersPage.productDropdown.get(0).click();
                break;
            case "FamilyAlbum":
                webOrdersPage.productDropdown.get(1).click();
                break;
            case "ScreenSaver":
                webOrdersPage.productDropdown.get(2).click();
                break;
            default:
                throw new RuntimeException("Product not found!");
        }
    }


    @When("user enters {int} as quantity")
    public void user_enters_as_quantity(Integer quantity) {
        webOrdersPage.quantity.sendKeys(Keys.DELETE + (quantity + ""));
    }


    @When("user enters all address information")
    public void user_enters_all_address_information() {
        webOrdersPage.nameInputBox.sendKeys("Pera Peric");
        webOrdersPage.streetInputBox.sendKeys("123 E Ohio St");
        webOrdersPage.cityInputBox.sendKeys("Chicago");
        webOrdersPage.stateInputBox.sendKeys("IL");
        webOrdersPage.zipInputBox.sendKeys("60000");
    }


    @When("user enters all payment information")
    public void user_enters_all_payment_information() {
        webOrdersPage.cardType.get(0).click();
        webOrdersPage.cardNumberInputBox.sendKeys("1111222233334444");
        webOrdersPage.expDateInputBox.sendKeys("06/26");
    }


    @Then("user should see their order displayed in the List of All Orders table")
    public void user_should_see_their_order_displayed_in_the_table() {
        List<List<WebElement>> tableData = webOrdersPage.getTableData();
        Assert.assertTrue(tableData.get(0).get(1).getText().equals("Pera Peric"));
    }


    @Then("validate all information entered displayed correct with the order")
    public void validate_all_information_entered_displayed_correct_with_the_order() {
        List<List<WebElement>> tableData = webOrdersPage.getTableData();
        String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        Object[] expectedInfo = {"", "Pera Peric", "FamilyAlbum",	"2", date, "123 E Ohio St", "Chicago", "IL", "60000",	"Visa",	"1111222233334444", "06/26"};

        for (int i = 1; i < tableData.get(0).size()-1; i++) {
            Assert.assertEquals(expectedInfo[i], tableData.get(0).get(i).getText());
        }
    }


    @Then("validate all orders are deleted from the List of All Orders")
    public void validate_all_orders_are_deleted_from_the_List_of_All_Orders() {
        Assert.assertEquals(0, webOrdersPage.tableRows.size());
    }


    @Then("validate user sees {string} message")
    public void validate_user_sees_message(String message) {
        Assert.assertTrue(webOrdersPage.emptyTableMessage.isDisplayed());
        Assert.assertEquals(message, webOrdersPage.emptyTableMessage.getText());
    }


}
