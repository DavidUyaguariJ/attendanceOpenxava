package com.tuempresa.attendance.utils;

import java.util.*;

import javax.persistence.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;

import com.tuempresa.attendance.modelo.*;


public class CargarEstudiantesAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {

        Curso curso = (Curso) getView().getValue("curso");
        if (curso == null) return;

        EntityManager em = XPersistence.getManager();

        List<Inscripcion> inscripciones = em.createQuery(
            "FROM Inscripcion i WHERE i.curso = :curso",
            Inscripcion.class
        )
        .setParameter("curso", curso)
        .getResultList();

        Collection<Map<String, Object>> filas = new ArrayList<>();

        for (Inscripcion i : inscripciones) {
            Map<String, Object> fila = new HashMap<>();
            fila.put("estudiante", i.getEstudiante());
            fila.put("asistio", true);
            filas.add(fila);
        }

        getView().setValue("detalles", filas);
    }
}
