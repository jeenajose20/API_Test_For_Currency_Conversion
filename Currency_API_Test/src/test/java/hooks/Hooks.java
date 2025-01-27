package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ExtentReportManager;

public class Hooks {

	@Before
	public void beforeScenario() {
		ExtentReportManager.initializeReport();
	}

	@After
	public void afterScenario() {
		ExtentReportManager.flushReport();
	}
}
