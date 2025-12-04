import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // ввод фио и email
        $("#firstName").setValue("Svetlana");
        $("#lastName").setValue("Esina");
        $("#userEmail").setValue("monte@gmail.com");

        // выбор чек-бокса gender
        $("[for='gender-radio-2']").click();

        //ввод номера телефона
        $("#userNumber").setValue("9991234567");

        // ввод даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("December")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month").$(byText("4")).click();

        // выбор предмета
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        //выбор хобби
        $("[for='hobbies-checkbox-3']").click();

        //загрузка картинки
        $("#uploadPicture").uploadFromClasspath("image1.png");

        //ввод адреса
        $("#currentAddress").setValue("Some Address");

        //выбор региона
        $("#stateCity-wrapper").scrollTo();
        $("#state").click();
        $(".css-26l3qy-menu").$(byText("NCR")).click();

        //выбор города
        $("#city").click();
        $(".css-26l3qy-menu").$(byText("Delhi")).click();
        $("#submit").click();

        // проверка введенных значений
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Svetlana Esina"));
        $(".table-responsive").shouldHave(text("monte@gmail.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("9991234567"));
        $(".table-responsive").shouldHave(text("04 December,1990"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("image1.png"));
        $(".table-responsive").shouldHave(text("Some Address"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

        //закрываем окно с таблицей
        $("#closeLargeModal").click();
        sleep(3000);
    }
}
