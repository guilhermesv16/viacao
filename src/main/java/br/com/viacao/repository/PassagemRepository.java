package br.com.viacao.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.viacao.model.PassagemModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PassagemRepository implements PanacheRepository<PassagemModel> {
    public List<PassagemModel> procurarPorNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
}
