package com.concessionaria.resources;

import com.concessionaria.dtos.EnderecoDTO;
import com.concessionaria.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@RequestBody EnderecoDTO dto) {
        EnderecoDTO created = service.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody EnderecoDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
