package com.ejemplo.test.usuario.controller;

import com.ejemplo.test.usuario.dto.UsuarioDto;
import com.ejemplo.test.usuario.dto.UsuarioImageDto;
import com.ejemplo.test.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pedro
 */
@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<String> getHola() {
        return ResponseEntity.ok("todo bien!!!");
    }

    @GetMapping("/all")
    public List<UsuarioDto> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/nombre/{nombre}")
    public List<UsuarioDto> findAll(@PathVariable String nombre) {
        return usuarioService.findByNombre(nombre);
    }

    @PostMapping("/image")
    public UsuarioDto create(@RequestBody UsuarioImageDto usuarioImageDto) {
        return usuarioService.create(usuarioImageDto);
    }
}
