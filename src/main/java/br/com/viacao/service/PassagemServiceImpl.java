package br.com.viacao.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.com.viacao.dto.PassagemDTO;
import br.com.viacao.dto.PassagemResponseDTO;
import br.com.viacao.model.PassagemModel;
import br.com.viacao.repository.PassagemRepository;
import br.com.viacao.repository.ViacaoRepository;

@ApplicationScoped
public class PassagemServiceImpl implements PassagemService {
    
    @Inject
    PassagemRepository passagemRepository;

    @Inject
    ViacaoRepository viacaoRepository;

    @Inject
    Validator validator;


    // METODO PARA LISTAR TODAS AS PASSAGENS
    @Override
    public List<PassagemResponseDTO> listarTodasAsPassagem() {
        List<PassagemModel> list = passagemRepository.listAll();
        return list.stream().map(PassagemResponseDTO::new).collect(Collectors.toList());
    }

    // METODO PARA LISTAR A PASSAGEM POR ID 
    @Override
    public PassagemResponseDTO listarPassagemPorId(Long id) {
        PassagemModel passagemModel = passagemRepository.findById(id);
        if (passagemModel == null)
            throw new NotFoundException("Passagem não encontrada.");
        return new PassagemResponseDTO(passagemModel);
    }

    // METODO PARA INSERIR(CRIAR UMA NOVA PASSAGEM
    @Override
    @Transactional
    public PassagemResponseDTO inserirPassagem(PassagemDTO passagemDTO) {
        Set<ConstraintViolation<PassagemDTO>> violations = validator.validate(passagemDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

        PassagemModel entity = new PassagemModel();
        
        entity.setPreco(passagemDTO.getPreco());
        entity.setOrigem(passagemDTO.getOrigem());
        entity.setDestino(passagemDTO.getDestino());
        entity.setAssento(passagemDTO.getAssento());

        entity.setViacao(viacaoRepository.findById(passagemDTO.getIdViacao()));

        passagemRepository.persist(entity);

        return new PassagemResponseDTO(entity);
    }

    // METODO PARA ATUALIZAR PASSAGEM PELO ID FORNECIDO
    @Override
    @Transactional
    public PassagemResponseDTO atulizarPassagem(Long id, PassagemDTO passagemDTO) {
        PassagemModel entity = passagemRepository.findById(id);

        entity.setPreco(passagemDTO.getPreco());
        entity.setOrigem(passagemDTO.getOrigem());
        entity.setDestino(passagemDTO.getDestino());
        entity.setAssento(passagemDTO.getAssento());

        entity.setViacao(viacaoRepository.findById(passagemDTO.getIdViacao()));

        return new PassagemResponseDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        passagemRepository.deleteById(id);
    }

    @Override
    public List<PassagemResponseDTO> listarPassagemPorNome(String nome) {
        List<PassagemModel> list = passagemRepository.procurarPorNome(nome);

        return list.stream().map(PassagemResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return passagemRepository.count();
    }

    
}
