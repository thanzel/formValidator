package com.exerciseOne.FormValidations.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Validated //se pone @Valid en el DTO donde se hace ref y aqui se pone esto
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 3, max = 10)
    private String city;
}
