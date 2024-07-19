package com.itau.password.controller;

import com.itau.password.adapters.controller.PasswordController;
import com.itau.password.core.ports.Password;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest(PasswordController.class)
public class ValidatorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    Password passwordPort;

    @Test
    void shouldReturnValidPassword() throws Exception {
        when(passwordPort.validatePassword("AbTp9!fok")).thenReturn(true);
        this.callPasswordValidator("AbTp9!fok").
                andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value(true));
    }

    @Test
    void shouldReturnInvalidPassword() throws Exception {
        this.callPasswordValidator("aa").
                andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value(false));
    }

    ResultActions callPasswordValidator(String password) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post("/validate").content(
                password
        ));
    }

}
