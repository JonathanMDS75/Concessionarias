package com.concessionaria.resources;

import com.concessionaria.dtos.FuncionarioDTO;
import com.concessionaria.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    @PostMapping("/")
    public ResponseEntity<FuncionarioDTO> createFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO created = service.createFuncionario(funcionarioDTO);
        return ResponseEntity<>.(newFuncionario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
        FuncionarioDTO funcionarioDTO = funcionarioService.findById(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<FuncionarioDTO>> findAll() {
        List<FuncionarioDTO> funcionarios = funcionarioService.findAll();
        return ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO dtfuncionaioDTO) {
        FuncionarioDTO funcionario = service.update(funcionarioDTO);
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        funcionarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
