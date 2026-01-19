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
@Table(name="PROFESOR")
@View(name = "Simple", members = "nombres, apellidos, especialidad")
public class Profesor {

    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="PR_Id", updatable = false, nullable = false)
    @Hidden
    private UUID id;

    @Hidden
    @Column(
        name = "PR_NumeroEmpleado",
        nullable = false,
        updatable = false
    )
    private UUID numeroEmpleado;

    @Required
    @CedulaEcuatoriana
    @Column(name="PR_Cedula")
    private String cedula;

    @Required
    @Column(name="PR_Nombres")
    private String nombres;

    @Required
    @Column(name="PR_Apellidos")
    private String apellidos;

    @Required
    @Column(name="PR_Especialidad")
    private String especialidad;

    @Required
    @Pattern(
        regexp = "\\d{7,10}",
        message = "El teléfono debe contener solo números"
    )
    @Column(name = "PR_Telefono")
    private String telefono;

    @Required
    @Email(message = "Correo electrónico inválido")
    @Column(name = "PR_Email")
    private String email;

    @Column(name="PR_Estado")
    private boolean estado = true;

    @PrePersist
    private void generarNumeroEmpleado() {
        if (numeroEmpleado == null) {
            numeroEmpleado = UUID.randomUUID();
        }
    }
}