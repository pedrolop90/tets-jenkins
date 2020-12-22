package com.ejemplo.test.usuario.dto.mapper;

import com.ejemplo.test.usuario.dto.UsuarioDto;
import com.ejemplo.test.usuario.entity.UsuarioEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

/**
 * @author pedro
 */
@Mapper(componentModel = "spring")
public interface UsuarioDtoMapper {

    @Named(value = "usuarioEntityToUsuarioDtoMapper")
    UsuarioDto usuarioEntityToUsuarioDtoMapper(UsuarioEntity usuario);

    @Named(value = "usuarioDtoToUsuarioEntityMapper")
    UsuarioEntity usuarioDtoToUsuarioEntityMapper(UsuarioDto usuario);

    @IterableMapping(qualifiedByName = "usuarioEntityToUsuarioDtoMapper")
    List<UsuarioDto> usuarioEntityToUsuarioDtoMapper(Iterable<UsuarioEntity> usuario);

    @IterableMapping(qualifiedByName = "usuarioDtoToUsuarioEntityMapper")
    List<UsuarioEntity> usuarioDtoToUsuarioEntityMapper(Iterable<UsuarioDto> usuario);

}
