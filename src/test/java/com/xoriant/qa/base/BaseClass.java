package com.xoriant.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class BaseClass {

	WebDriver driver;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public void useImplicitWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	@Step("It maximizes the browser")
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	@Step("It get the current window's title")
	public String getBrowserTitle() {
		return driver.getTitle();
	}
	public String getCurrentWindowUrl() {
		return driver.getCurrentUrl();
	}
}
