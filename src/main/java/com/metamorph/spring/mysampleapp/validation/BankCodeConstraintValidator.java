package com.metamorph.spring.mysampleapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BankCodeConstraintValidator implements ConstraintValidator<BankCode, String> {

    private String bankPrefix;

    @Override
    public void initialize(BankCode bankCode) {
        this.bankPrefix = bankCode.value();
    }

    @Override
    public boolean isValid(String theBankCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if(theBankCode != null) {
            result = theBankCode.startsWith(bankPrefix);
        }
        return result;
    }
}
