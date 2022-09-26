package com.globaltec.caja.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empleadoId;
    @Column(nullable = false)
    private String tipo;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
