package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'adv-s mb space-top']//button[@class = 'btn btn-prim']")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@aria-labelledby = 'kw_lengend']")
    private WebElement inputItemName;
    @FindBy(xpath = "//input[@name = '_udlo']")
    private WebElement inputMinPrice;
    @FindBy(xpath = "//input[@name = '_udhi']")
    private WebElement inputMaxPrice;
    @FindBy(xpath = "//input[@name = 'LH_BIN']")
    private WebElement buyItNowCheckBox;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchButtonIsVisible() {
        waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchButton);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void fillAdvancedSearchSections(String itemName, int minPrice, int maxPrice) {
        inputItemName.sendKeys(itemName);
        inputMinPrice.sendKeys(String.valueOf(minPrice));
        inputMaxPrice.sendKeys(String.valueOf(maxPrice));
        buyItNowCheckBox.click();
    }
}
