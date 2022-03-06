package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.Contact_Us_PO;
import pageObject.Login_PO;

import static driver.DriverFactory.getDriver;


public class Contact_Us_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    private Contact_Us_PO contact_us_po;

    public Contact_Us_Steps(Contact_Us_PO contact_us_po) {
        this.contact_us_po = contact_us_po;
    }

// First Method of entering values
    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
      //driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
        //navigateTo_URL("https://webdriveruniversity.com/Contact-Us/contactus.html");
        contact_us_po.navigate_webDriverUniversity_Contact_Us_Page();

    }
//Values and Names are entered here manually
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Joe"+ generateRandomNumber(3));
        //sendKeys(By.xpath("//input[@placeholder='First Name']"),"Joe"+ generateRandomNumber(3) );
        contact_us_po.setUnique_FirstName();

    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        //driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Blogs"+ generateRandomNumber( 3));
        contact_us_po.setUnique_LastName();

    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
       // driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("AutoEmail"+ generateRandomNumber(3)+"@mail.com");
        contact_us_po.setUnique_EmailAddress();

    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment(){
        //driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys("Welcome!" + generateRandomString(20));
        contact_us_po.setUnique_Comment();

    }

    //Second Method of Steps specific Definition
    //By giving Scenario the VALUE and using VARIABLE on Steps Definition

    @When("I enter a specific first name {word}")//word is used to for single word with no quotation
    public void i_enter_a_specific_first_name_joe(String firstName) {
        //driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
        contact_us_po.setSpecific_FirstName(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name_blogs(String lastName) {
       // driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
        contact_us_po.setSpecific_LastName(lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        //driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(email);
        contact_us_po.setSpecific_EmailAddress(email);
    }
    @When("I enter a specific comment {string}")// with quotation and white space
    public void i_enter_a_specific_comment(String comment) {
        //driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(comment);
        contact_us_po.setSpecific_Comment(comment);

    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        //waitForWebElementAndClick(By.xpath("//input[@value='SUBMIT']"));
        //driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
        contact_us_po.clickOn_Submit_Button();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
//        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//h1[normalize-space()='Thank You for your Message!']"));
//        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
        contact_us_po.validate_Successful_Submission_Text();

    }

}



