package com.testrunner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;
import com.test.BaseClassAdactinHotel;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,monochrome = true,plugin = {"pretty","json:target\\index.json"},
features = "src\\test\\resources",glue = {"com.steps"})


public class TestRunnerAdactinHotel extends BaseClassAdactinHotel {
	@AfterClass
	public static void afterClass() throws IOException {
		Reporting.generateJvmReport(getProjectPath()+getPropertyFileValue("jsonPath"));
	}

}
