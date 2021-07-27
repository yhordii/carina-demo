package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.components.HamburgerItem;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HamburgerService implements IDriverPool {
    public void areLinksWorks() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        NewsPage newsPage = new NewsPage(getDriver());
        ReviewPage reviewPage = new ReviewPage(getDriver());
        VideosPage videosPage = new VideosPage(getDriver());
        PhoneFinderPage phoneFinderPage = new PhoneFinderPage(getDriver());
        DealsPage dealsPage = new DealsPage(getDriver());
        ToolsPage toolsPage = new ToolsPage(getDriver());
        CoveragePage coveragePage = new CoveragePage(getDriver());
        ContactPage contactPage = new ContactPage(getDriver());
        HamburgerItem hamburgerItem = new HamburgerItem(getDriver());
        hamburgerItem.clickNewsLink();
        softAssert.assertTrue(newsPage.isNewsPagePresented(), "News page isn't opened.");
        hamburgerItem.clickReviewsLink();
        softAssert.assertTrue(reviewPage.isReviewsPagePresented(), "Reviews page isn't opened.");
        hamburgerItem.clickVideosLink();
        softAssert.assertTrue(videosPage.isVideosPagePresented(), "Videos page isn't opened.");
        hamburgerItem.clickFeaturedLink();
        softAssert.assertTrue(newsPage.isFeaturedPagePresented(), "Featured page isn't opened.");
        hamburgerItem.clickPhoneFinderLink();
        softAssert.assertTrue(phoneFinderPage.isPhoneFinderPagePresented(), "Phone finder page isn't opened.");
        hamburgerItem.clickDealsLink();
        softAssert.assertTrue(dealsPage.isDealsPagePresented(), "Deals page isn't opened.");
        hamburgerItem.clickToolsLink();
        softAssert.assertTrue(toolsPage.isToolsPagePresented(), "Tools page isn't opened.");
        hamburgerItem.clickCoverageLink();
        softAssert.assertTrue(coveragePage.isCoveragePageOpened(), "Network coverage page isn't opened.");
        hamburgerItem.clickContactsLink();
        softAssert.assertTrue(contactPage.isContactPagePresented(), "Contact page isn't opened.");
        hamburgerItem.clickHomeLink();
        softAssert.assertTrue(homePage.isHomePagePresented());
        softAssert.assertAll();
    }
}
