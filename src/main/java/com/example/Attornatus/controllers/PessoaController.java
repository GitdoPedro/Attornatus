package com.example.Attornatus.controllers;


import com.example.Attornatus.dtos.PessoaRequest;
import com.example.Attornatus.dtos.PessoaResponse;
import com.example.Attornatus.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    // Listar pessoas
    @GetMapping
    public ResponseEntity<List<PessoaResponse>> getPessoas() {
        return ResponseEntity.ok(service.getPessoas());
    }

    //Consultar uma pessoa
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> getPessoaById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPessoaById(id));
    }

    //Criar uma pessoa
    @PostMapping
    public ResponseEntity<String> addPessoa(@RequestBody PessoaRequest request) {
        return service.addPessoa(request);
    }

    // Editar uma pessoa
    @PutMapping("/atualizar")
    public ResponseEntity<String> updatePessoaById(
                            @RequestParam Integer id,
                            @RequestBody @Validated PessoaRequest pessoa) {
        return service.updatePessoaById(id, pessoa);
    }




}
