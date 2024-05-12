package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources"},
        glue = {"org.example"},
        plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html", "json:cucumber.json"}
)
public class TestRunner {
}
