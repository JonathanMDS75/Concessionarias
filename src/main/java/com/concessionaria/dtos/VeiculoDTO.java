package com.concessionaria.dtos;

    import jakarta.validation.constraints.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class VeiculoDTO {

        private Long id;

        @NotBlank(message = "O modelo é obrigatório.")
        private String modelo;

        @NotBlank(message = "A marca é obrigatória.")
        private String marca;

        @Min(value = 1886, message = "O ano de fabricação deve ser maior ou igual a 1886.")
        @Max(value = 2100, message = "O ano de fabricação deve ser menor ou igual a 2100.")
        private int anoFabricacao;

        @Min(value = 1886, message = "O ano do modelo deve ser maior ou igual a 1886.")
        @Max(value = 2100, message = "O ano do modelo deve ser menor ou igual a 2100.")
        private int anoModelo;

        @Positive(message = "O preço deve ser maior que zero.")
        private double preco;
    }