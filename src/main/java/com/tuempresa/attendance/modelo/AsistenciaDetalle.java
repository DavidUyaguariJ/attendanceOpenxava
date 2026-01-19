package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "ASISTENCIA_DETALLE")

public class AsistenciaDetalle {

    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "AD_Id", updatable = false, nullable = false)
    @Hidden
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "AD_IdAsistencia",
        referencedColumnName = "AS_Id"
    )
    private Asistencia asistencia;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "AD_IdEstudiante",
        referencedColumnName = "ES_Id"
    )
    private Estudiante estudiante;

    @Column(name = "AD_Asistio", nullable = false)
    private boolean asistio;
}