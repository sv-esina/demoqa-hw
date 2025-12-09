package pages.tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.TestBase;

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

    @Test
    void minRegistrationTest() {

        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Svetlana")
                .setLastName("Esina")
                .setGender("Female")
                .setUserNumber("9991234567")
                .setBirthDate("04", "December", "1990")
                .clickSubmit()
                .checkResultTable("Student Name", "Svetlana Esina")
                .checkResultTable("Gender", "Female")
                .checkResultTable("Date of Birth", "04 December,1990")
                .closeTable();
    }

    @Test
    void negativeRegistrationTest() {

        // Проверка кол-ва символов в поле UserNumber (Mobile(10 Digits))
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Svetlana")
                .setLastName("Esina")
                .setGender("Female")
                .setUserNumber("2334455")
                .setBirthDate("04", "December", "1990")
                .clickSubmit()
                .checkResultTable("Student Name", "Svetlana Esina");
    }
}

