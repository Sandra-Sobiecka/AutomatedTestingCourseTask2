package zadanie2;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class RegisterUser {
    private WebDriver driver;
    @Given("^an open https://tester\\.codersguru\\.pl website$")
    public void anOpenCodersguruWebsite() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tester.codersguru.pl/");


    }

    @When("^click zaloz konto$")
    public void clickZalozKonto() {
        WebElement registration = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[1]"));
        registration.click();

    }

    @And("^type in user inputs \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\",\"([^\"]*)\"\"([^\"]*)\" \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void typeInUserInputs(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) {
        driver.findElement(By.id("fos_user_registration_form_email")).clear();
        driver.findElement(By.id("fos_user_registration_form_email")).sendKeys(arg0);

        driver.findElement(By.id("fos_user_registration_form_name")).clear();
        driver.findElement(By.id("fos_user_registration_form_name")).sendKeys(arg1);

        driver.findElement(By.id("fos_user_registration_form_lastname")).clear();
        driver.findElement(By.id("fos_user_registration_form_lastname")).sendKeys(arg2);

        driver.findElement(By.id("fos_user_registration_form_plainPassword_first")).clear();
        driver.findElement(By.id("fos_user_registration_form_plainPassword_first")).sendKeys(arg3);

        driver.findElement(By.id("fos_user_registration_form_plainPassword_second")).clear();
        driver.findElement(By.id("fos_user_registration_form_plainPassword_second")).sendKeys(arg3);

        driver.findElement(By.id("form_city")).clear();
        driver.findElement(By.id("form_city")).sendKeys(arg4);

        driver.findElement(By.id("form_postal_code")).clear();
        driver.findElement(By.id("form_postal_code")).sendKeys(arg5);

        driver.findElement(By.id("form_street")).clear();
        driver.findElement(By.id("form_street")).sendKeys(arg6);

        driver.findElement(By.id("form_number")).clear();
        driver.findElement(By.name("form_number")).sendKeys(arg7);
    }


    @And("^click checkbox$")
    public void clickCheckbox() {
        WebElement agreeRegulations = driver.findElement(By.xpath("/html/body/div/div/div/form/div[12]/input"));
        List<WebElement> checkboxElements = agreeRegulations.findElements(By.xpath("/html/body/div/div/div/form/div[12]/input"));
        checkboxElements.get(0).click();
    }

    @And("^click Zarestruj  button$")
    public void clickZarestrujButton() {
        WebElement button = driver.findElement(By.id("register-submit-btn"));
        button.click();
    }

    @Then("^should be registered on website$")
    public void amIRegistered() {
        String programmerHelp = driver.findElement(By.className("main-page-top_headerheader")).getText();
        Assert.assertTrue(programmerHelp.contains("Pomoc w problemach programistycznych"));
    }
}


