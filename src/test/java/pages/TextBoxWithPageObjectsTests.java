package pages;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxWithPageObjectsTests extends TestBase  {

    @Test
    void fillFormTest(){
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#userName").setValue("Svetlana");
        $("#userEmail").setValue("montesum1@gmail.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Some address 2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Svetlana"));
        $("#output #email").shouldHave(text("montesum1@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Some address 1"));
        $("#output #permanentAddress").shouldHave(text("Some address 2"));
        sleep(3000);
    }
}
