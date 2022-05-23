package com.Runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
features="Features",
glue={"com.StepDefinition"},
plugin={"html:target/cucumber-html-report",
		"json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt",
		"usage:target/cucumber-usage.json", 
		"junit:target/cucumber-results.xml"},
dryRun = false,
monochrome = true)

public class UniversalClassRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	 
	 public static WebDriver connection;
	 
	 @BeforeClass(alwaysRun = true)
	 public void setUpCucumber() {
	 testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	 }
	 
	 @BeforeMethod(alwaysRun = true)
	 public void setUpClass() throws Exception {
	}
	 
	 
	 @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "Scenarios")
	 public void Scenario(PickleWrapper pickle,FeatureWrapper cucumberFeature) {
	 testNGCucumberRunner.runScenario(pickle.getPickle());
	 }
	 
	 @DataProvider
	 public Object[][] Scenarios() {
	 return testNGCucumberRunner.provideScenarios();
	 }
	 
	 @AfterClass(alwaysRun = true)
	 public void tearDownClass() throws Exception {
	 testNGCucumberRunner.finish();
	 }
}
