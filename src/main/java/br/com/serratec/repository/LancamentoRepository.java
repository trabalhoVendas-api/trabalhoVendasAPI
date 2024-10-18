package br.com.serratec.repository;

import br.com.serratec.entity.LancamentoVendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long> {
}
