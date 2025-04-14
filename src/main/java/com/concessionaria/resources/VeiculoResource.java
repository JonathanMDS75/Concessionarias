package com.concessionaria.resources;

import com.concessionaria.dtos.VeiculoDTO;
import com.concessionaria.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@RequestBody VeiculoDTO dto) {
        VeiculoDTO created = service.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @RequestBody VeiculoDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
