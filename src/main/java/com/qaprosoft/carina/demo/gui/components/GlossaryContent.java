package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class GlossaryContent extends AbstractUIObject {

    @FindBy(xpath = "./a")
    private List<ExtendedWebElement> contentInParagraph;

    public GlossaryContent(WebDriver driver) {
        super(driver);
    }

    public GlossaryContent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<String> listOfContent() {
        List<String> content = new ArrayList<>();
        for (ExtendedWebElement paragraph : contentInParagraph) {
            content.add(paragraph.getText());
        }
        return content;
    }

}
