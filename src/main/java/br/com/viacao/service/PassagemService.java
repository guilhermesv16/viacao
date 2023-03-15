package br.com.viacao.service;

import java.util.List;

import br.com.viacao.dto.PassagemDTO;
import br.com.viacao.dto.PassagemResponseDTO;

public interface PassagemService {

    List<PassagemResponseDTO> listarTodasAsPassagem();

    PassagemResponseDTO listarPassagemPorId(Long id);

    PassagemResponseDTO inserirPassagem(PassagemDTO productDTO);

    PassagemResponseDTO atulizarPassagem(Long id, PassagemDTO productDTO);

    void delete(Long id);

    List<PassagemResponseDTO> listarPassagemPorNome(String nome);

    long count();
}
