package br.com.viacao.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.viacao.model.ViacaoModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ViacaoRepository implements PanacheRepository<ViacaoModel> {
    public List<ViacaoModel> procuarPorNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
}
