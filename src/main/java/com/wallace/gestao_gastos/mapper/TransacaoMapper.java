package com.wallace.gestao_gastos.mapper;

import com.wallace.gestao_gastos.domain.Transacao;
import com.wallace.gestao_gastos.dtos.TransacaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {
    TransacaoDTO transacaoToTransacaoDTO(Transacao transacao);
    Transacao transacaoDTOToTransacao(TransacaoDTO transacaoDTO);
}