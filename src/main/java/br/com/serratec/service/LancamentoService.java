package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;

	@GetMapping("/{id}")
	public List<LancamentoVendasResponseDTO> listarPorId(@PathVariable Long id) {
	    List<LancamentoVendasResponseDTO> dtos = new ArrayList<>();
	    
	    Optional<LancamentoVendas> lancamento = repository.findById(id);
	    if (lancamento.isPresent()) {
	        LancamentoVendas lancamentoVendas = lancamento.get();
	        dtos.add(new LancamentoVendasResponseDTO(lancamentoVendas));
	    }
	    
	    return dtos;
	}

	
	@PostMapping
	public LancamentoVendas inserirLancamento(LancamentoVendas lancamentoVendas) {
		
		System.out.println(lancamentoVendas);
		lancamentoVendas.setId(2l);
		return repository.save(lancamentoVendas);
	}

}
