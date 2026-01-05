package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
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
    @Column(name="CU_Codigo")
    private String codigo;
    @Column(name="CU_NombreMateria")
    private String nombreMateria;
    @Column(name="CU_Descripcion")
    private String descripcion;
    @Column(name="CU_Horario")
    private String horario;
    @Column(name="CU_Aula")
    private String aula;
    @Column(name="CU_CupoMaximo")
    private Integer cupoMaximo;
    @Column(name="CU_Creditos")
    private Integer creditos;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "CU_IdProfesor",
        referencedColumnName = "PR_Id"
    )
    @Required
    @ReferenceView("Simple")
    private Profesor profesor;
}