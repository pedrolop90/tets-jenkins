package com.ejemplo.test.usuario.client;

import com.ejemplo.test.usuario.dto.client.ArchivoDtoClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author pedro
 */
@FeignClient(value = "archivo", serviceId = "archivo", path = "archivos")
public interface ArchivoClient {

    @PostMapping
    ArchivoDtoClient create(@RequestBody ArchivoDtoClient archivoDtoClient);

    @PutMapping("{id}")
    ArchivoDtoClient update(@PathVariable String id, @RequestBody ArchivoDtoClient archivoDtoClient);

    @DeleteMapping("{id}")
    void delete(@PathVariable String id);

    @GetMapping
    List<ArchivoDtoClient> findAll();
}
