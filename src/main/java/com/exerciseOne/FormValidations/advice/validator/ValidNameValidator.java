package com.exerciseOne.FormValidations.advice.validator;

import com.exerciseOne.FormValidations.advice.anotation.ValidName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName, String> {//en los <> se pone el tipo de datos a validar, ejemplo el name es String

    @Override
    public void initialize(ValidName constraintAnnotation) { //recibe una instancia de la interfaz y la pasa a la superclase
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) { //aqui la funcionalidad para el campo name
        //validamos los campos o metodos que estén con esta anotación @ValidName, reglas

        //value cannot be null
        if(value  == null){
            return false;
        }

        //Value cannot be empty
        if(value.isEmpty()){
            return false;
        }

        //value cannot be greater then 15
        if (value.length() > 15){
            return false;
        }

        //value cannot be less then 15
        if (value.length() < 3){
            return false;
        }

        //Value should have the first character in uppercase
        if (!Character.isUpperCase(value.charAt(0))){ //si la 1ra letra no es mayuscula es false
            return false;
        }

        return true;
    }
}