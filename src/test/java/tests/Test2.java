package tests;

import io.qameta.allure.Description;
import page.objects.LoginPage;

import static org.testng.Assert.assertEquals;


public class Test2 extends Testbase {




    @org.testng.annotations.Test
    @Description("two tests are carried out as part of the test, the first sends an email, the second checks whether it has been delivered")

    public void asUserShouldBeAbleToSendAndReceiveAnEmail2() {
        LoginPage page = new LoginPage(driver);

        page.sendLogin();
        page.sendPassword();
        page.clickOnLogInSubmit();
        page.checkEmailOnPage();

    }

}
