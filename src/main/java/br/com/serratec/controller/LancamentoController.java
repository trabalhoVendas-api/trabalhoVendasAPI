package br.com.serratec.controller;

import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<LancamentoVendasResponseDTO> listarPorId(@PathVariable Long id) {
        LancamentoVendasResponseDTO responseDTO = lancamentoService.listarPorId(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<LancamentoVendas> inserirLancamento(@RequestBody LancamentoVendas lancamentoVendas) {
        LancamentoVendas savedLancamento = lancamentoService.inserirLancamento(lancamentoVendas);
        return ResponseEntity.ok(savedLancamento);
    }

    @GetMapping
    public ResponseEntity<Page<LancamentoVendas>> listarPorPagina(Pageable pageable) {
        Page<LancamentoVendas> page = lancamentoService.listarPorPagina(pageable);
        return ResponseEntity.ok(page);
    }
}
