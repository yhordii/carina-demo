package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.ClassChain;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

	@FindBy(xpath = "type = 'XCUIElementTypeTextField'")
	@Predicate
	private ExtendedWebElement nameInputField;

	@FindBy(xpath = "type = 'XCUIElementTypeSecureTextField'")
	@Predicate
	private ExtendedWebElement passwordInputField;

	@FindBy(xpath = "name = 'Male' AND type = 'XCUIElementTypeButton'")
	@Predicate
	private ExtendedWebElement maleRadioBtn;

	@FindBy(xpath = "**/XCUIElementTypeButton[`name == 'Female'`]")
	@ClassChain
	private ExtendedWebElement femaleRadioBtn;

	@FindBy(xpath = "**/XCUIElementTypeButton[`name CONTAINS 'checkbox'`]")
	@ClassChain
	private ExtendedWebElement privacyPolicyCheckbox;

	@FindBy(xpath = "name = 'LOGIN'")
	@Predicate
	private ExtendedWebElement loginBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void typeName(String name) {
		nameInputField.type(name);
	}

	@Override
	public void typePassword(String password) {
		passwordInputField.type(password);
	}

	@Override
	public void selectMaleSex() {
		maleRadioBtn.click();
	}

	@Override
	public void checkPrivacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();
	}

	@Override
	public CarinaDescriptionPageBase clickLoginBtn() {
		loginBtn.click();
		return initPage(getDriver(), CarinaDescriptionPageBase.class);
	}

	@Override
	public boolean isLoginBtnActive() {
		return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
	}

	@Override
	public CarinaDescriptionPageBase login(){
		String username = "Test user";
		String password = RandomStringUtils.randomAlphabetic(10);
		typeName(username);
		typePassword(password);
		selectMaleSex();
		checkPrivacyPolicyCheckbox();
		return clickLoginBtn();
	}

	@Override
	public boolean namePresented() {
		return false;
	}

	@Override
	public boolean passPresented() {
		return false;
	}

	@Override
	public boolean genderPresented() {
		return false;
	}

	@Override
	public boolean isPageOpened() {
		return false;
	}

	@Override
	public boolean isMaleSelected() {
		return false;
	}

	@Override
	public boolean isPrivacyChecked() {
		return false;
	}

}
