package com.wallace.gestao_gastos.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransacaoDTO(
        String descricao,
        BigDecimal valor,
        LocalDate data
) {

}