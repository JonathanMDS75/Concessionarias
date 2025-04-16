package com.concessionaria.services;

import com.concessionaria.dtos.VeiculoDTO;
import com.concessionaria.models.Veiculo;
import com.concessionaria.repositories.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

@Autowired
private VeiculoRepository veiculoRepository;

public List<VeiculoDTO> findAll() {
    return veiculoRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
}

public VeiculoDTO findById(Long id) {
    Veiculo veiculo = veiculoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + id));
    return toDTO(veiculo);
}

@Transactional
public VeiculoDTO save(VeiculoDTO dto) {
    Veiculo veiculo = toEntity(dto);
    veiculo = veiculoRepository.save(veiculo);
    return toDTO(veiculo);
}

@Transactional
public VeiculoDTO update(Long id, VeiculoDTO dto) {
    Veiculo veiculo = veiculoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + id));

    veiculo.setModelo(dto.getModelo());
    veiculo.setMarca(dto.getMarca());
    veiculo.setAnoFabricacao(dto.getAnoFabricacao());
    veiculo.setAnoModelo(dto.getAnoModelo());
    veiculo.setPreco(dto.getPreco());

    veiculo = veiculoRepository.save(veiculo);
    return toDTO(veiculo);
}

@Transactional
public void deleteById(Long id) {
    if (!veiculoRepository.existsById(id)) {
        throw new RuntimeException("Veículo não encontrado com ID: " + id);
    }
    veiculoRepository.deleteById(id);
}

private VeiculoDTO toDTO(Veiculo veiculo) {
    return new VeiculoDTO(
            veiculo.getId(),
            veiculo.getModelo(),
            veiculo.getMarca(),
            veiculo.getAnoFabricacao(),
            veiculo.getAnoModelo(),
            veiculo.getPreco()
    );
}

private Veiculo toEntity(VeiculoDTO dto) {
    Veiculo veiculo = new Veiculo();
    veiculo.setId(dto.getId());
    veiculo.setModelo(dto.getModelo());
    veiculo.setMarca(dto.getMarca());
    veiculo.setAnoFabricacao(dto.getAnoFabricacao());
    veiculo.setAnoModelo(dto.getAnoModelo());
    veiculo.setPreco(dto.getPreco());
    return veiculo;
}
}