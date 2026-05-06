package com.wallace.gestao_gastos.repositorio;

import com.wallace.gestao_gastos.dominio.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
