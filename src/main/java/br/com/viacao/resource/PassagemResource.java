package br.com.viacao.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.viacao.dto.PassagemDTO;
import br.com.viacao.dto.PassagemResponseDTO;
import br.com.viacao.service.PassagemService;

@Path("/passagens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PassagemResource {
    
    @Inject
    PassagemService passagemService; // ULTIMO PROBLEMA (A INJECAO ESTA ERRADA, NAO SEI O QUE É)

    // METODO GET PARA LISTAR TODAS AS PASSAGENS DO BANCO DE DADOS
    @GET
    public List<PassagemResponseDTO> listarTodasAsPassagem() {
         return passagemService.listarTodasAsPassagem();
    }

    // METODO GET QUE RETORNA QUANTAS PASSAGENS TEM EM NUMEROS
    @GET
    @Path("/count")
    public long listarPassagemEmNumeros(){
        return passagemService.count();
    }

    // METODO GET PARA LISTAR A PASSAGEM PELO ID FORNECIDO
    @GET
    @Path("/{id}")
    public PassagemResponseDTO listarPassagemPorId(@PathParam("id") Long id) {
        return passagemService.listarPassagemPorId(id);
    }

    // METODO POST PARA INSERIR UMA PASSAGEM AO BANCO DE DADOS
    @POST
    public Response inserirPassagem(PassagemDTO passagemDTO) {
        PassagemResponseDTO passagemResponseDTO = passagemService.inserirPassagem(passagemDTO);
        return Response.status(Status.CREATED).entity(passagemResponseDTO).build();
    }

    // METODO DELETE PARA DELETAR PASSAGEM DE ACORDO COM O ID
    // @DELETE
    // @Transactional
    // public boolean deletePassagemPorId(Long id) {
    //     return PassagemModel.deleteById(id);
    // }
}
