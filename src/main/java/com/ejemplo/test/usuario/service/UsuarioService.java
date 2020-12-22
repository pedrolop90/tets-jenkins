package com.ejemplo.test.usuario.service;

import com.ejemplo.test.usuario.dto.UsuarioDto;
import com.ejemplo.test.usuario.dto.UsuarioImageDto;

import java.util.List;

/**
 * @author pedro
 */
public interface UsuarioService {

    UsuarioDto create(UsuarioImageDto usuarioImageDto);

    List<UsuarioDto> findByNombre(String nombre);

    List<UsuarioDto> findAll();

}
