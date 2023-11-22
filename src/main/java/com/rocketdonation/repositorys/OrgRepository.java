package com.rocketdonation.repositorys;

import com.rocketdonation.domain.organizacao.Organizacao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepository extends JpaRepository<Organizacao, String> {

    Organizacao findByemailOrg(String email);

    @Query("SELECT o FROM organizacao o WHERE o.categoria LIKE %:categoria%")
    List<Organizacao> listarCategoria(@Param("categoria") String categoria);

    List<Organizacao> findAll(Specification<Organizacao> specification);

    @Query("SELECT o FROM organizacao o " +
            "WHERE (:zona is null OR o.endereco.zona = :zona) " +
            "AND (:categoria is null OR o.categoria LIKE %:categoria%) " +
            "AND (:missao is null OR o.missao = :missao)")
    List<Organizacao> buscarOrganizacoesPorFiltros(@Param("zona") String zona,
                                                   @Param("categoria") String categoria,
                                                   @Param("missao") String missao);

    // List<Organizacao> findAllBycategoriaContainingIgnoreCaseOrderByIdAsc(String categoria);

}
