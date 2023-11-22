package com.rocketdonation.repositorys;

import com.rocketdonation.domain.organizacao.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContaRepository extends JpaRepository<ContaBancaria, Long> {

}
