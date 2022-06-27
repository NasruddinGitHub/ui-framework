package com.xoriant.qa.testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.xoriant.qa.pageclasses.LoginPage;

public class DashboardTest {
	WebDriver driver;

	@Test
	public void validateTitleinDashboardPage(ITestContext context) {
		System.out.println("Test Verbose");
	}

}
