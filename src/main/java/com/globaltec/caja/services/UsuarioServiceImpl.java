package com.globaltec.caja.services;

import com.globaltec.caja.models.Empleado;
import com.globaltec.caja.models.Usuario;
import com.globaltec.caja.repository.EmpleadoRepository;
import com.globaltec.caja.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public Usuario registrarUsuario(Usuario usuario, String tipo) throws Exception{
        Optional<Usuario> usuarioPresente = usuarioRepository.findByUsername(usuario.getUsername());
        Usuario nuevoUsuario = new Usuario();
        if (usuarioPresente.isPresent()){
            throw new Exception("El usuario ya existe en la base de datos");
        }else{
            nuevoUsuario = usuarioRepository.save(usuario);
            Empleado empleado = new Empleado();
            empleado.setUsuario(nuevoUsuario);
            empleado.setTipo(tipo);
            empleadoRepository.save(empleado);
        }
        return nuevoUsuario;
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return Optional.empty();
    }
}
