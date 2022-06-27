package com.xoriant.qa.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xoriant.qa.base.BaseClass;

public class LoginPage extends BaseClass {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "login")
	WebElement emailIdTextBox;
	@FindBy(name = "password")
	WebElement passwordTextBox;
	@FindBy(id = "btnLogin")
	WebElement loginButton;
	@FindBy(id = "btnSignUp")
	WebElement signUpButton;
	@FindBy(xpath = "//a[contains(text(),'Click here')]")
	WebElement passwordResetLink;
	@FindBy(xpath = "//div[@class='logo']")
	WebElement truckDuesLogo;
	@FindBy(xpath = "//input[@name='login']/following-sibling::span")
	WebElement emptyEmailIdErrorMessage;
	@FindBy(xpath = "//input[@name='password']/following-sibling::span")
	WebElement emptyPasswordErrorMessage;
	@FindBy(xpath = "//*[contains(text(),'Login H')]")
	WebElement loginHereText;
	@FindBy(xpath = "//*[contains(text(),'Forgot your')]")
	WebElement forgotPasswordText;
	@FindBy(xpath = "//*[contains(text(),'Please enter a proper email')]")
	WebElement improperEmailIdFormatErrorMessage;
	@FindBy(xpath = "//a[contains(text(),'TruckDues.com')]")
	WebElement truckDuesHomePageLink;
	@FindBy(xpath = "//a[contains(text(),'Jeevan Tech')]")
	WebElement jeevanTechnologiesLink;
	@FindBy(xpath = "//p[contains(text(),'Email and Password')]")
	WebElement invalidUsernameAndOrPassword;

	public void enterEmail(String emailValue) {
		emailIdTextBox.sendKeys(emailValue);
	}

	public void enterPassword(String passwordValue) {
		passwordTextBox.sendKeys(passwordValue);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void clickSignUp() {
		signUpButton.click();
	}

	public void clickResetPasswordLink() {
		passwordResetLink.click();
	}

	public String getEmptyEmailErrorMessage() {
		return emptyEmailIdErrorMessage.getText();
	}

	public String getEmptyPasswordErrorMessage() {
		return emptyPasswordErrorMessage.getText();
	}

	public String getImproperEmailIdFormatErrorMessage() {
		return improperEmailIdFormatErrorMessage.getText();
	}

	public void waitUntilLoginButtonIsClicked() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
	}

	public String getInvalidEmailAndOrPasswordMessage() {
		return invalidUsernameAndOrPassword.getText();
	}
}
