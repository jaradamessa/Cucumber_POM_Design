package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Contact_Us_PO extends Base_PO {
    private @FindBy(how = How.XPATH, using = "//input[@placeholder='First Name']")
    WebElement firstName_TextField;

    private @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName_TextField;

    private @FindBy(xpath = "//input[@placeholder='Email Address']")
    WebElement emailAddress_TextField;

    private @FindBy(xpath = "//textarea[@placeholder='Comments']")
    WebElement comment_TextField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submit_Button;

    private @FindBy(xpath = "//h1[normalize-space()='Thank You for your Message!']")
    WebElement successfulSubmission_Message_Text;

    public Contact_Us_PO(){
        super();
    }

    public void navigate_webDriverUniversity_Contact_Us_Page() {
        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
       public void setUnique_FirstName() {
           sendKeys(firstName_TextField, "Joe" + generateRandomNumber(3));
       }

    public void setUnique_LastName() {
        sendKeys(lastName_TextField, "Blogs" + generateRandomNumber(3));

    }

    public void setUnique_EmailAddress() {
        sendKeys(emailAddress_TextField, ("AutoEmail"+ generateRandomNumber(3)+"@mail.com"));

    }

    public void setUnique_Comment() {
        sendKeys(comment_TextField, "Welcome!" + generateRandomString(10));

    }

    public void setSpecific_FirstName(String firstName) {
        sendKeys(firstName_TextField, firstName);
    }

    public void setSpecific_LastName(String lastName) {
        sendKeys(lastName_TextField, lastName);
    }

    public void setSpecific_EmailAddress(String emailAddress) {
        sendKeys(emailAddress_TextField, emailAddress);

    }

    public void setSpecific_Comment(String comment) {
        sendKeys(comment_TextField, comment);
    }

    public void clickOn_Submit_Button(){
        waitForWebElementAndClick(submit_Button);

    }

    public void validate_Successful_Submission_Text(){
        waitFor(successfulSubmission_Message_Text);
        Assert.assertEquals(successfulSubmission_Message_Text.getText(), "Thank You for your Message!" );

    }
}
