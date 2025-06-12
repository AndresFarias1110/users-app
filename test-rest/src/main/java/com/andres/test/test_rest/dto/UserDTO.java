package com.andres.test.test_rest.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private int id;
    @NotNull(message = "El campo nombre no puede ir vacío")
    @NotBlank(message = "El campo nombre no puede ir vacío")
    @Size(min = 3, max = 50)
    private String name;
    
    @NotNull(message = "El campo primer apellido no puede ir vacío")
    @NotBlank(message = "El campo primer apellido no puede ir vacío")
    @Size(min = 3, max = 25)
    private String firstName;
    
    private String lastName;
    
    @NotBlank(message = "El campo password es obligatorio")
    private String password;

    @NotNull(message = "El campo correo no puede ir vacío")
    @NotBlank(message = "El campo correo no puede ir vacío")
    @Pattern(
        regexp =  "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$",
        message = "El campo correo no tiene el formato de correo"
    )
    private String email;

    @NotNull(message = "El campo primer apellido no puede ir vacío")
    private Integer age;
    private LocalDateTime created;
}
