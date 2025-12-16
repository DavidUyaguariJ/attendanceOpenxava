package com.tuempresa.attendance.modelo;

import java.time.*;
import java.time.temporal.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.*;
import javax.ws.rs.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

import lombok.*;

@Entity
@Table(name = "JUSTIFICACION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Tab(properties = "asistencia.inscripcion.estudiante.nombres, motivo, estatus, fechaRecepcion")
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
    @Required 
    private String motivo;

    @Column(name = "JU_DescripcionDetallada")
    @Stereotype("MEMO")
    private String descripcionDetallada;

    @Column(name = "JU_RutaArchivoEvidencia", length = 500)
    @Stereotype("FILE") 
    private String rutaArchivoEvidencia;

    @Column(name = "JU_FechaRecepcion")
    @DefaultValueCalculator(CurrentDateCalculator.class) 
    private Date fechaRecepcion;

    @Column(name = "JU_Estatus", length = 20)
    @DefaultValue("Pendiente")
    private String estatus;
    
    @PrePersist
    @PreUpdate
    public void validarReglasNegocio() {

        if (asistencia == null) {
             return; 
        }

        String estadoAsistencia = asistencia.getEstado(); 
        if (estadoAsistencia != null && !"AUSENTE".equalsIgnoreCase(estadoAsistencia) && !"FALTA".equalsIgnoreCase(estadoAsistencia)) {
            throw new ValidationException(
                "Regla de Negocio: Solo se pueden justificar registros con estado 'AUSENTE'. El estado actual es: " + estadoAsistencia
            );
        }

        boolean tieneDescripcion = !Is.emptyString(descripcionDetallada);
        boolean tieneArchivo = !Is.emptyString(rutaArchivoEvidencia);

        if (!tieneDescripcion && !tieneArchivo) {
             throw new ValidationException("Regla de Negocio: Debe ingresar una descripción detallada o subir un archivo de evidencia.");
        }

        long diasDiferencia = calcularDiasDesdeFalta(asistencia.getFecha());
        
        if (diasDiferencia > 7) {
            throw new ValidationException(
                "Regla de Negocio: Plazo vencido. Han pasado " + diasDiferencia + " días desde la falta (Máximo permitido: 7)."
            );
        }
        
        if (this.fechaRecepcion == null) {
            this.fechaRecepcion = new Date();
        }
    }

    public long calcularDiasDesdeFalta(Date fechaFalta) {
        if (fechaFalta == null) return 0;
        
        LocalDate fechaF = new java.sql.Date(fechaFalta.getTime()).toLocalDate();
        LocalDate fechaHoy = LocalDate.now();
        
        return ChronoUnit.DAYS.between(fechaF, fechaHoy);
    }
}