package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "ASIGNACION_PROFESOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Tab(properties = "curso.codigo, profesor.numeroEmpleado, periodo, fechaAsignacion")
public class AsignaciónProfesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "AP_Id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AP_IdCurso", nullable = false)
    @Required
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AP_IdProfesor", nullable = false)
    @Required
    private Profesor profesor;

    @Column(name = "AP_Periodo", length = 20, nullable = false)
    @Required
    private String periodo;

    @Column(name = "AP_FechaAsignacion")
    private Date fechaAsignacion;
}
