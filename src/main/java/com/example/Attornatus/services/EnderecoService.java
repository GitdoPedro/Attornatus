package com.example.Attornatus.services;

import com.example.Attornatus.dtos.endereco.EnderecoRequest;
import com.example.Attornatus.dtos.endereco.EnderecoResponse;
import com.example.Attornatus.mappers.EnderecoMapper;
import com.example.Attornatus.models.Endereco;
import com.example.Attornatus.models.Pessoa;
import com.example.Attornatus.repositories.EnderecoRepository;
import com.example.Attornatus.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecorepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoMapper mapper;

    public List<EnderecoResponse> getEnderecosByPessoa(Integer pessoaId) {
        List<Endereco> enderecos = enderecorepository.findByPessoaId(pessoaId);
        return mapper.map(enderecos);
    }

    public ResponseEntity<String> addEndereco(EnderecoRequest request, Integer pessoaId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElse(null);

        if(pessoa == null){
            return ResponseEntity.badRequest().body("Pessoa não encontrada");
        }

        Endereco EnderecoCadastrado = mapper.map(request);
        enderecorepository.save(EnderecoCadastrado);
        return ResponseEntity.ok().body("Endereço adicionado com sucesso");
    }
}
