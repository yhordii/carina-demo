/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
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
package com.qaprosoft.carina.demo;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestTag;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;

/**
 * This sample shows how create Web test.
 * 
 * @author qpsdemo
 */
public class WebSampleTestTizen extends AbstractTest {



    @Test(description = "JIRA#AUTO-0009")
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    @TestTag(name = "area test", value = "web")
    public void testCompareModels() throws IOException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        // desiredCapabilities.setCapability("appPackage", "org.tizen.w-message");
        // desiredCapabilities.setCapability("appPackage", "org.tizen.w-contacts.app-control");
        //desiredCapabilities.setCapability("appPackage", "com.samsung.clocksetting");
        //desiredCapabilities.setCapability("appPackage", "com.samsung.w-calendar2");
        desiredCapabilities.setCapability("appPackage", "org.tizen.example.FormsApp.Tizen.Mobile");     
        desiredCapabilities.setCapability("newCommandTimeout", "600");
        // desiredCapabilities.setCapability("appPackage", "2x0Qp1z5oN.MapMyRunApp");
        desiredCapabilities.setCapability("deviceName", "Tizen");
        desiredCapabilities.setCapability("platformName", "Tizen");
        // desiredCapabilities.setCapability("platformName", "Tizen");

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.findElement(By.id("button")).click();
        pause(3);
        //((WebDriver)driver).navigate().back();
        //System.out.println(driver.executeScript("getDeviceTime")); // this
        // operation works fine since it is sdb based only
        //System.out.println(driver.getCommandExecutor().execute(new Command(driver.getSessionId(), "getDeviceTime")));
        //System.out.println(driver.getPageSource());
        //WebElement el = driver.findElement(By.id("button"));
        
        // --- driver.navigate().back();
        //driver.getCommandExecutor().execute(new Command(driver.getSessionId(), "goBack"));
        //driver.getScreenshotAs(OutputType.FILE);
        
        driver.quit();
    }
    

}
