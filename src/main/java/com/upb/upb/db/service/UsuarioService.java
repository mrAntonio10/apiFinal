package com.upb.upb.db.service;

import com.upb.upb.db.model.Usuario;

import java.util.List;

public interface UsuarioService {


    Long save(Usuario usuarioDto);

    Long findByUsernameAndPassword(String nombreUsuario, String password);

    List<Usuario> findAllUsers();
}
