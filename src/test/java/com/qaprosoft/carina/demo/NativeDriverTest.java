package com.qaprosoft.carina.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestTag;

public class NativeDriverTest extends AbstractTest {
    
    @Test(dataProvider = "SingleDataProvider", description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestTag(name = "area test", value = "data provider")
    @TestTag(name = "specialization", value = "xlsx")
    @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "GSMArena", dsUid = "TUID", dsArgs = "brand, model, display, camera, ram, battery")
    public void testModelSpecs(String brand, String model, String display, String camera, String ram, String battery) {
        final String URL = "https://www.gsmarena.com/";
        WebDriver driver = getDriver();
        driver.get(URL);
        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }

    @Test(description = "JIRA#AUTO-0009")
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    @TestTag(name = "area test", value = "web")
    public void testCompareModels() {
        final String URL = "https://www.gsmarena.com/";
        WebDriver driver = getDriver();
        driver.get(URL);
        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }

    @Test(description = "JIRA#AUTO-0010")
    @MethodOwner(owner = "qpsdemo")
    public void testNewsSearch() {
        final String URL = "https://www.gsmarena.com/";
        WebDriver driver = getDriver();
        driver.get(URL);
        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }
    
    @Override
    public WebDriver getDriver() {
        URL url = null;
        try {
            url = new URL(Configuration.get(Parameter.SELENIUM_HOST));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        return new RemoteWebDriver(url, dc);
    }
    
}
