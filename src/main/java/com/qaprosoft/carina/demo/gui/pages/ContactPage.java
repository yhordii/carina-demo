package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains (text(), 'Contact us')]")
    private ExtendedWebElement contactsTitle;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public boolean isContactPagePresented(){
        return contactsTitle.isPresent();
    }

}
