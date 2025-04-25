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
    private ConcessionariaService concessionariaService;

    @PostMapping("/")
    public ResponseEntity<ConcessionariaDTO> createConcessionaria(@RequestBody ConcessionariaDTO concessionariaDTO) {
       ConcessionariaDTO newConcessionaria =  concessionariaService.createConcessionaria(concessionariaDTO);
        return new ResponseEntity<>(newConcessionaria, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcessionariaDTO> findById(@PathVariable Long id) {
        ConcessionariaDTO concessionariaDTO = concessionariaService.findById(id);
        return ResponseEntity.ok(concessionariaDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<ConcessionariaDTO>> findAll() {
        List<ConcessionariaDTO> concessionarias = concessionariaService.findAll();
        return ResponseEntity<>(concessionarias, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConcessionariaDTO> updateConcessionaria(@PathVariable Long id, @RequestBody ConcessionariaDTO concessionariaDTO) {
        ConcessionariaDTO concessionaria = concessionariaService.update(concessionariaDTO)
        return ResponseEntity.ok(concessionaria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        concessionariaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
