package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GlossaryPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='article-info-name'][contains(text(), 'Mobile terms glossary')]")
    private ExtendedWebElement glossaryTitle;

    public GlossaryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isGlossaryPagePresented() {
        return glossaryTitle.isPresent();
    }

}
