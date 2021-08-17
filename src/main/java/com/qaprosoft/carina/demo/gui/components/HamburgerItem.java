package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.*;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HamburgerItem extends AbstractUIObject {

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='Home']")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='News']")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='Reviews']")
    private ExtendedWebElement reviewsLink;

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='Videos']")
    private ExtendedWebElement videosLink;

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='Featured']")
    private ExtendedWebElement featuredLink;

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='Phone Finder']")
    private ExtendedWebElement phoneFindersLink;

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='Deals']")
    private ExtendedWebElement dealsLink;

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='Tools']")
    private ExtendedWebElement toolsLink;

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='Coverage']")
    private ExtendedWebElement coverageLink;

    @FindBy(xpath = "//*[@id='menu']/li/a[text()='Contact']")
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

    public ReviewPage clickReviewsLink() {
        reviewsLink.click();
        return new ReviewPage(driver);
    }

    public VideosPage clickVideosLink() {
        videosLink.click();
        return new VideosPage(driver);
    }

    public NewsPage clickFeaturedLink() {
        featuredLink.click();
        return new NewsPage(driver);
    }

    public PhoneFinderPage clickPhoneFinderLink() {
        phoneFindersLink.click();
        return new PhoneFinderPage(driver);
    }

    public DealsPage clickDealsLink() {
        dealsLink.click();
        return new DealsPage(driver);
    }

    public ToolsPage clickToolsLink() {
        toolsLink.click();
        return new ToolsPage(driver);
    }

    public CoveragePage clickCoverageLink() {
        coverageLink.click();
        return new CoveragePage(driver);
    }

    public ContactPage clickContactsLink() {
        contactsLink.click();
        return new ContactPage(driver);
    }

}
