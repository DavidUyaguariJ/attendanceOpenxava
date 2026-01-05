package com.tuempresa.attendance.utils;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;

import com.tuempresa.attendance.modelo.*;

public class GuardarAsistenciaAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {

        Curso curso = (Curso) getView().getValue("curso");
        Profesor profesor = (Profesor) getView().getValue("profesor");
        LocalDate fecha = (LocalDate) getView().getValue("fecha");

        if (curso == null || profesor == null || fecha == null) {
            addError("Debe seleccionar curso, profesor y fecha");
            return;
        }
        EntityManager em = XPersistence.getManager();
        Asistencia asistencia = new Asistencia();
        asistencia.setCurso(curso);
        asistencia.setProfesor(profesor);
        asistencia.setFecha(fecha);

        em.persist(asistencia);
        @SuppressWarnings("unchecked")
        Collection<Map<String, Object>> filas =
            (Collection<Map<String, Object>>) getView().getValue("detalles");
        if (filas == null || filas.isEmpty()) {
            addError("No hay estudiantes para guardar");
            return;
        }
        for (Map<String, Object> fila : filas) {
            Estudiante estudiante = (Estudiante) fila.get("estudiante");
            Boolean asistio = (Boolean) fila.get("asistio");
            AsistenciaDetalle detalle = new AsistenciaDetalle();
            detalle.setAsistencia(asistencia);
            detalle.setEstudiante(estudiante);
            detalle.setAsistio(asistio != null ? asistio : false);
            em.persist(detalle);
        }

        em.flush();
        getView().clear();
    }
}