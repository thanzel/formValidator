package com.exerciseOne.FormValidations.controller.dto;

import com.exerciseOne.FormValidations.advice.anotation.ValidName;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    //@NotNull(message = "El campo nombre no puede ser null") //Esto sería un msg personalizado que aparecería en el response, si no se pone aparece el msg por defecto en la exception
    @ValidName //anotacion personalizada que cree en pkg anotatio
    private String name;

    //@NotNull
    @ValidName //anotacion personalizada que cree en pkg anotatio
    @Size(min = 3, max = 10) //acepta min 3 caracteres y max 10 caracteres
    private String lastName;

    @NotBlank //no puede estar en blanco ni con espacios ni null
   // @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "El correo no es válido")//(el cod es ejemplo no es el real) es una expresión regular
    @Email //reemplaza el @Pattern
    private String email;

    //@CreditCardNumber //valida nros de TDC, para app bancarias, usa ese algoritmo, para long y string
    private Long phone;

    @Min(18) //igual o mayor a 18 como mínimo
    @Max(80) //igual o menor a 80
    private byte age;

    @Digits(integer = 2, fraction = 3) //es para validar double, parte entera de 2 digitos y luego parte decimal de 3 digitos
    private double height;

    @AssertTrue //obliga a que sea true
    //@AssertFalse //obliga a que sea false
    private boolean married;

    @Past //valida que la fecha sea anterior a la actual
   // @Future //valida que la fecha sea posterior a la actual
    private LocalDate dateOfBirth;

    @Valid
    private DepartmentDTO departmentDTO; //para validar objetos anidados

    /*
    @NotEmpty //es para las listas para que no se graben vacías
    List<Integer> numbers;
    */

}
