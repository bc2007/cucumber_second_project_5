package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class WebOrdersPage {

    public WebOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#ctl00_menu a")
    public List<WebElement> menuItems;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;

    @FindBy(css = "input[id*='ctl00_MainContent_orderGrid']")
    public List<WebElement> rowsCheckers;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct>option")
    public List<WebElement> productDropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement nameInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInputBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList label")
    public List<WebElement> cardType;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expDateInputBox;

    @FindBy(css = "#ctl00_MainContent_orderGrid tr")
    public List<WebElement> tableRows;


    public List<List<WebElement>> getTableData(){

        List<List<WebElement>> tableData = new ArrayList<>();

        for (int i = 2; i <= tableRows.size(); i++) {
            tableData.add(Driver.getDriver().findElements(By.cssSelector("table[class='SampleTable'] tr:nth-child(" + i + ")>td")));
        }
        return tableData;
    }


    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteButton;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement emptyTableMessage;



}
