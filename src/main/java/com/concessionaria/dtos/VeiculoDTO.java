package com.concessionaria.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

    private Long id;
    private String modelo;
    private String marca;
    private int ano;
    private double preco;

}
