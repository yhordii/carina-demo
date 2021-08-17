package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DealsPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains (text(), 'Daily deals')]")
    private ExtendedWebElement dealsTitle;

    public DealsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDealsPagePresented() {
        return dealsTitle.isPresent();
    }
}
