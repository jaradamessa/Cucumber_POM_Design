package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.Login_PO;

import static driver.DriverFactory.getDriver;


public class Login_Steps extends Base_PO {
    private  WebDriver driver = getDriver();

    private Login_PO login_po;

    public Login_Steps(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        login_po.navigateTo_WebDriverUniversity_Login_Page();
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        //driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
        //sendKeys(By.xpath("//input[@id='text']"),username);
        login_po.setUsername(username);
    }


    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        login_po.setPassword(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        //driver.findElement(By.xpath("//button[@id='login-button']")).click();
        login_po.clickOnLogin_Button();
    }

    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() {
        //String login_message = driver.switchTo().alert().getText();
        //Assert.assertEquals(login_message,"validation succeeded");
        login_po.validate_SuccessfulLogin_Message();
    }

    @Then("I should be presented with unsuccessful login message")
    public void i_should_be_presented_with_unsuccessful_login_message() {
        //String login_message = driver.switchTo().alert().getText();
        //Assert.assertEquals(login_message,"validation failed");
        login_po.validate_UnSuccessfulLogin_Message();
    }
    //Specific Message
    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
//        String login_message = driver.switchTo().alert().getText();
//        Assert.assertEquals(login_message, expectedMessage);
        waitForAlert_And_ValidateText(expectedMessage);
    }


}
