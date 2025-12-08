package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;
import javax.ws.rs.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "ESTUDIANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Tab(properties = "matricula, cedula, nombres, apellidos, grado, grupo, estado")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "ES_Id")
    private Integer id;

    @Column(name = "ES_Matricula", length = 20, nullable = false)
    @Required
    private String matricula;

    @Column(name = "ES_Cedula", length = 20)
    private String cedula;

    @Column(name = "ES_Nombres", length = 100, nullable = false)
    @Required
    private String nombres;

    @Column(name = "ES_Apellidos", length = 100, nullable = false)
    @Required
    private String apellidos;

    @Column(name = "ES_FechaNacimiento")
    private Date fechaNacimiento;

    @Column(name = "ES_Genero", length = 20)
    private String genero;

    @Column(name = "ES_Telefono", length = 20)
    private String telefono;

    @Column(name = "ES_Email", length = 100)
    private String email;

    @Column(name = "ES_Direccion", length = 255)
    @Stereotype("MEMO")
    private String direccion;

    @Column(name = "ES_Grado", length = 50)
    private String grado;

    @Column(name = "ES_Grupo", length = 10)
    private String grupo;

    @Column(name = "ES_Estado", length = 20)
    @DefaultValue("Activo")
    private String estado;
}