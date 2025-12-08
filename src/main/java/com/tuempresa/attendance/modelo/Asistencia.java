package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "ASISTENCIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Tab(properties =
    "inscripcion.estudiante.nombres, inscripcion.curso.codigo, fecha, estado")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "AS_Id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AS_IdInscripcion", nullable = false)
    @Required
    private Inscripcion inscripcion;

    @Column(name = "AS_Fecha", nullable = false)
    @Required
    private Date fecha;

    @Column(name = "AS_HoraRegistro")
    private java.sql.Time horaRegistro;

    @Column(name = "AS_Estado", length = 20, nullable = false)
    @Required
    private String estado;

    @Column(name = "AS_Observaciones", length = 255)
    private String observaciones;
}