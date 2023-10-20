package com.rocketdonation.services;

import com.rocketdonation.domain.organizacao.ContaBancaria;
import com.rocketdonation.domain.organizacao.Endereco;
import com.rocketdonation.domain.organizacao.Organizacao;
import com.rocketdonation.dto.CadastroOrg;
import com.rocketdonation.repositorys.*;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CadastroOrgService {
    private final ContaRepository contaRepository;
    private final DoadorRepository doadorRepository;
    private final EnderecoRepository enderecoRepository;
    private final OrgRepository orgRepository;


    public CadastroOrgService(ContaRepository contaRepository, DoadorRepository doadorRepository,
                              EnderecoRepository enderecoRepository, OrgRepository orgRepository) {
        this.contaRepository = contaRepository;
        this.doadorRepository = doadorRepository;
        this.enderecoRepository = enderecoRepository;
        this.orgRepository = orgRepository;

    }

    public Organizacao findBy(Long id) {
        return orgRepository.findById(id).orElse(null);
    }


    public Organizacao saveOrg(CadastroOrg org) {

        Endereco endereco = new Endereco(org.cep(), org.rua(), org.numero(), org.complemento());
        ContaBancaria conta = new ContaBancaria(org.agenciaConta(), org.numeroConta(), org.chavePix());
        enderecoRepository.save(endereco);
        contaRepository.save(conta);


        Organizacao organizacao = new Organizacao(org.nomeOrg(), org.telefoneOrg(), org.emailOrg(), org.siteOrg(), org.missaoOrg(),
                org.categoriaOrg(), new Date(), null, endereco, conta);


        orgRepository.save(organizacao);

        return organizacao;
    }


}
