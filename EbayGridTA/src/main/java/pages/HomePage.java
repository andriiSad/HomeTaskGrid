package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@id = 'gh-ac']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@title = 'Advanced Search']")
    private WebElement advancedSearchButton;

    @FindBy(xpath = "//div[@id = 'destinations_list2']//h3")
    private List<WebElement> popularCategoriesList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage enterTextToSearchField(String searchText) {
        searchField.sendKeys(searchText, Keys.ENTER);
        return this;
    }

    public void navigateToAdvancedSearch() {
        advancedSearchButton.click();
    }

    public void navigateToSneakersPage() {
        popularCategoriesList.get(0).click();
    }
}
