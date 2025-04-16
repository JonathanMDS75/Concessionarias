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
        private VeiculoService service;

        @PostMapping("/")
        public ResponseEntity<VeiculoDTO> createVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
            VeiculoDTO created = service.save(veiculoDTO);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
            VeiculoDTO veiculoDTO = service.findById(id);
            return ResponseEntity.ok(veiculoDTO);
        }

        @GetMapping("/")
        public ResponseEntity<List<VeiculoDTO>> findAll() {
            List<VeiculoDTO> veiculos = service.findAll();
            return new ResponseEntity<>(veiculos, HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<VeiculoDTO> updateVeiculo(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
            VeiculoDTO updated = service.update(id, veiculoDTO);
            return ResponseEntity.ok(updated);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable Long id) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }