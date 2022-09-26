package com.globaltec.caja.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registroId;
    private LocalDate fechaFactura;
    private String tipo;
    private String concepto;
    private String serie;
    private String correlativo;
    private String ruc;
    private String comentario;
    private String archivo;
    private LocalDate fechaRegistro;
    private double precio;

    private Empleado empleado;
    private String placa;
    private LocalDate fechaEdicion;
}
