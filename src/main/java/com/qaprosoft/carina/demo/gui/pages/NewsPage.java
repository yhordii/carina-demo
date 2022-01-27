/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewsPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(className = "searchFor")
    private ExtendedWebElement searchTextField;

    @FindBy(xpath = "//input[@value='Search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@class='news-item']")
    private List<NewsItem> news;

    @FindBy(xpath = "//*[@class='floating-title']/div[1]/a")
    private ExtendedWebElement firstArticle;

    @FindBy(xpath = "//*[@class='article-info-name']")
    private ExtendedWebElement resultSearchTextField;

    @FindBy(xpath = "//h1[contains (text(), 'Articles tagged \"Featured\"')]")
    private ExtendedWebElement featuredArticle;

    @FindBy(xpath = "//h1[contains (text(), 'News')]")
    private ExtendedWebElement newsTitle;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3");
    }

    public List<NewsItem> searchNews(String q) {
        searchTextField.type(q);
        searchButton.click();
        return news;
    }
    public String getFirstArticleTitle(){
        return firstArticle.getText();
    }
    public ArticlePage openFirstArticle() {
        firstArticle.click();
        return new ArticlePage(driver);
    }

    public boolean areArticlesContain(String text) {
        return news.stream().allMatch((a) -> a.readTitle().contains(text));
    }

    public String getResultSearchText(){
        return resultSearchTextField.getText();
    }

    public boolean isNewsPagePresented(){
        return newsTitle.isPresent();
    }

    public boolean isFeaturedPagePresented(){
        return featuredArticle.isPresent();
    }

}
