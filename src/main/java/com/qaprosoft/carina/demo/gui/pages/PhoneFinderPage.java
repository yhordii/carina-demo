package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class PhoneFinderPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//h1[contains (text(), 'Phone finder')]")
    private ExtendedWebElement phoneFinderTitle;

    private ExtendedWebElement choosenBrand;

    @FindBy(xpath = "//span[@class='pf-border']//input[@value='Show']")
    private ExtendedWebElement showButton;

    @FindBy(xpath = "//*[@class=\"pf-border\"]/span[@id=\"pf-results\"][contains(text(),\" results\")]")
    private ExtendedWebElement showButtonText;

    @FindBy(xpath = "//button[@data-id=\"sMakers\"]")
    private ExtendedWebElement phoneDropdownMenu;

    @FindBy(xpath = "//h1[@class=\"article-info-name\"][contains(text(), \"Phone finder results\")]")
    private ExtendedWebElement phoneFinderResult;

    @FindBy(xpath = "//div[@class='st-text']/p[contains(text(),'Your search returned ')]/a[contains(text(),'click here')]")
    private ExtendedWebElement textOnResultPage;

    @FindBy(xpath ="//*[@id=\"review-body\"]/div/ul/li")
    private List<ExtendedWebElement> phoneModels;

    @FindBy(xpath = "//*[@class='note'][contains(text(),'Note: Please report wrong Phone Finder results ')]/a[contains(text(), 'here')]")
    private ExtendedWebElement noteTextOnResultPage;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPhoneFinderPagePresented() {
        return phoneFinderTitle.isPresent();
    }

    public void clickPhoneBrand(String brand) {
        phoneDropdownMenu.click();
        choosenBrand = findExtendedWebElement(By.xpath(String.format("//span[normalize-space()='%s']", brand)));
        choosenBrand.click();
    }

    public boolean isBottomShowButtonPresented() {
        return showButton.isPresent();
    }

    public boolean isBottomShowButtonContainsText() {
        return showButtonText.isPresent();
    }

    public void clickShowButton(){
        showButton.click();
    }

    public boolean isPhoneFinderResultPresented() {
        return phoneFinderResult.isPresent();
    }

    public boolean isPhoneFinderResultTextPresented() {
        return textOnResultPage.isPresent();
    }

    public boolean isCurrectBrandPresented(String brand){
        return phoneModels.stream().allMatch(t->t.getText().contains(brand));
    }

    public boolean isNoteOnResultPagePresented(){
        return noteTextOnResultPage.isPresent();
    }

    public boolean returnToPhoneFinder(){
        textOnResultPage.click();
        return phoneFinderTitle.isPresent();
    }

}
