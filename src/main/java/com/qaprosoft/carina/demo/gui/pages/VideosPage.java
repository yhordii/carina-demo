package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class VideosPage extends AbstractPage {
    @FindBy(xpath = "//h1[contains (text(), 'Videos')]")
    private ExtendedWebElement videosTitle;

    public VideosPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVideosPagePresented() {
        return videosTitle.isPresent();
    }
}
