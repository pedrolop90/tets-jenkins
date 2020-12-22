package com.ejemplo.test.usuario.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pedro
 */
@Entity
@Table(name = "usuarios")
@Data
public class UsuarioEntity {

    public interface Attributes {
        String ID = "id";
        String NOMBRE = "nombre";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String idImage;

}
