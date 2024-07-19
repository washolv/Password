package com.itau.password.usecases;

import com.itau.password.core.usecases.PasswordUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PasswordUseCaseTest {
    @InjectMocks
    private PasswordUseCase passwordUseCase;

    @Test
    void shouldReturnTrueWhenPasswordIsValid(){
        Boolean response = passwordUseCase.validatePassword("AbTp9!fok");
        assertEquals("Valid", true, response);
    }

    @Test
    void shouldReturnFalseWhenPasswordNotHaveMinLength(){
        Boolean response = passwordUseCase.validatePassword("AbTp9!fo");
        assertEquals("Invalid", false, response);
    }

    @Test
    void shouldInvalidateWhenPasswordIsWithoutSmallLetters(){
        Boolean response = passwordUseCase.validatePassword("ABTP9!FOK");
        assertEquals("Invalid", false, response );
    }

    @Test
    void shouldInvalidateWhenPasswordIsWithoutCapitalLetters(){
        Boolean response = passwordUseCase.validatePassword("abtp9!fok");
        assertEquals("Invalid", false, response );
    }

    @Test
    void shouldInvalidateWhenPasswordIsWithoutSpecialChars(){
        Boolean response = passwordUseCase.validatePassword("AbTp9 fok");
        assertEquals("Invalid", false, response);
    }

}
