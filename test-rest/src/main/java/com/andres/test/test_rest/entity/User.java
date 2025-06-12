package com.andres.test.test_rest.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    // private static final long serialVersionUID = 4748683405611798828L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo nombre es obligatorio")
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank(message = "El campo Apellido Paterno es obligatorio")
    @Size(min = 3, max = 50)
    private String firstName;

    private String lastName;
    
    @NotBlank(message = "El campo email es obligatorio")
    private String email;

    private Integer age;

    @NotBlank(message = "El campo password es obligatorio")
    private String password;

    private LocalDateTime created;

    @Version
    private Integer version;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

}
