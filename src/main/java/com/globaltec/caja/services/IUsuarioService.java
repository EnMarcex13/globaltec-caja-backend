package com.globaltec.caja.services;

import com.globaltec.caja.models.Usuario;

import java.util.Optional;

public interface IUsuarioService {

    public Usuario registrarUsuario(Usuario usuario, String tipo) throws Exception;
    public Optional<Usuario> findByUsername(String username);
}
