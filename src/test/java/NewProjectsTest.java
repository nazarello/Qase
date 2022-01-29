import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewProjectsTest extends BaseTest {

    @Test(description = "Create new projects")
    public void createNewProjects() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password);
        $("#btnLogin").click();

        $("#createButton").click();
        $("#inputTitle").sendKeys("Qase");
        $("#inputDescription").sendKeys("Testing qase.io");
        $("#private-access-type").shouldBe(Condition.selected);
        $("#accessNone").click();
        $("#accessNone").shouldBe(Condition.selected);
        $(By.xpath("//button[text()='Create project']")).click();

        $(By.id("create-suite-button")).shouldBe(Condition.visible, Duration.ofSeconds(100));
    }
}