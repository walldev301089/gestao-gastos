package com.wallace.gestao_gastos.controller;

import com.wallace.gestao_gastos.dtos.TransacaoDTO;
import com.wallace.gestao_gastos.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDTO> salvar(@Valid @RequestBody TransacaoDTO dto) {
        transacaoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/saldo")
    public ResponseEntity<BigDecimal> obterSaldo() {
        BigDecimal saldo = transacaoService.calcularSaldoAtual();
        return ResponseEntity.ok(saldo);
    }

    @GetMapping("/saldoPorPeriodo")
    public ResponseEntity<BigDecimal> obterSaldoPorMesEAno(@RequestParam int mes, @RequestParam int ano) {
        BigDecimal saldoPorPeriodo = transacaoService.calcularSaldoPorMesEAno(mes, ano);
        return ResponseEntity.ok(saldoPorPeriodo);
    }
}