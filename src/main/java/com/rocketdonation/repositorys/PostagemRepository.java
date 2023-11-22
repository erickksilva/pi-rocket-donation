package com.rocketdonation.repositorys;

import com.rocketdonation.domain.postagem.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Noticia, Long> {
}
