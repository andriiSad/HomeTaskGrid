package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemPage extends BasePage {

    @FindBy(xpath = "//select[@name = 'Storage-Capacity']")
    private WebElement storageCapacitySelectButton;
    @FindBy(xpath = "//select[@name = 'Storage-Capacity']//option")
    private List<WebElement> storageCapacityOptions;

    @FindBy(xpath = "//select[@name = 'Model Name']")
    private WebElement modelSelectButton;
    @FindBy(xpath = "//select[@name = 'Model Name']//option")
    private List<WebElement> modelOptions;

    @FindBy(xpath = "//select[@name = 'Color']")
    private WebElement colorSelectButton;
    @FindBy(xpath = "//select[@name = 'Color']//option")
    private List<WebElement> colorOptions;


    @FindBy(xpath = "//div[@id = 'atc-area']")
    private WebElement addToCartButton;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void addToCartButtonIsVisible() {
        waitVisibilityOfElement(DEFAULT_WAITING_TIME, addToCartButton);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

}
