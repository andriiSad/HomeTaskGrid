package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {
    private static final String EXPECTED_NAME = "new balance";

    @Test
    public void checkThatProductNamesMatchesToSearchRequest() {
        getHomePage().navigateToSneakersPage();
        getSneakersPage().navigateToNewBalanceSearchResultPage();

        for (boolean condition : getSearchResultsPage().getConformityListOfNames(EXPECTED_NAME)) {
            Assert.assertTrue(condition);
        }

    }
}
