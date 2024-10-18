package br.com.serratec.service;

import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public LancamentoVendasResponseDTO listarPorId(Long id) {
        LancamentoVendas lancamento = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lançamento não encontrado com ID: " + id));
        return new LancamentoVendasResponseDTO(lancamento);
    }

    public LancamentoVendas inserirLancamento(LancamentoVendas lancamentoVendas) {
        return repository.save(lancamentoVendas);
    }

    public Page<LancamentoVendas> listarPorPagina(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
