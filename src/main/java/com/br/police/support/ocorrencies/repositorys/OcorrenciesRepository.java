package com.br.police.support.ocorrencies.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.police.support.ocorrencies.entitys.Ocorrencies;

@Repository
public interface OcorrenciesRepository extends CrudRepository<Ocorrencies, Long> {
}
