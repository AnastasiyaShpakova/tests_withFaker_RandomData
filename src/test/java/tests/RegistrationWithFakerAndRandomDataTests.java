package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utils.RandomTestData;

import java.util.Locale;

public class RegistrationWithFakerAndRandomDataTests extends TestBase {

    Faker faker = new Faker(new Locale("en-GB"));

    RandomTestData testData = new RandomTestData();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String eMail = faker.internet().emailAddress();
    String phoneNumber = faker.numerify("##########");
    String birthDay = String.valueOf(faker.number().numberBetween(1, 28));
    String birthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    String birthYear = String.valueOf(faker.number().numberBetween(1901, 2020));

    String address = faker.address().streetAddress();
    String gender = testData.getRandomGender();
    String hobby = testData.getRandomHobby();
    String fileName = testData.getRandomPicture();
    String subject = testData.getRandomSubject();

    private String state = testData.state();
    private String city = testData.city(state);


    @Test
    void successfulFillAllFieldsRegTest() {
        registration
                .openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(eMail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        registration.checkTitleResultTable()
                .checkValuesResultTable(firstName + " " + lastName)
                .checkValuesResultTable(eMail)
                .checkValuesResultTable(gender)
                .checkValuesResultTable(phoneNumber)
                .checkValuesResultTable(birthDay + " " + birthMonth + "," + birthYear)
                .checkValuesResultTable(subject)
                .checkValuesResultTable(hobby)
                .checkValuesResultTable(fileName)
                .checkValuesResultTable(address)
                .checkValuesResultTable(state + " " + city)
                .closeResultTable();
    }

    @Test
    void successfulFillRequiredFieldsRegTest() {
        registration
                .openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(eMail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setAddress(address)
                .clickSubmitButton();

        registration.checkTitleResultTable()
                .checkValuesResultTable(firstName + " " + lastName)
                .checkValuesResultTable(eMail)
                .checkValuesResultTable(gender)
                .checkValuesResultTable(phoneNumber)
                .checkValuesResultTable(address)
                .closeResultTable()
                .checkHiddenResultTable();

    }

    @Test
    void negativeNotFillRequiredFieldsRegTest() {
        registration
                .openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .clickSubmitButton();

        registration.checkHiddenResultTable();

    }

}
