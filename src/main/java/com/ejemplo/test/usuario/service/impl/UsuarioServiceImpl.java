package com.ejemplo.test.usuario.service.impl;

import com.ejemplo.test.usuario.client.ArchivoClient;
import com.ejemplo.test.usuario.dao.UsuarioDao;
import com.ejemplo.test.usuario.dto.UsuarioDto;
import com.ejemplo.test.usuario.dto.UsuarioImageDto;
import com.ejemplo.test.usuario.dto.client.ArchivoDtoClient;
import com.ejemplo.test.usuario.dto.mapper.UsuarioDtoMapper;
import com.ejemplo.test.usuario.entity.UsuarioEntity;
import com.ejemplo.test.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pedro
 */
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final UsuarioDtoMapper usuarioDtoMapper;
    private final ArchivoClient archivoClient;

    @Override
    public UsuarioDto create(UsuarioImageDto usuarioImageDto) {
        ArchivoDtoClient archivoDtoClient = ArchivoDtoClient
                .builder()
                .nombre(usuarioImageDto.getUsuarioDto().getNombre() + "-imagen")
                .base64(usuarioImageDto.getDataImage())
                .build();
        ArchivoDtoClient response = archivoClient.create(archivoDtoClient);
        UsuarioEntity usuarioEntity = usuarioDtoMapper
                .usuarioDtoToUsuarioEntityMapper(usuarioImageDto.getUsuarioDto());
        usuarioEntity.setIdImage(response.getId());
        usuarioDao.save(usuarioEntity);
        return usuarioDtoMapper.usuarioEntityToUsuarioDtoMapper(usuarioEntity);
    }

    @Override
    public List<UsuarioDto> findByNombre(String nombre) {
        Iterable<UsuarioEntity> entities = usuarioDao.findByNombre(nombre);
        List<UsuarioDto> response = usuarioDtoMapper
                .usuarioEntityToUsuarioDtoMapper(entities);
        return response;
    }

    @Override
    public List<UsuarioDto> findAll() {
        Iterable<UsuarioEntity> entities = usuarioDao.findAll();
        List<UsuarioDto> response = usuarioDtoMapper
                .usuarioEntityToUsuarioDtoMapper(entities);
        return response;
    }
}
