package com.concessionaria.resources;

import com.concessionaria.dtos.VeiculoDTO;
import com.concessionaria.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/")
    public ResponseEntity<VeiculoDTO> createVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO newVeiculo = veiculoService.createVeiculo(veiculoDTO);
        return new ResponseEntity<>(newVeiculo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        VeiculoDTO veiculoDTO = veiculoService.findById(id);
        return ResponseEntity.ok(veiculoDTO);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        List<VeiculoDTO> veiculos = veiculoService.findAll();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> updateVeiculo(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO veiculo = veiculoService.update(veiculoDTO);
        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        veiculoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
