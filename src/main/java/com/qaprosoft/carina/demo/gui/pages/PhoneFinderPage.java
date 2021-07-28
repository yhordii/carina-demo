package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhoneFinderPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains (text(), 'Phone finder')]")
    private ExtendedWebElement phoneFinderTitle;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPhoneFinderPagePresented() {
        return phoneFinderTitle.isPresent();
    }
}
