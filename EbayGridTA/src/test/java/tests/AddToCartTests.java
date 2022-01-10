package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseTest {
    private static final String SEARCH_TEXT_POKEMON = "pokemon lot";
    private static final String SEARCH_TEXT_BAKUGAN = "bakugan lot";
    private static final String SEARCH_TEXT_WATCH = "bronzong holo";

    private static final String EXPECTED_ITEMS_QUANTITY = "Items (3)";

    private static final int TAB_INDEX_1 = 1;
    private static final int TAB_INDEX_2 = 2;
    private static final int TAB_INDEX_3 = 3;

    @Test
    public void checkThatItemsAddingToCart() {
        getHomePage().enterTextToSearchField(SEARCH_TEXT_POKEMON);
        getSearchResultsPage().listOfItemsIsVisible();
        getSearchResultsPage().clickOnBuyItNowButton();
        getSearchResultsPage().clickOnFirstItem();
        getSearchResultsPage().switchDriverToNewTab(TAB_INDEX_1);
        getItemPage().addToCartButtonIsVisible();
        getItemPage().clickOnAddToCartButton();

        getHomePage().enterTextToSearchField(SEARCH_TEXT_BAKUGAN);
        getSearchResultsPage().listOfItemsIsVisible();
        getSearchResultsPage().clickOnBuyItNowButton();
        getSearchResultsPage().clickOnFirstItem();
        getSearchResultsPage().switchDriverToNewTab(TAB_INDEX_2);
        getItemPage().addToCartButtonIsVisible();
        getItemPage().clickOnAddToCartButton();

        getHomePage().enterTextToSearchField(SEARCH_TEXT_WATCH);
        getSearchResultsPage().listOfItemsIsVisible();
        getSearchResultsPage().clickOnBuyItNowButton();
        getSearchResultsPage().clickOnFirstItem();
        getSearchResultsPage().switchDriverToNewTab(TAB_INDEX_3);
        getItemPage().addToCartButtonIsVisible();
        getItemPage().clickOnAddToCartButton();

        Assert.assertEquals(getCartPage().getItemsQuantityInString(), EXPECTED_ITEMS_QUANTITY);
    }

    @Test
    public void checkThatItemsRemovingFromCart() {
        getHomePage().enterTextToSearchField(SEARCH_TEXT_POKEMON);
        getSearchResultsPage().listOfItemsIsVisible();
        getSearchResultsPage().clickOnBuyItNowButton();
        getSearchResultsPage().clickOnFirstItem();
        getSearchResultsPage().switchDriverToNewTab(TAB_INDEX_1);
        getItemPage().addToCartButtonIsVisible();
        getItemPage().clickOnAddToCartButton();

        getHomePage().enterTextToSearchField(SEARCH_TEXT_WATCH);
        getSearchResultsPage().listOfItemsIsVisible();
        getSearchResultsPage().clickOnBuyItNowButton();
        getSearchResultsPage().clickOnFirstItem();
        getSearchResultsPage().switchDriverToNewTab(TAB_INDEX_2);
        getItemPage().addToCartButtonIsVisible();
        getItemPage().clickOnAddToCartButton();

        getCartPage().removeAllItemsFromCart();
        getCartPage().waitForEmptyCartIsVisible();

        Assert.assertTrue(getCartPage().cartIsEmpty());


    }
}
