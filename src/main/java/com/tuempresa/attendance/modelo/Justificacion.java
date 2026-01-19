package com.tuempresa.attendance.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "JUSTIFICACION")
public class Justificacion {

	@Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "JU_Id", updatable = false, nullable = false)
    @Hidden
    private UUID id;

    @OneToOne(optional = false)
    @JoinColumn(
        name = "JU_IdAsistenciaDetalle",
        referencedColumnName = "AD_Id"
    )
    @Required
    
    private AsistenciaDetalle asistenciaDetalle;

    @Required
    @Column(name = "JU_Motivo", nullable = false)
    private String motivo;

    @Column(name = "JU_Descripcion")
    private String descripcion;

    @Column(name = "JU_FechaRegistro")
    private LocalDate fechaRegistro;

    @Column(name = "JU_Aprobada", nullable = false)
    private boolean aprobada;
}