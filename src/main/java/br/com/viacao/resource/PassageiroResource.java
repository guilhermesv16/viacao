package br.com.viacao.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.viacao.model.PassageiroModel;
import br.com.viacao.repository.PassageiroRepository;

@Path("/passageiros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PassageiroResource {
    @Inject
    private PassageiroRepository passageiroRepository;

    // METODO GET PARA LISTAR TODOS OS PASSAGEIROS DO BANCO DE DADOS
    @GET
    public List<PassageiroModel> listarTodosOsPassageiro() {
         return passageiroRepository.findAll().list();
    }
    
    // METODO GET PARA LISTAR PASSAGEIRO POR ID FORNECIDO
    @GET
    @Path("/{id}")
    public PassageiroModel findById(@PathParam("id") Long id) {
        return passageiroRepository.findById(id);
    }

    // METODO GET PARA RETORNAR QUANTAS PASSAGENS TEM EM NUMEROS
    @GET
    @Path("/count")
    public long listarPassageiroEmNumeros(){
        return passageiroRepository.count();
    }

    // METODO POST PARA INSERIR PASSAGEIRO AO BANCO DE DADOS
    @POST
    @Transactional
    public PassageiroModel inserirPassageiro(PassageiroModel passageiroModel) {
        passageiroRepository.persist(passageiroModel);

        return passageiroModel;
    }

    // METODO PUT PARA ATUALIZAR DADOS DO PASSAGEIRO DE ACORDO COM O ID FORNECIDO
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public PassageiroModel atualizarPorId(@PathParam("id") Long id, PassageiroModel passageiroModel) {

         PassageiroModel passageiroEntity = passageiroRepository.findById(id);
        
         passageiroEntity.setNome(passageiroModel.getNome());
         passageiroEntity.setIdade(passageiroModel.getIdade());

        return passageiroEntity;
    }

    // METODO DELETE PARA DELETAR PASSAGEIRO DE ACORDO COM O ID FORNECIDO
    @DELETE
    @Transactional
    public boolean deletePassageiroPorId(Long id) {
        return passageiroRepository.deleteById(id);
    }
}
