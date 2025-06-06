package com.concessionaria.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Long id;
    private String rua;
    private String numero;
    private String bairro;
    private CidadeDTO cidade;
}
