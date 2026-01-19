package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter

@Table(name="CURSO")
public class Curso {

    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false, name="CU_Id")
    @Hidden
    private UUID id;

    @Required
    @Column(name="CU_Codigo", nullable=false, length=30, unique=true)
    private String codigo;

    @Required
    @Column(name="CU_NombreMateria", nullable = false, length = 120)
    private String nombreMateria;

    @Column(name="CU_Descripcion", length = 500)
    private String descripcion;

    @Required
    @Column(name="CU_Horario", nullable = false, length = 60)
    private String horario;

    @Required
    @Column(name="CU_Aula", nullable = false, length = 30)
    private String aula;

    @Required
    @Column(name="CU_CupoMaximo", nullable = false)
    private Integer cupoMaximo;

    @Required
    @Column(name="CU_Creditos", nullable = false)
    private Integer creditos;

    @Required
    @ManyToOne(optional = false)
    @JoinColumn(name = "CU_IdProfesor", referencedColumnName = "PR_Id", nullable = false)
    @ReferenceView("Simple")
    private Profesor profesor;
}
