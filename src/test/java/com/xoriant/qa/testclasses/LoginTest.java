package com.xoriant.qa.testclasses;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xoriant.qa.pageclasses.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

public class LoginTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp(ITestContext context) {
		context.setAttribute("loginUrl", "https://www.truckdues.com/app/");
		context.setAttribute("email", "nasruddin.shaik@jeevantechnologies.com");
		context.setAttribute("password", "123456");
		context.setAttribute("invalidEmail", "nasruddin.shaik@jeevantechnologies.comm");
		context.setAttribute("invalidPassword", "1234567");
		System.out.println(context.getName());
		System.out.println(context.getHost());
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shaik_n\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@DisplayName("Valid username and valid password")
	@Severity (SeverityLevel.CRITICAL)
	@Description("This test case is about validating the login functionality using valid username and valid password")
	@Test(invocationCount = 1, description = "valid username and valid password")
	@Story ("Login Validation")
	@Link ("https://www.google.com")
	@Link(name = "allure", type = "mylink")
	@Issue("DSDOM-193582")
	public void loginWithValidUsernameAndValidPassword(ITestContext context) throws InterruptedException {
		LoginPage refLoginPage = new LoginPage(driver);
		refLoginPage.maximizeBrowser();
		refLoginPage.navigateToUrl(context.getAttribute("loginUrl").toString());
		refLoginPage.useImplicitWait(5);
		refLoginPage.enterEmail(context.getAttribute("email").toString());
		refLoginPage.enterPassword(context.getAttribute("password").toString());
		Thread.sleep(4000);
		refLoginPage.clickLogin();
		Thread.sleep(4000);
		Assert.assertEquals(refLoginPage.getBrowserTitle(), "Dashboard | TruckDues.com");
	}

	@Test
	@Severity(SeverityLevel.BLOCKER)
	public void loginWithValidUsernameAndInvalidPassword(ITestContext context) throws InterruptedException {
		LoginPage refLoginPage = new LoginPage(driver);
		refLoginPage.maximizeBrowser();
		refLoginPage.navigateToUrl(context.getAttribute("loginUrl").toString());
		refLoginPage.useImplicitWait(5);
		refLoginPage.enterEmail(context.getAttribute("email").toString());
		refLoginPage.enterPassword(context.getAttribute("invalidPassword").toString().concat("1"));
		Thread.sleep(4000);
		refLoginPage.clickLogin();
		Thread.sleep(4000);
		Assert.assertEquals(refLoginPage.getBrowserTitle(), "Welcome | TruckDues.com");
		Assert.assertEquals(refLoginPage.getInvalidEmailAndOrPasswordMessage().trim(),
				"Email and Password do not match, Try again.");
	}

	@Test
	@Severity (SeverityLevel.TRIVIAL)
	public void loginWithInvalidUsernameAndValidPassword(ITestContext context) throws InterruptedException {
		LoginPage refLoginPage = new LoginPage(driver);
		refLoginPage.maximizeBrowser();
		refLoginPage.navigateToUrl(context.getAttribute("loginUrl").toString());
		refLoginPage.useImplicitWait(5);
		refLoginPage.enterEmail(context.getAttribute("invalidEmail").toString());
		refLoginPage.enterPassword(context.getAttribute("password").toString());
		Thread.sleep(4000);
		refLoginPage.clickLogin();
		Thread.sleep(4000);
		Assert.assertEquals(refLoginPage.getBrowserTitle(), "Welcome | TruckDues.com");
		Assert.assertEquals(refLoginPage.getInvalidEmailAndOrPasswordMessage().trim(),
				"Email and Password do not match, Try again.");
	}

	@Test(enabled = false)
	public void loginWithInvalidUsernameAndInvalidPassword(ITestContext context) throws InterruptedException {
		LoginPage refLoginPage = new LoginPage(driver);
		refLoginPage.maximizeBrowser();
		refLoginPage.navigateToUrl(context.getAttribute("loginUrl").toString());
		refLoginPage.useImplicitWait(5);
		refLoginPage.enterEmail(context.getAttribute("invalidEmail").toString());
		refLoginPage.enterPassword(context.getAttribute("invalidPassword").toString());
		Thread.sleep(4000);
		refLoginPage.clickLogin();
		Thread.sleep(4000);
		Assert.assertEquals(refLoginPage.getBrowserTitle(), "Welcome | TruckDues.com");
		Assert.assertEquals(refLoginPage.getInvalidEmailAndOrPasswordMessage().trim(),
				"Email and Password do not match, Try again.");
	}

