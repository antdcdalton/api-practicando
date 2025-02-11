package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class ExtentReportListener {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    static {
        // Configuración del reporte
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/extent-report.html");
        extentSparkReporter.config().setDocumentTitle("Automated Test Report");
        extentSparkReporter.config().setReportName("Cucumber Automation Report");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        extentTest = extentReports.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            extentTest.fail("Test failed due to " + scenario.getName());
        } else {
            extentTest.pass("Test passed: " + scenario.getName());
        }
        extentReports.flush();
    }

}
