package com.example.Attornatus.mappers;

import com.example.Attornatus.dtos.endereco.EnderecoRequest;
import com.example.Attornatus.dtos.endereco.EnderecoResponse;
import com.example.Attornatus.dtos.pessoa.PessoaRequest;
import com.example.Attornatus.dtos.pessoa.PessoaResponse;
import com.example.Attornatus.models.Endereco;
import com.example.Attornatus.models.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper {

    Endereco map(EnderecoRequest source);
    EnderecoResponse map(Endereco source);
    List<EnderecoResponse> map(List<Endereco> source);




}
