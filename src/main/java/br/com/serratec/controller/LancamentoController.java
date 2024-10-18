package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.repository.LancamentoRepository;
import br.com.serratec.service.LancamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private LancamentoRepository lancamentoVendasRepository;

    @GetMapping("/{id}")
    public ResponseEntity<List<LancamentoVendasResponseDTO>> listarPorId(@PathVariable Long id) {
        List<LancamentoVendasResponseDTO> dto = lancamentoService.listarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Insere um nova venda", description = "A resposta retorna os detalhes da venda inserida..")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", 
			content = {@Content(schema = @Schema(implementation = LancamentoVendas.class), mediaType = "application/json")},
			description = "Usuário cadastrado com sucesso"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })

    
    @PostMapping
    public ResponseEntity<LancamentoVendas> inserirLancamento(@RequestBody LancamentoVendas lancamentoVendas) {
        LancamentoVendas novoLancamento = lancamentoService.inserirLancamento(lancamentoVendas);
        return ResponseEntity.status(201).body(novoLancamento);
    }

    //Request com Paginação
	@Operation(summary = "Lista Paginada de Vendas", description = "Retorna Lançamentos de Venda Paginadas")
	@ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
			@Content(schema = @Schema(implementation = LancamentoVendas.class), mediaType = "application/json") }, description = "Lancamento de venda cadastrado com sucesso"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
    @GetMapping("/paginacao")
    public ResponseEntity<Page<LancamentoVendasResponseDTO>> listarLancamentos(Pageable pageable) {
        Page<LancamentoVendas> lancamentos = lancamentoVendasRepository.findAll(pageable);
        Page<LancamentoVendasResponseDTO> response = lancamentos.map(lancamento -> {
            LancamentoVendasResponseDTO dto = new LancamentoVendasResponseDTO();
            dto.setData(lancamento.getData());
            dto.setValor(lancamento.getValor());
            dto.setNomeVendedor(lancamento.getVendedor().getNome());
            return dto;});
        
        return ResponseEntity.ok(response);
        //exemplo de requisição por valor decrescente no postman: 
        //localhost:8080/lancamentos/paginacao?page=0&size=10&sort=valor,desc
    }
}

//teste
