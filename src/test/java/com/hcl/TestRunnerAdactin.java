package com.hcl;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome=true,plugin= {"html:report/Webreport","json:report/jsonreport.json",
		"junit:report/xmlreport.xml"},
name="User should login the page using the data given by client",
features="src\\test\\resources\\Featurefile\\LoginAdactinHotel.feature",glue= "com.method")

public class TestRunnerAdactin {

	
	
	
	
}
