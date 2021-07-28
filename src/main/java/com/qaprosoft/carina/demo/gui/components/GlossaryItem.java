package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.components.GlossaryContent;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GlossaryItem extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@class=\"st-text\"]/h3")
    private List<ExtendedWebElement> nameParagraphs;

    @FindBy(xpath = "//*[@class=\"st-text\"]/p")
    private List<GlossaryContent> contentParagraphs;

    public GlossaryItem(WebDriver driver) {
        super(driver);
    }

    public GlossaryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isHeaderEqualsListSize() {
        return (nameParagraphs.size() == contentParagraphs.size());
    }

    public boolean areParagraphMatchText() {
        boolean result = false;
        for (int i = 0; i < nameParagraphs.size(); i++) {
            if (!Character.isDigit(nameParagraphs.get(i).getText().charAt(0))) {
                ExtendedWebElement tempParagraph = nameParagraphs.get(i);
                List<String> tempText = contentParagraphs.get(i).listOfContent();
                result = tempText.stream().allMatch(t -> t.startsWith(String.valueOf(tempParagraph.getText().charAt(0))));
            } else {
                List<String> tempText = contentParagraphs.get(i).listOfContent();
                result = tempText.stream().allMatch(t -> Character.isDigit(t.charAt(0)));
            }
        }
        return result;
    }

    public boolean isTextInRightOrder() {
        List<String> tempSortedText = null;
        List<String> tempText = null;
        for (int i = 0; i < contentParagraphs.size(); i++) {
            tempSortedText = contentParagraphs.get(i).listOfContent();
            tempText = tempSortedText;
            Collections.sort(tempSortedText);
        }
        return tempText.equals(tempSortedText);
    }

}
