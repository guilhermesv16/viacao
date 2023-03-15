package br.com.viacao.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.viacao.model.PassageiroModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PassageiroRepository implements PanacheRepository<PassageiroModel> {
    public List<PassageiroModel> procurarPorNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
}
