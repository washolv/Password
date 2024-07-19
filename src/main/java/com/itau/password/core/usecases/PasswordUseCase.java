package com.itau.password.core.usecases;

import com.itau.password.core.ports.Password;
import com.itau.password.core.ports.PasswordRule;
import com.itau.password.core.usecases.passwordrules.DuplicateCharRule;
import com.itau.password.core.usecases.passwordrules.MinLengthRule;
import com.itau.password.core.usecases.passwordrules.SmallLetterRule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PasswordUseCase implements Password {
    private final int MIX_LENGTH = 9;
    private final String SPECIAL_CARACTERS = "!@#$%^&*()-+";

    @Override
    public Boolean validatePassword(String password) {
        boolean hasDuplicateCaracter = false;
        boolean hasSmallLetters = false;
        boolean hasCapitalLetters = false;
        boolean hasSpecialCaracters = false;
        List<Character> passwordCaracters = new ArrayList<>();

        if(password.length() < MIX_LENGTH ){
            return false;
        }

        for (Character c: password.toCharArray()){
            if(Character.isLowerCase(c)){
                hasSmallLetters = true;
            }
            if(Character.isUpperCase(c)){
                hasCapitalLetters = true;
            }
            if(SPECIAL_CARACTERS.indexOf(c) != -1){
                hasSpecialCaracters = true;
            }
            if(passwordCaracters.contains(c)){
                hasDuplicateCaracter = true;
            }
            passwordCaracters.add(c);
        }
        return hasCapitalLetters & hasSpecialCaracters & !hasDuplicateCaracter & hasSmallLetters;
    }
}
