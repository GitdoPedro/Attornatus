package com.example.Attornatus.mappers;

import com.example.Attornatus.dtos.pessoa.PessoaRequest;
import com.example.Attornatus.dtos.pessoa.PessoaResponse;
import com.example.Attornatus.models.Pessoa;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PessoaMapper {

    Pessoa map(PessoaRequest source);
    PessoaResponse map(Pessoa source);
    List<PessoaResponse> map(List<Pessoa> source);

    @Mapping(target = "id", ignore = true)
    void updateFromRequest(PessoaRequest request, @MappingTarget Pessoa pessoa);


}
