package com.botik.tffie.controller;

import com.botik.tffie.model.Usuario;
import com.botik.tffie.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Usuario> listarUsuarios() throws Exception
    {
        return usuarioService.listarUsuarios();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Usuario verPerfil(@PathVariable Integer id) throws Exception{
        return usuarioService.logearUsuario(id);
    }

}
