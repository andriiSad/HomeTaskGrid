package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SneakersPage extends BasePage {
    @FindBy(xpath = "//a[@_sp = 'p2489527.m5061.l9606']")
    private List<WebElement> topBrandsList;

    public SneakersPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToNewBalanceSearchResultPage() {
        waitVisibilityOfElement(DEFAULT_WAITING_TIME, topBrandsList.get(8));
        topBrandsList.get(8).click();
    }
}
