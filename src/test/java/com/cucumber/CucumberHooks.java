package com.cucumber;

import com.test.BaseClassAdactinHotel;

import cucumber.api.java.Before;

public class CucumberHooks extends BaseClassAdactinHotel {


	@Before
	public void beforeScenario() {
		getdriver();
		getUrl("https://www.facebook.com/");
		System.out.println("====before scenario====");
		/*browserLaunch(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));
		maximize();
		implicityWait(10);
		 */	}

	//	@After
	//	public void afterScenario(Scenario scenario) {
	//		
	//		//scenario.attach(screenShot(), "Image/png", "EveryScenario");
	//		
	//	    closeCurrentWindow();
	//	}


	/*	@Before
	public void beforeScenario() {

		getdriver();
		getUrl("https://www.facebook.com/");
		System.out.println("=====before scenario===");
	}
	@After
	public void afterscenario() {
		System.out.println("====afterscenario====");
		driver.close();

	}
	 *///	@After
	//	public void takeScreenShotOnFailure(Scenario scenario) {
	//		if (scenario.isFailed()) {
	//			TakesScreenshot ts = (TakesScreenshot) driver;
	//			System.out.println("scenario failed");
	//			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
	//			scenario.attach(src,"image/png","Screenshot");
	//
	//		}
	//		@After
	//		public void afterScenario(Scenario scenario) {
	//			if (scenario.isFailed()) {
	//			scenario.attach(screenShot(), "Image/png","Screenshot");
	//			}
	//		    closeCurrentWindow();
	//		}


}
















