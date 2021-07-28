package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ToolsPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains (text(), 'GSMArena Tools & Features')]")
    private ExtendedWebElement toolsTitle;

    public ToolsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isToolsPagePresented(){
        return toolsTitle.isPresent();
    }

}
