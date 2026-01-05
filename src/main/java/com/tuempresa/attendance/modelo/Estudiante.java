package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name="ESTUDIANTE")
@View(name = "Simple", members = "nombres, apellidos")
public class Estudiante {

    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="ES_Id", updatable = false, nullable = false)
    @Hidden
    private UUID id;

    @Hidden
    @Column(name = "ES_Matricula", nullable = false, updatable = false)
    private UUID matricula;

    @Column(name="ES_Cedula")
    private String cedula;

    @Column(name="ES_Nombres")
    private String nombres;

    @Column(name="ES_Apellidos")
    private String apellidos;

    @Column(name="ES_Telefono")
    private String telefono;

    @Column(name="ES_Email")
    private String email;

    @Column(name="ES_Estado")
    private boolean estado = true;

    @PrePersist
    private void generarMatricula() {
        if (matricula == null) {
            matricula = UUID.randomUUID();
        }
    }
}