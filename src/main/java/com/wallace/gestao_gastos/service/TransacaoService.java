package com.wallace.gestao_gastos.service;

import com.wallace.gestao_gastos.domain.TipoDeTransacao;
import com.wallace.gestao_gastos.domain.Transacao;
import com.wallace.gestao_gastos.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao salvarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public BigDecimal calcularSaldoAtual() {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return transacoes.stream().map(transacao -> {
                    if (transacao.getTipo().equals(TipoDeTransacao.DESPESA)) {
                        return transacao.getValor().negate();
                    }
                    return transacao.getValor();
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularSaldoPorMesEAno(int mes, int ano) {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return transacoes.stream().filter(transacao -> transacao.getData()
                        .getMonthValue() == mes && transacao.getData().getYear() == ano)
                .map(transacao -> transacao.getTipo()
                        .equals(TipoDeTransacao.DESPESA) ? transacao.getValor().negate() : transacao.getValor())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}