package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedSearchTests extends BaseTest {
    private static final String PRODUCT_NAME = "Google Pixel 4 XL new";
    private static final int MIN_PRICE = 400;
    private static final int MAX_PRICE = 500;

    @Test
    public void checkPriceFilterInAdvancedSearch() {
        getHomePage().navigateToAdvancedSearch();
        getAdvancedSearchPage().searchButtonIsVisible();
        getAdvancedSearchPage().fillAdvancedSearchSections(PRODUCT_NAME, MIN_PRICE, MAX_PRICE);
        getAdvancedSearchPage().clickOnSearchButton();
        getSearchResultsPage().listOfItemsPricesIsVisible();
        for (boolean condition : getSearchResultsPage().getConformityListOfPrices(MIN_PRICE, MAX_PRICE)) {
            Assert.assertTrue(condition);
        }
    }
}
