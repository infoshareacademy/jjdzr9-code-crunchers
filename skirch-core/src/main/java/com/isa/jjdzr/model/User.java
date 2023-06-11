package com.isa.jjdzr.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Podaj nazwę użytkownika. Pole nie może pozostać puste")
    @Size(min=3, max=20, message = "Nazwa użytkownika powinna zawierać pomiędzy 3 a 20 znaków")
    @Column(nullable = false)
    private String name;
    @NotNull(message = "Podaj e-mail. Pole nie może pozostać puste")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Podaj prawidłowy adres e-mail")
    @Column(nullable = false)
    private String email;
    @NotNull(message = "Podaj hasło. Pole nie może pozostać puste")
    @Size(min=8, max=20, message = "Hasło powinno zawierać pomiędzy 8 a 20 znaków")
    @Pattern(regexp ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Hasło powinno zawierać " +
            "pomiędzy 8 a 20 znaków, w tym przynajmniej jedną małą literę, wielką literę, cyfrę oraz znak specjalny [#?!@$%^&*-]")
    @Column(nullable = false)
    private String password;

}