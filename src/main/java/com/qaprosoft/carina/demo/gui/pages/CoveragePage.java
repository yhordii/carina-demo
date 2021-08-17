package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CoveragePage extends AbstractPage {

    @FindBy(xpath = "//h1[contains (text(), 'Network coverage')]")
    private ExtendedWebElement coverageTitle;

    public CoveragePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCoveragePageOpened() {
        return coverageTitle.isPresent();
    }

}
