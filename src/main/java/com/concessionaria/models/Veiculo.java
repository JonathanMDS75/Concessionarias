package com.concessionaria.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_veiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O modelo é obrigatório.")
    private String modelo;

    @NotBlank(message = "A marca é obrigatória.")
    private String marca;

    @NotBlank(message = "A placa é obrigatória.")
    @Column(unique = true)
    private String placa;

    @Min(value = 1886, message = "O ano de fabricação deve ser maior ou igual a 1886.")
    @Max(value = 2100, message = "O ano de fabricação deve ser menor ou igual a 2100.")
    private Integer anoFabricacao;

    @Min(value = 1886, message = "O ano do modelo deve ser maior ou igual a 1886.")
    @Max(value = 2100, message = "O ano do modelo deve ser menor ou igual a 2100.")
    private Integer anoModelo;

    @NotBlank(message = "A cor é obrigatória.")
    private String cor;

    @Positive(message = "O preço deve ser maior que zero.")
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "concessionaria_id")
    @ToString.Exclude
    private Concessionaria concessionaria;
}