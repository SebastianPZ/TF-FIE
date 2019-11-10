package com.botik.tffie.service.Implementacion;

import com.botik.tffie.model.Usuario;
import com.botik.tffie.repository.UsuarioRepository;
import com.botik.tffie.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception{
        return usuarioRepository.save(u);
    }

    @Override
    public List<Usuario> listarUsuarios() throws Exception{
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario logearUsuario(Integer id) throws Exception {
        return usuarioRepository.findById(id).get();
    }

}
