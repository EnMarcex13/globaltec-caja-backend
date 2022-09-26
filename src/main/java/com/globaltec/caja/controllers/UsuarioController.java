package com.globaltec.caja.controllers;

import com.globaltec.caja.dto.NuevoUsuario;
import com.globaltec.caja.models.Permiso;
import com.globaltec.caja.models.Usuario;
import com.globaltec.caja.services.IUsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) throws Exception {
        Usuario usuario = new Usuario();
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en los campos.");
        }
        BeanUtils.copyProperties(nuevoUsuario,usuario);
        Permiso permiso = new Permiso();
        permiso.setPermisoId(1L);
        usuario.setPermisos(Arrays.asList(permiso));
        try{
            usuario = usuarioService.registrarUsuario(usuario,nuevoUsuario.getTipo());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya se encuentra registrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

}
