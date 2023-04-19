package com.example.Attornatus.services;

import com.example.Attornatus.dtos.pessoa.PessoaRequest;
import com.example.Attornatus.dtos.pessoa.PessoaResponse;
import com.example.Attornatus.mappers.PessoaMapper;
import com.example.Attornatus.models.Pessoa;
import com.example.Attornatus.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PessoaMapper mapper;


    // Listar pessoas
    public List<PessoaResponse> getPessoas() {
        return mapper.map(repository.findAll());
    }

    //Consultar uma pessoa
    public PessoaResponse getPessoaById(Integer id) {
        return  mapper.map(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    //Criar uma pessoa
    public ResponseEntity<String> addPessoa(PessoaRequest request) {
        Pessoa pessoaCadastrada = mapper.map(request);
        mapper.updateFromRequest(request,pessoaCadastrada);
        repository.save(pessoaCadastrada);
        return ResponseEntity.created(URI.create("")).body("Pessoa cadastrado com sucesso!");
    }

    // Editar uma pessoa
    public ResponseEntity<String> updatePessoaById(Integer id, PessoaRequest request) {

        Pessoa pessoa = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(request.getNomeCompleto() != null && request.getNomeCompleto().length()> 0){
            pessoa.setNomeCompleto(request.getNomeCompleto());
        }

        if(request.getDataNascimento() != null){
            pessoa.setDataNascimento(request.getDataNascimento());
        }

        repository.save(pessoa);

        return ResponseEntity.ok("Quiz atualizado com sucesso!");
    }


}