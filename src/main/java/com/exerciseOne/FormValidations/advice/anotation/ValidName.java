package com.exerciseOne.FormValidations.advice.anotation;

import com.exerciseOne.FormValidations.advice.validator.ValidNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
//CON ESTO CREO UNA NUEVA ANOTACIÓN PARA VALIDAR CAMPOS NAME PERSONALIZADA
@Documented //metadata de spring para el javadoc
@Constraint(validatedBy = ValidNameValidator.class )
@Retention(RetentionPolicy.RUNTIME) //cuando se ejecute la app se creará esta anotación
@Target({ElementType.FIELD, ElementType.METHOD}) //se puede usar esta anotación en campos y métodos
public @interface ValidName {
    //estos 3 métodos los copié de la anotación @NotBlank y le cambié el default por mi propertie messages.properties
    String message() default "{custom.validation.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
