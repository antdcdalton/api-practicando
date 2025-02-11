package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class Hooks {

    private ExtentReportListener extentReportListener = new ExtentReportListener();

    @Before
    public void setUp(Scenario scenario) {
        // Inicializa el reporte antes de cada escenario
        extentReportListener.beforeScenario(scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        // Finaliza el reporte después de cada escenario
        extentReportListener.afterScenario(scenario);
    }
}
