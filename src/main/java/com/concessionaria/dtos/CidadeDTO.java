package com.concessionaria.dtos;

import com.concessionaria.models.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO {

    private Long id;
    private String nome;
    private String cep;
}