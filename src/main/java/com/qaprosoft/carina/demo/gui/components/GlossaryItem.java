package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
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
    private List<ExtendedWebElement> nameParagraph;

    @FindBy(xpath = "//*[@class=\"st-text\"]/p")
    private List<ExtendedWebElement> contentParagraph;

    public GlossaryItem(WebDriver driver) {
        super(driver);
    }

    public GlossaryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isHeaderEqualsListSize() {
        LOGGER.info(nameParagraph.size() + " " + contentParagraph.size());
        return (nameParagraph.size() == contentParagraph.size());
    }

    public boolean areParagraphMatchText() {
        boolean result = false;
        for (int i = 1; i < nameParagraph.size(); i++) {
            ExtendedWebElement tempParagraph = nameParagraph.get(i);
            LOGGER.info(contentParagraph.get(i).getText());
            List<String> tempText = Collections.singletonList(contentParagraph.get(i).getText());
            LOGGER.info(String.valueOf(tempParagraph.getText().charAt(0)));
            result = tempText.stream().anyMatch(t -> t.startsWith(String.valueOf(tempParagraph.getText().charAt(0))));
        }
        return result;
    }

    public boolean isTextInRightOrder() {
        List<String> tempSortedText = null;
        List<String> tempText = null;
        for (int i = 1; i < contentParagraph.size(); i++) {
            tempSortedText = Arrays.asList(contentParagraph.get(i).getText().replace("|", "").split("  "));
            tempText = tempSortedText;
            Collections.sort(tempSortedText);
        }
        return tempText.equals(tempSortedText);
    }

}
