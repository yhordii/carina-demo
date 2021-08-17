package com.qaprosoft.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.demo.enums.PhoneBrands;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class PhoneFinderPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//h1[contains (text(), 'Phone finder')]")
    private ExtendedWebElement phoneFinderTitle;

    @FindBy(xpath = "//span[normalize-space()='%s']")
    private ExtendedWebElement choosenBrand;

    @FindBy(xpath = "//span[@class='pf-border']//input[@value='Show']")
    private ExtendedWebElement showButton;

    @FindBy(xpath = "//*[@class='pf-border']/span[@id='pf-results'][contains(text(),' results')]")
    private ExtendedWebElement showButtonText;

    @FindBy(xpath = "//button[@data-id='sMakers']")
    private ExtendedWebElement phoneDropdownMenu;

    @FindBy(xpath = "//li[@class='article-info-meta-link help help-sort-popularity']/a")
    private ExtendedWebElement popularityButton;

    @FindBy(xpath = "//div[@class='makers']/ul/li[1]")
    private ExtendedWebElement mostPopularModel;

    @FindBy(xpath = "//div[@class='article-hgroup']/h1[contains(text(),'%s phones')]")
    private ExtendedWebElement resultPhonesBrand;

    @FindBy(xpath = "//li[@class='article-info-meta-link light large help help-review compare-button']")
    private ExtendedWebElement compareButton;

    @FindBy(xpath = "//div[@class='makers']//li")
    private List<ExtendedWebElement> phoneList;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPhoneFinderPagePresented() {
        return phoneFinderTitle.isPresent();
    }

    public void clickPhoneBrand(PhoneBrands phoneBrands) {
        phoneDropdownMenu.click();
        choosenBrand.format(phoneBrands.getValue()).click();
    }

    public boolean isBottomShowButtonPresented() {
        return showButton.isPresent();
    }

    public boolean isBottomShowButtonContainsText() {
        return showButtonText.isPresent();
    }

    public PhoneFinderSearchResultPage clickShowButton() {
        showButton.click();
        return new PhoneFinderSearchResultPage(driver);
    }

    public boolean isTitlePhoneFinderPresented() {
        return phoneFinderTitle.isPresent();
    }

    public PhoneModelPage openMostPopularPhoneModel() {
        popularityButton.click();
        mostPopularModel.click();
        return new PhoneModelPage(driver);
    }

    public boolean isRightPhonesBrandPresented(PhoneBrands phoneBrand){
        return resultPhonesBrand.format(phoneBrand.getValue()).isPresent();
    }

    public PhoneFinderPage clickCompareButton(){
        compareButton.click();
        return new PhoneFinderPage(driver);
    }

    public CompareModelsPage selectFirstThreeModels(){
        phoneList.stream().limit(3).forEach(p->((JavascriptExecutor) driver).executeScript("arguments[0].className='checked'",p));
        compareButton.click();
        return new CompareModelsPage(driver);
    }

}
