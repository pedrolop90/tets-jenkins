package com.ejemplo.test.usuario.dto.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 * @author pedro
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
public class ArchivoDtoClient {

    private String id;

    private String nombre;
    private String tipo;
    private String categoria;
    private String base64;

}
