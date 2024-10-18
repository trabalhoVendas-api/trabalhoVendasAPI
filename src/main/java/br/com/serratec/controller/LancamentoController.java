package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<List<LancamentoVendasResponseDTO>> listarPorId(@PathVariable Long id) {
        List<LancamentoVendasResponseDTO> dto = lancamentoService.listarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<LancamentoVendas> inserirLancamento(@RequestBody LancamentoVendas lancamentoVendas) {
        LancamentoVendas novoLancamento = lancamentoService.inserirLancamento(lancamentoVendas);
        return ResponseEntity.status(201).body(novoLancamento);
    }
}

//teste