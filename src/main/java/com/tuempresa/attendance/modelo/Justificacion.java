package com.tuempresa.attendance.modelo;

import java.util.*;

import javax.persistence.*;
import javax.ws.rs.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "JUSTIFICACION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Tab(properties =
    "asistencia.inscripcion.estudiante.nombres, motivo, estatus, fechaRecepcion")
public class Justificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "JU_Id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JU_IdAsistencia", nullable = false, unique = true)
    @Required
    private Asistencia asistencia;

    @Column(name = "JU_Motivo", length = 100)
    private String motivo;

    @Column(name = "JU_DescripcionDetallada")
    @Stereotype("MEMO")
    private String descripcionDetallada;

    @Column(name = "JU_RutaArchivoEvidencia", length = 500)
    private String rutaArchivoEvidencia;

    @Column(name = "JU_FechaRecepcion")
    private Date fechaRecepcion;

    @Column(name = "JU_Estatus", length = 20)
    @DefaultValue("Pendiente")
    private String estatus;
}