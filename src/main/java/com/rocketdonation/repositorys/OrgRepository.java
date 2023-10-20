package com.rocketdonation.repositorys;

import com.rocketdonation.domain.organizacao.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepository extends JpaRepository<Organizacao, Long> {


}
