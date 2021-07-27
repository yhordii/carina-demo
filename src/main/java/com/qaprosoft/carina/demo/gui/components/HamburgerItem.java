package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HamburgerItem extends AbstractUIObject {

    @FindBy(xpath = "//*[@id=\"menu\"]/li[1]/a")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[2]/a")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[3]/a")
    private ExtendedWebElement reviewsLink;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[4]/a")
    private ExtendedWebElement videosLink;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[5]/a")
    private ExtendedWebElement featuredLink;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[6]/a")
    private ExtendedWebElement phoneFindersLink;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[7]/a")
    private ExtendedWebElement dealsLink;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[8]/a")
    private ExtendedWebElement toolsLink;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[9]/a")
    private ExtendedWebElement coverageLink;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[10]/a")
    private ExtendedWebElement contactsLink;

    public HamburgerItem(WebDriver driver) {
        super(driver);
    }

    public HamburgerItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage clickHomeLink() {
        homeLink.click();
        return new HomePage(driver);
    }

    public NewsPage clickNewsLink() {
        newsLink.click();
        return new NewsPage(driver);
    }

    public void clickReviewsLink() {
        reviewsLink.click();
    }

    public void clickVideosLink() {
        videosLink.click();
    }

    public void clickFeaturedLink() {
        featuredLink.click();
    }

    public void clickPhoneFinderLink() {
        phoneFindersLink.click();
    }

    public void clickDealsLink() {
        dealsLink.click();
    }

    public void clickToolsLink() {
        toolsLink.click();
    }

    public void clickCoverageLink() {
        coverageLink.click();
    }

    public void clickContactsLink() {
        contactsLink.click();
    }

}
