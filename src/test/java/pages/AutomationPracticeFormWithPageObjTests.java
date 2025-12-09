package pages;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormWithPageObjTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();


    @Test
    void successfulRegistrationTest(){

        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Svetlana")
                .setLastName("Esina")
                .setEmail("monte@gmail.com")
                .setGender("Female")
                .setUserNumber("9991234567")
                .setBirthDate("04", "December", "1990")
                .setSubjects("Computer Science")
                .setHobbies("Music")
                .uploadPicture("image1.png")
                .currentAddress("Some Address")
                .scroll()
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit()
                .checkResultTable("Student Name", "Svetlana Esina")
                .checkResultTable("Student Email", "monte@gmail.com")
                .checkResultTable("Gender", "Female")
                .checkResultTable("Mobile", "9991234567")
                .checkResultTable("Date of Birth", "04 December,1990")
                .checkResultTable("Subjects", "Computer Science")
                .checkResultTable("Hobbies", "Music")
                .checkResultTable("Picture", "image1.png")
                .checkResultTable("Address", "Some Address")
                .checkResultTable("State and City", "NCR Delhi")
                .closeTable();
    }
}
