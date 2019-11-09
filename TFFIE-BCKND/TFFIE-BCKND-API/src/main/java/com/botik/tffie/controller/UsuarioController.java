package com.botik.tffie.controller;

import com.botik.tffie.model.Usuario;
import com.botik.tffie.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }


    @RequestMapping(path="/registro", method = RequestMethod.POST)
    public Usuario registrarUsuario(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.registrarUsuario(usuario);
    }

    @RequestMapping
    public List<Usuario> visualizarUsuariosRegistrados() throws Exception
    {
        return usuarioService.listarUsuarios();
    }

}
