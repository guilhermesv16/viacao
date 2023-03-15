package br.com.viacao.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.viacao.model.ViacaoModel;
import br.com.viacao.repository.ViacaoRepository;


@Path("viacoes")
public class ViacaoResource {
    
    @Inject
    private ViacaoRepository viacaoRepository;

    // METODO GET PARA LISTAR TODAS AS VIACOES DO BANCO DE DADOS
    @GET
    public List<ViacaoModel> listarTodasAsViacao() {
         return viacaoRepository.findAll().list();
    }

    // METODO GET PARA LISTAR VIACAO POR ID FORNECIDO
    @GET
    @Path("/{id}")
    public ViacaoModel listarPorId(@PathParam("id") Long id) {
        return viacaoRepository.findById(id);
    }

    // METODO GET PARA RETORNAR QUANTAS VIACAO TEM EM NUMEROS
    @GET
    @Path("/count")
    public long listarViacaoEmNumeros(){
        return viacaoRepository.count();
    }
    
    // METODO POST PARA INSERIR VIACAO AO BANCO DE DADOS
    @POST
    @Transactional
    public ViacaoModel inserirViacao(ViacaoModel viacaoModel) {
        viacaoRepository.persist(viacaoModel);

        return viacaoModel;
    }

    // METODO PUT PARA ATUALIZAR VIACAO DE ACORDO COM O ID FORNECIDO
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public ViacaoModel atualizarViacaoPorId(@PathParam("id") Long id, ViacaoModel viacaoModel) {

         ViacaoModel viacaoEntity = viacaoRepository.findById(id);
        
         viacaoEntity.setNome(viacaoModel.getNome());

        return viacaoEntity;
    }
}
