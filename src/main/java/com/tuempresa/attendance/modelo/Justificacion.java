package com.tuempresa.attendance.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Justificacion {

	@Id
	@GeneratedValue(generator = "UUID")
	@org.hibernate.annotations.GenericGenerator(
	        name = "UUID",
	        strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(updatable = false, nullable = false)
	@Hidden
    private UUID id;

    @OneToOne
    @Required
    private AsistenciaDetalle asistenciaDetalle;

    @Required
    private String motivo;

    private String descripcion;

    private LocalDate fechaRegistro;

    private boolean aprobada;
}