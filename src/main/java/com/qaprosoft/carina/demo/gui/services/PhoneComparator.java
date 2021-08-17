package com.qaprosoft.carina.demo.gui.services;


import java.util.List;

import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class PhoneComparator implements IAbstractTest {
    public void compareThreeModels(ModelSpecs.SpecType specType, String condition, String model1, String model2, String model3) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        CompareModelsPage compareModelsPage = homePage.getFooterMenu().openComparePage();
        List<ModelSpecs> specs = compareModelsPage.compareModels(model1, model2, model3);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(specs.get(0).readSpec(specType).contains(condition), "First model doesn't have these technologies.");
        softAssert.assertTrue(specs.get(1).readSpec(specType).contains(condition), "Second model doesn't have these technologies.");
        softAssert.assertTrue(specs.get(2).readSpec(specType).contains(condition), "Third model doesn't have these technologies.");
        softAssert.assertAll();
    }
}
