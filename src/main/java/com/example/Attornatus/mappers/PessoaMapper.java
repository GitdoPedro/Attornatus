package com.example.Attornatus.mappers;

import com.example.Attornatus.dtos.PessoaRequest;
import com.example.Attornatus.dtos.PessoaResponse;
import com.example.Attornatus.models.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PessoaMapper {

    Pessoa map(PessoaRequest source);
    PessoaResponse map(Pessoa source);
    List<PessoaResponse> map(List<Pessoa> source);


}
