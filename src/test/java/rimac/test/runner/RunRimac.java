package rimac.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/site/result.json"},
        features = "src/test/resources/features/",
        glue = "rimac.test.stepsdefinition",
        // @Scenario9y10 xx , @Scenario14y15 , @Scenario17y18 , @Scenario22
        tags = "@Scenario05",
        snippets = SnippetType.CAMELCASE
)

public class RunRimac {

}