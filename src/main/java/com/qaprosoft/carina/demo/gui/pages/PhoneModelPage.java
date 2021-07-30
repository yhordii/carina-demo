package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import io.cucumber.java.sl.In;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PhoneModelPage extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='main main-review right l-box col']")
    private ExtendedWebElement phoneModelBody;

    @FindBy(xpath = "//div[@class='review-header']//ul/li/a[text()='Opinions']")
    private ExtendedWebElement opinionsButton;

    @FindBy(xpath = "//div[@class='sub-header centered']//select[@name='nSortNew']")
    private ExtendedWebElement opinionsSort;

    @FindBy(xpath = "//div[@id='all-opinions']/div[1]//a[@class='voting-link vote-up']")
    private ExtendedWebElement likeFirstComment;

    @FindBy(xpath = "//div[@id='all-opinions']/div[1]//a[@class='voting-link vote-down']")
    private ExtendedWebElement dislikeFirstComment;

    @FindBy(xpath = "//div[@id='all-opinions")
    private List<ExtendedWebElement> comments;

    @FindBy(xpath = "//div[@id='all-opinions']/div//span[@class='thumbs-score']")
    private List<ExtendedWebElement> likesOnComments;

    @FindBy(xpath = "//div[@id=\"all-opinions\"]//li/time")
    private List<ExtendedWebElement> dateComments;

    public PhoneModelPage(WebDriver driver) {
        super(driver);
    }

    public PhoneModelPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPhoneModelPagePresented() {
        return phoneModelBody.isPresent();
    }

    public void clickOpinions() {
        opinionsButton.click();
    }

    public void sortByBestRating() {
        opinionsSort.select("Best rating");
    }

    public boolean areCommentsSortedByRating() {
        List<Integer> likes = new ArrayList<>();
        likesOnComments.stream().forEach(t -> likes.add(Integer.parseInt(t.getText())));
        List<Integer> likesBefore = likes;
        likes.stream().sorted(Comparator.reverseOrder());
        return likes == likesBefore;
    }

    public boolean isLikeFirstComment() {
        int before = Integer.parseInt(likesOnComments.get(0).getText());
        likeFirstComment.click();
        int after = Integer.parseInt(likesOnComments.get(0).getText());
        return (after > before);
    }

    public boolean isUnratedFirstComment() {
        int before = Integer.parseInt(likesOnComments.get(0).getText());
        dislikeFirstComment.click();
        int after = Integer.parseInt(likesOnComments.get(0).getText());
        return (before > after);
    }

    public void sortByNewFirst() {
        opinionsSort.select("Newest first");
    }

    public boolean areCommentsSortedByDate() {
        List<Date> dates = new ArrayList<>();
        List<Integer> hours = new ArrayList<>();
        List<Integer> minutes = new ArrayList<>();
        List<Integer> seconds = new ArrayList<>();
        dateComments.stream().forEach(t -> {
            if (t.getText().contains("seconds ago") || t.getText().contains("second ago")) {
                seconds.add(Integer.parseInt(t.getText().replaceAll("\\D+", "")));
            } else if (t.getText().contains("minutes ago") || t.getText().contains("minute ago")) {
                minutes.add(Integer.parseInt(t.getText().replaceAll("\\D+", "")));
            } else if (t.getText().contains("hours ago") || t.getText().contains("hour ago")) {
                hours.add(Integer.parseInt(t.getText().replaceAll("\\D+", "")));
            } else {
                try {
                    dates.add(new SimpleDateFormat("dd MMM yyyy", Locale.ROOT).parse(t.getText()));
                } catch (ParseException e) {
                    LOGGER.error("Error with parsing date from comment: " + e);
                }
            }
        });
        List<Integer> secondsBefore = seconds;
        seconds.stream().sorted(Comparator.reverseOrder());
        List<Integer> minutesBefore = minutes;
        minutes.stream().sorted(Comparator.reverseOrder());
        List<Integer> hoursBefore = hours;
        hours.stream().sorted(Comparator.reverseOrder());
        List<Date> datesBefore = dates;
        dates.stream().sorted(Comparator.reverseOrder());
        return ((datesBefore == dates) && (hoursBefore == hours)
                && (minutesBefore == minutes) && (secondsBefore == seconds));
    }

}
