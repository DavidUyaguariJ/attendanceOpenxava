package com.tuempresa.attendance.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(
    name = "ASISTENCIA",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "UK_AS_CURSO_FECHA",
            columnNames = {"AS_IdCurso", "AS_Fecha"}
        )
    }
)
public class Asistencia {

    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "AS_Id", updatable = false, nullable = false)
    @Hidden
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "AS_IdCurso",
        referencedColumnName = "CU_Id"
    )
    @Required
    private Curso curso;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "AS_IdProfesor",
        referencedColumnName = "PR_Id"
    )
    @Required
    private Profesor profesor;

    @Column(name = "AS_Fecha", nullable = false)
    @Required
    private LocalDate fecha;

    @OneToMany(
        mappedBy = "asistencia",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @ListProperties("estudiante.nombres, estudiante.apellidos, asistio")
    private List<AsistenciaDetalle> detalles;
}