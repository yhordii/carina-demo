package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends AbstractPage {
    @FindBy(xpath = "//h1[contains (text(), 'Reviews')]")
    private ExtendedWebElement reviewsTitle;

    public ReviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isReviewsPagePresented(){
        return reviewsTitle.isPresent();
    }
}
