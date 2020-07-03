package repository;

import model.PessoaModel;
import util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frank
 */
public class UsuarioRepository extends Conexao{
  
    public List<PessoaModel> buscar(String login){
        List<PessoaModel> listaDePessoas = new ArrayList<PessoaModel>();
        super.inicializa();
        listaDePessoas = super.getSess().createQuery("from PessoaModel where login = '"+login+"'").list();
        super.executar();
        return listaDePessoas;
    }
}
