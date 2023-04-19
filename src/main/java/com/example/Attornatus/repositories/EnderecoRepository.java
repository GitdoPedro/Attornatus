package com.example.Attornatus.repositories;

import com.example.Attornatus.models.Endereco;
import com.example.Attornatus.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {


    List<Endereco> findByPessoaId(Integer pessoaId);
}