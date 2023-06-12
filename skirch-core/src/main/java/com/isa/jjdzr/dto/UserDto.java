package com.isa.jjdzr.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    @NotBlank(message = "Podaj nazwę użytkownika. Pole nie może pozostać puste")
    @NotNull(message = "Podaj nazwę użytkownika. Pole nie może pozostać puste")
    @Size(min = 3, max = 20, message = "Nazwa użytkownika powinna zawierać pomiędzy 3 a 20 znaków")
    private String name;
    @NotBlank(message = "Podaj e-mail. Pole nie może pozostać puste")
    @NotNull(message = "Podaj e-mail. Pole nie może pozostać puste")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Podaj prawidłowy adres e-mail")
    private String email;
    @NotBlank(message = "Podaj hasło. Pole nie może pozostać puste")
    @NotNull(message = "Podaj hasło. Pole nie może pozostać puste")
    @Size(min = 8, max = 20, message = "Hasło powinno zawierać pomiędzy 8 a 20 znaków")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Hasło powinno zawierać " +
            "pomiędzy 8 a 20 znaków, w tym przynajmniej jedną małą literę, wielką literę, cyfrę oraz znak specjalny [#?!@$%^&*-]")
    private String password;
}