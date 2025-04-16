package com.concessionaria.resources;

import com.concessionaria.dtos.EnderecoDTO;
import com.concessionaria.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @PostMapping("/")
    public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO newEndereco = service.createEndereco(enderecoDTO);
        return new ResponseEntity<>(newEndereco, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
        EnderecoDTO enderecoDTO = service.findById(id);
        return ResponseEntity.ok(enderecoDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        List<EnderecoDTO> enderecos = service.findAll();
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO endereco = service.update(enderecoDTO); // Também pode precisar do ID aqui, veja abaixo
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
