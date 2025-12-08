package com.tuempresa.attendance.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "CURSO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Tab(properties = "codigo, nombreMateria, horario, aula, cupoMaximo, creditos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "CU_Id")
    private Integer id;

    @Column(name = "CU_Codigo", length = 20, nullable = false)
    @Required
    private String codigo;

    @Column(name = "CU_NombreMateria", length = 100, nullable = false)
    @Required
    private String nombreMateria;

    @Column(name = "CU_Descripcion")
    @Stereotype("MEMO")
    private String descripcion;

    @Column(name = "CU_Horario", length = 100)
    private String horario;

    @Column(name = "CU_Aula", length = 50)
    private String aula;

    @Column(name = "CU_CupoMaximo")
    private Integer cupoMaximo;

    @Column(name = "CU_Creditos")
    private Integer creditos;
}