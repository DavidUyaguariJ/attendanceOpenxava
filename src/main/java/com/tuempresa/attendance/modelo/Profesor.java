package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;
import javax.ws.rs.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "PROFESOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Tab(properties = "numeroEmpleado, cedula, nombres, apellidos, especialidad, estado")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "PR_Id")
    private Integer id;

    @Column(name = "PR_NumeroEmpleado", length = 20, nullable = false)
    @Required
    private String numeroEmpleado;

    @Column(name = "PR_Cedula", length = 20)
    private String cedula;

    @Column(name = "PR_Nombres", length = 100, nullable = false)
    @Required
    private String nombres;

    @Column(name = "PR_Apellidos", length = 100, nullable = false)
    @Required
    private String apellidos;

    @Column(name = "PR_Especialidad", length = 100)
    private String especialidad;

    @Column(name = "PR_Telefono", length = 20)
    private String telefono;

    @Column(name = "PR_Email", length = 100)
    private String email;

    @Column(name = "PR_FechaContratacion")
    private Date fechaContratacion;

    @Column(name = "PR_Estado", length = 20)
    @DefaultValue("Activo")
    private String estado;
}