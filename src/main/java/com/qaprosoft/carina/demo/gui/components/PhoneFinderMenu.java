package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.PhoneFinderPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhoneFinderMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@class=\"pad-single pad-finder\"]")
    private ExtendedWebElement phoneFinderButton;

    public PhoneFinderMenu(WebDriver driver) {
        super(driver);
    }

    public PhoneFinderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        phoneFinderButton.click();
        return new PhoneFinderPage(driver);
    }

}
