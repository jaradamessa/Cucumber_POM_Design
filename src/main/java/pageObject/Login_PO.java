package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {
    private @FindBy(xpath = "//input[@id='text']")
    WebElement username_TextField;

    private @FindBy(xpath = "//input[@id='password']")
    WebElement password_TextField;

    private @FindBy(xpath = "//button[@id='login-button']")
    WebElement login_Button;


    public Login_PO() {
        super();
    }
    public void navigateTo_WebDriverUniversity_Login_Page() {
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }
    public void setUsername(String username) {
        sendKeys(username_TextField, username);

    }

    public void setPassword(String password) {
        sendKeys(password_TextField, password);

    }

    public void clickOnLogin_Button() {
        waitForWebElementAndClick(login_Button);
    }

    public void validate_SuccessfulLogin_Message(){
        waitForAlert_And_ValidateText("validation succeeded");
    }

    public void validate_UnSuccessfulLogin_Message(){
        waitForAlert_And_ValidateText("validation failed");
    }

}

