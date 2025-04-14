package com.concessionaria.resources;

import com.concessionaria.dtos.ConcessionariaDTO;
import com.concessionaria.services.ConcessionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concessionaria")
public class ConcessionariaResource {

    @Autowired
    private ConcessionariaService service;

    @PostMapping
    public ResponseEntity<ConcessionariaDTO> createConcessionaria(@RequestBody ConcessionariaDTO dto) {
       ConcessionariaDTO newConcessionaria =  ConcessionariaService.createConcessionaria(dto);
        return new ResponseEntity<>(newConcessionaria, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcessionariaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ConcessionariaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConcessionariaDTO> update(@PathVariable Long id, @RequestBody ConcessionariaDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
