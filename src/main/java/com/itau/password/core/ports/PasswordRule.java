package com.itau.password.core.ports;

public interface PasswordRule {
    boolean validateRule(String password);
}
