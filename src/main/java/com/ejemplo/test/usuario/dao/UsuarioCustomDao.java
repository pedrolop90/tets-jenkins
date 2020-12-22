package com.ejemplo.test.usuario.dao;

import com.ejemplo.test.usuario.entity.UsuarioEntity;

import java.util.List;

/**
 * @author pedro
 */
public interface UsuarioCustomDao {

    List<UsuarioEntity> findByNombreCustomJpa(String nombre);

    List<UsuarioEntity> findByNombreCustomHibernate(String nombre);

}
