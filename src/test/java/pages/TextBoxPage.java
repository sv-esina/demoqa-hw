package pages;

import com.codeborne.selenide.SelenideElement;
import pages.Components.OutputTextBox;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit");

    OutputTextBox outputTextBox = new OutputTextBox();

    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }


    public TextBoxPage currentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public TextBoxPage permanentAddress(String value) {
        permanentAddress.setValue(value);

        return this;
    }

    public TextBoxPage clickSubmit() {
        submit.click();

        return this;
    }

    public TextBoxPage checkOutputResult(String key, String value) {
        outputTextBox.setOutputData(key, value);

        return this;
    }
}
