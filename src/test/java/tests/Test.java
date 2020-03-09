package tests;

import io.qameta.allure.Description;
import page.objects.LoginPage;

import static org.testng.Assert.assertEquals;


public class Test extends Testbase {




@Description("two tests are carried out as part of the test, the first sends an email, the second checks whether it has been delivered")
@org.testng.annotations.Test

public void asUserShouldBeAbleToSendAndReceiveAnEmail() {
    LoginPage page = new LoginPage(driver);

    page.sendLogin();
    page.sendPassword();
    page.clickOnLogInSubmit();
    page.clickOnButtonCreateNewEmail();
    page.sendAddresseeEmail();
    page.sendMessageSubject();
    page.sendMessageContent();
    page.clickOnSendEmailButton();
    page.checkEmailOnPage();

}

}
