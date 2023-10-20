package com.rocketdonation.repositorys;

import com.rocketdonation.domain.doador.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, String> {
}
