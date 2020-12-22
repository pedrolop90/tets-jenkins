package com.ejemplo.test.usuario.dao;

import com.ejemplo.test.usuario.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pedro
 */
@Repository
public interface UsuarioDao
        extends CrudRepository<UsuarioEntity, Long>, UsuarioCustomDao {

    List<UsuarioEntity> findByNombre(String nombre);

}
