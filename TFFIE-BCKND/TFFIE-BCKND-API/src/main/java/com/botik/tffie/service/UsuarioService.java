package com.botik.tffie.service;

import com.botik.tffie.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario registrarUsuario(Usuario u) throws Exception;
    List<Usuario> listarUsuarios() throws Exception;
    Usuario logearUsuario(Integer id) throws Exception;
}
