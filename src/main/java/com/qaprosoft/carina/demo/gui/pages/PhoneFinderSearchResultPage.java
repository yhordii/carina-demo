package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.enums.PhoneBrands;

public class PhoneFinderSearchResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='st-text']/p[contains(text(),'Your search returned ')]/a[contains(text(),'click here')]")
    private ExtendedWebElement textOnResultPage;

    @FindBy(xpath = "//*[@id='review-body']/div/ul/li")
    private List<ExtendedWebElement> phoneModels;

    @FindBy(xpath = "//*[@class='note'][contains(text(),'Note: Please report wrong Phone Finder results ')]/a[contains(text(), 'here')]")
    private ExtendedWebElement noteTextOnResultPage;

    @FindBy(xpath = "//h1[@class='article-info-name'][contains(text(), 'Phone finder results')]")
    private ExtendedWebElement phoneFinderResult;

    public PhoneFinderSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPhoneFinderResultPresented() {
        return phoneFinderResult.isPresent();
    }

    public boolean isPhoneFinderResultTextPresented() {
        return textOnResultPage.isPresent();
    }

    public boolean isCorrectBrandPresented(PhoneBrands phoneBrands) {
        return phoneModels.stream().allMatch(t -> t.getText().contains(phoneBrands.getValue()));
    }

    public boolean isNoteOnResultPagePresented() {
        return noteTextOnResultPage.isPresent();
    }

    public PhoneFinderPage returnToPhoneFinder() {
        textOnResultPage.click();
        return new PhoneFinderPage(driver);
    }
}
