package com.rocketdonation.repositorys;

import com.rocketdonation.domain.organizacao.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

    Optional<Endereco> findByCep(String cep);
}
