package com.wallace.gestao_gastos.service;

import com.wallace.gestao_gastos.domain.TipoDeTransacao;
import com.wallace.gestao_gastos.domain.Transacao;
import com.wallace.gestao_gastos.dtos.TransacaoDTO;
import com.wallace.gestao_gastos.mapper.TransacaoMapper;
import com.wallace.gestao_gastos.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper;

    public TransacaoDTO salvar(TransacaoDTO transacaoDTO) {

        Transacao transacao = transacaoMapper.toEntity(transacaoDTO);
        Transacao transacaoSalva = transacaoRepository.save(transacao);
        return transacaoMapper.toDto(transacaoSalva);
    }

    public BigDecimal calcularSaldoAtual() {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return transacoes.stream().map(transacao -> {
                    if (TipoDeTransacao.DESPESA.equals(transacao.getTipo())) {
                        return transacao.getValor().negate();
                    }
                    return transacao.getValor();
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularSaldoPorMesEAno(int mes, int ano) {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return transacoes.stream()
                .filter(transacao -> transacao.getData() != null // Proteção extra para a data também
                        && transacao.getData().getMonthValue() == mes
                        && transacao.getData().getYear() == ano)
                .map(transacao -> TipoDeTransacao.DESPESA.equals(transacao.getTipo()) // Correção aqui
                        ? transacao.getValor().negate()
                        : transacao.getValor())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}