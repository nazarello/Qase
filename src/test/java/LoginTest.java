import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test (description = "User add login and password for an authorisation")
    public void login() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password);
        $("#btnLogin").click();
        $(By.id("createButton")).shouldBe(visible);
    }

//    @Test
//    public void login2() {
//        open("login ");
//        $("#inputEmail").sendKeys(email);
//        $(By.xpath("//*[@id='inputPassword']")).setValue(password);
//        $("#btnLogin").click();
//        $(By.id("createButton")).shouldBe(visible);
//    }
}
