package com.steps;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.test.BaseClassAdactinHotel;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
public class  Hooks extends BaseClassAdactinHotel {
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {

		browserLaunch(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));
		maximize();
		implicityWait(10);
	}

	@After
	public void afterScenario(Scenario scenario) {
		
		scenario.embed(screenShot(), "image/png");
		
	    closeCurrentWindow();
	}


}
