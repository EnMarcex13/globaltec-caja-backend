package com.globaltec.caja.repository;

import com.globaltec.caja.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Optional<Usuario> findByUsername(String username);
}
