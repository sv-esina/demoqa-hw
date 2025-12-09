package pages.tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.TestBase;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest(){

        textBoxPage.openPage()
                .removeBanners()
                .setUserName("Svetlana")
                .setUserEmail("monte@gmail.com")
                .currentAddress("Some address 1")
                .permanentAddress("Some address 2")
                .clickSubmit()
                .checkOutputResult("Name:", "Svetlana")
                .checkOutputResult("Email:", "monte@gmail.com")
                .checkOutputResult("Current Address :", "Some address 1")
                .checkOutputResult("Permananet Address :","Some address 2");

    }
}
