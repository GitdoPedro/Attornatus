package com.example.Attornatus.controllers;

import com.example.Attornatus.dtos.endereco.EnderecoRequest;
import com.example.Attornatus.dtos.endereco.EnderecoResponse;
import com.example.Attornatus.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

  // Listar endereços da pessoa
  @GetMapping
  public ResponseEntity<List<EnderecoResponse>> getEnderecosByPessoa(@RequestParam Integer pessoaId) {
      List<EnderecoResponse> enderecos = service.getEnderecosByPessoa(pessoaId);
      return ResponseEntity.ok(enderecos);
  }


   // Criar endereço para pessoa
    @PostMapping("/{pessoaId}")
    public ResponseEntity<String> addEndereco(@RequestBody EnderecoRequest request,@PathVariable Integer pessoaId) {
        return service.addEndereco(request,pessoaId);
    }
}
