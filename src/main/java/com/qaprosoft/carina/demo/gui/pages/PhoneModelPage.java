package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;



public class PhoneModelPage extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='main main-review right l-box col']")
    private ExtendedWebElement phoneModelBody;

    @FindBy(xpath = "//div[@class='review-header']//ul/li/a[text()='Opinions']")
    private ExtendedWebElement opinionsButton;

    public PhoneModelPage(WebDriver driver) {
        super(driver);
    }

    public PhoneModelPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPhoneModelPagePresented() {
        return phoneModelBody.isPresent();
    }

    public PhoneModelOpinions clickOpinions() {
        opinionsButton.click();
        return new PhoneModelOpinions(driver);
    }

}
