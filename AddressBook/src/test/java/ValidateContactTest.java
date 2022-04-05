import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateContactTest {

    ValidateContact validateContact = null;

    @BeforeEach
    void setUp() {
        validateContact = new ValidateContact();
    }

    @Test
    void givenFirstName_WhenValidate_ShouldReturnTrue() {
        assertEquals(true, validateContact.validateName("Sreenath"));
    }

    @Test
    void givenLastName_WhenValidate_ShouldReturnTrue() {
        assertEquals(true, validateContact.validateName("Emidi"));
    }

    @Test
    void givenAddress_WhenValidate_ShouldReturnTrue() {
        assertEquals(true, validateContact.validateAddress("Hanuman Nagar"));
    }

    @Test
    void givenCity_WhenValidate_ShouldReturnTrue() {
        assertEquals(true, validateContact.validateCity("Adoni"));
    }

    @Test
    void givenState_WhenValidate_ShouldReturnTrue() {
        assertEquals(true, validateContact.validateState("Andhra Pradesh"));
    }

    @Test
    void givenEmail_WhenValidate_ShouldReturnTrue() {
        assertEquals(true, validateContact.validateEmail("sreeanth@gmail.com"));
    }

    @Test
    void givenZipCode_WhenValidate_ShouldReturnTrue() {
        assertEquals(true, validateContact.validateZipCode("518301"));
    }

    @Test
    void givenPhoneNumber_WhenValidate_ShouldReturnTrue() {
        assertEquals(true, validateContact.validatePhoneNumber("91 9988776655"));
    }
}