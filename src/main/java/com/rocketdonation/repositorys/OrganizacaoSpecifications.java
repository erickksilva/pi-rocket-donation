package com.rocketdonation.repositorys;

import com.rocketdonation.domain.organizacao.Organizacao;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class OrganizacaoSpecifications {

    public static Specification<Organizacao> filtrarPorZonaCategoriaMissao(String zona, String categoria, String missao) {

        return (Root<Organizacao> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (zona != null && !zona.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("endereco").get("zona"), zona));
            }
            if (categoria != null && !categoria.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("categoria"), "%" + categoria + "%"));
            }
            if (missao != null && !missao.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("missao"), "%" + missao + "%"));
            }

            return predicate;
        };
    }


}
