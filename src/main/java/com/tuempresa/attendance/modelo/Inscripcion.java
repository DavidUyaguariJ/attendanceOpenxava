package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;
import javax.ws.rs.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "INSCRIPCION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Tab(properties = 
    "estudiante.matricula, estudiante.nombres, curso.codigo, periodo, calificacionFinal, estado")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "IN_Id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IN_IdEstudiante", nullable = false)
    @Required
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IN_IdCurso", nullable = false)
    @Required
    private Curso curso;

    @Column(name = "IN_Periodo", length = 20, nullable = false)
    @Required
    private String periodo;

    @Column(name = "IN_FechaInscripcion")
    private Date fechaInscripcion;

    @Column(name = "IN_CalificacionFinal", precision = 5, scale = 2)
    private Double calificacionFinal;

    @Column(name = "IN_Estado", length = 20)
    @DefaultValue("Cursando")
    private String estado;
}
