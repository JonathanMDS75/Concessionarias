package com.concessionaria.resources;

import com.concessionaria.dtos.CidadeDTO;

import com.concessionaria.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping("/")
    public ResponseEntity<CidadeDTO> createCidade(@RequestBody CidadeDTO cidadeDTO) {
        CidadeDTO newCidade = cidadeService.createCidade(cidadeDTO);
        return new ResponseEntity<>(newCidade, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> findById(@PathVariable Long id) {
        CidadeDTO cidadeDTO = cidadeService.findById(id);
        return ResponseEntity.ok(cidadeDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<CidadeDTO>> findAll() {
        List<CidadeDTO> cidades = cidadeService.findAll();
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity <CidadeDTO> updateCidade(@PathVariable Long id, @RequestBody CidadeDTO cidadeDTO) {
        CidadeDTO cidade = cidadeService.update(cidadeDTO);
        return ResponseEntity.ok(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cidadeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
