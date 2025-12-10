package pages.tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.TestBase;
import static pages.tests.TestData.*;

public class PracticeFormWithTestData extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();


    @Test
    void successfulRegistrationTest(){

        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumberSuccess)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbie)
                .uploadPicture(image)
                .currentAddress(curAddress)
                .scroll()
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .checkResultTable("Student Name", studentName)
                .checkResultTable("Student Email", userEmail)
                .checkResultTable("Gender", gender)
                .checkResultTable("Mobile", userNumberSuccess)
                .checkResultTable("Date of Birth", birthday)
                .checkResultTable("Subjects", subject)
                .checkResultTable("Hobbies", hobbie)
                .checkResultTable("Picture", image)
                .checkResultTable("Address", curAddress)
                .checkResultTable("State and City", stateAndCity)
                .closeTable();
    }

    @Test
    void minRegistrationTest() {

        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumberSuccess)
                .setBirthDate(day, month, year)
                .clickSubmit()
                .checkResultTable("Student Name", studentName)
                .checkResultTable("Gender", gender)
                .checkResultTable("Date of Birth", birthday)
                .closeTable();
    }

    @Test
    void negativeRegistrationTest() {

        // Проверка кол-ва символов в поле UserNumber (Mobile(10 Digits))
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumberNegative)
                .setBirthDate(day, month, year)
                .clickSubmit()
                .checkResultTable("Student Name", studentName);
    }
}

