package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.tuempresa.attendance.utils.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "ESTUDIANTE")
@View(name = "Simple", members = "nombres, apellidos")
public class Estudiante {

    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ES_Id", updatable = false, nullable = false)
    @Hidden
    private UUID id;

    @Hidden
    @Column(name = "ES_Matricula", nullable = false, updatable = false)
    private UUID matricula;

    @Required
    @CedulaEcuatoriana
    @Column(name = "ES_Cedula", length = 10)
    private String cedula;

    @Required
    @Column(name = "ES_Nombres")
    private String nombres;

    @Required
    @Column(name = "ES_Apellidos")
    private String apellidos;

    @Required
    @Pattern(
        regexp = "\\d{7,10}",
        message = "El teléfono debe contener solo números"
    )
    @Column(name = "ES_Telefono")
    private String telefono;

    @Required
    @Email(message = "Correo electrónico inválido")
    @Column(name = "ES_Email")
    private String email;

    @Column(name = "ES_Estado")
    private boolean estado = true;

    @PrePersist
    private void generarMatricula() {
        if (matricula == null) {
            matricula = UUID.randomUUID();
        }
    }
}