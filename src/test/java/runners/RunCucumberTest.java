package runners;  // Asegúrate de que la ubicación del paquete sea correcta, según tu estructura

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome=true,
        features = "src/test/resources/features",  // Ruta donde están los archivos .feature
        glue = "steps",                           // Ruta donde están las clases Step Definitions
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-reports.html","json:target/cucumber-reports/Cucumber.json"}
)
public class RunCucumberTest {
}