	@Test(priority = 1, enabled = false)
	public void loginWithValidUsernameAndEmptyPassword(ITestContext context) throws InterruptedException {
		LoginPage refLoginPage = new LoginPage(driver);
		refLoginPage.maximizeBrowser();
		refLoginPage.navigateToUrl(context.getAttribute("loginUrl").toString());
		refLoginPage.useImplicitWait(5);
		refLoginPage.enterEmail(context.getAttribute("email").toString());
		Thread.sleep(4000);
		refLoginPage.clickLogin();
		Thread.sleep(4000);
		Assert.assertEquals(refLoginPage.getBrowserTitle(), "Welcome | TruckDues.com");
		Assert.assertEquals(refLoginPage.getEmptyPasswordErrorMessage().trim(), "This field is required.");
	}

	@Test(priority = 2, enabled = false)
	public void loginWithEmptyUsernameAndValidPassword(ITestContext context) throws InterruptedException {
		LoginPage refLoginPage = new LoginPage(driver);
		refLoginPage.maximizeBrowser();
		refLoginPage.navigateToUrl(context.getAttribute("loginUrl").toString());
		refLoginPage.useImplicitWait(5);
		refLoginPage.enterPassword(context.getAttribute("password").toString());
		Thread.sleep(4000);
		refLoginPage.clickLogin();
		Thread.sleep(4000);
		Assert.assertEquals(refLoginPage.getBrowserTitle(), "Welcome | TruckDues.com");
		Assert.assertEquals(refLoginPage.getEmptyEmailErrorMessage().trim(), "This field is required.");
	}

	@Test(enabled = false)
	public void loginWithEmptyUsernameAndEmptyPassword(ITestContext context) throws InterruptedException {
		LoginPage refLoginPage = new LoginPage(driver);
		refLoginPage.maximizeBrowser();
		refLoginPage.navigateToUrl(context.getAttribute("loginUrl").toString());
		refLoginPage.useImplicitWait(5);
		Thread.sleep(4000);
		refLoginPage.clickLogin();
		Thread.sleep(4000);
		Assert.assertEquals(refLoginPage.getBrowserTitle(), "Welcome | TruckDues.com");
		Assert.assertEquals(refLoginPage.getEmptyEmailErrorMessage().trim(), "This field is required.");
		Assert.assertEquals(refLoginPage.getEmptyPasswordErrorMessage().trim(), "This field is required.");

	}

	@Test(enabled = false)
	public void signUpButtonNavigation(ITestContext context) throws InterruptedException {
		LoginPage refLoginPage = new LoginPage(driver);
		refLoginPage.maximizeBrowser();
		refLoginPage.navigateToUrl(context.getAttribute("loginUrl").toString());
		refLoginPage.useImplicitWait(5);
		Thread.sleep(4000);
		refLoginPage.clickSignUp();
		Thread.sleep(4000);
		Assert.assertEquals(refLoginPage.getBrowserTitle(), "sign Up | TruckDues.com");
		Assert.assertTrue(refLoginPage.getCurrentWindowUrl().contains("register"));
	}

	@Test(enabled = false)
	public void resetPasswordLinkNavigation(ITestContext context) throws InterruptedException {
		Properties prop = new Properties();
		LoginPage refLoginPage = new LoginPage(driver);
		refLoginPage.maximizeBrowser();
		refLoginPage.navigateToUrl(context.getAttribute("loginUrl").toString());
		refLoginPage.useImplicitWait(5);
		Thread.sleep(4000);
		refLoginPage.clickResetPasswordLink();
		Thread.sleep(4000);
		Assert.assertEquals(refLoginPage.getBrowserTitle(), "Find Your Account | TruckDues.com");
		Assert.assertTrue(refLoginPage.getCurrentWindowUrl().contains("FindYourAccount"));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
