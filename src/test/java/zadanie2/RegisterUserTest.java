package zadanie2;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/RegisterUser.Feature",
        plugin = {"pretty", "html:out"})

public class RegisterUserTest {
}
