package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(
    name = "INSCRIPCION",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "UK_INS_EST_CUR",
            columnNames = {"IN_IdEstudiante", "IN_IdCurso"}
        )
    }
)
public class Inscripcion {

    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "IN_Id", updatable = false, nullable = false)
    @Hidden
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "IN_IdEstudiante",
        referencedColumnName = "ES_Id"
    )
    @Required
    private Estudiante estudiante;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "IN_IdCurso",
        referencedColumnName = "CU_Id"
    )
    @Required
    private Curso curso;
}