package controller;

import model.AlunoModel;
import model.EstadoModel;
import repository.AlunoRepository;
import repository.EstadoRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Frank
 */
@ManagedBean
@SessionScoped
public class AlunoController {

    private AlunoModel alunoModel;
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private AlunoRepository alunoRepository;
    private List<AlunoModel> listaDeAlunos;

    public AlunoController() {
        this.estadoRepository = new EstadoRepository();
        this.alunoModel = new AlunoModel();
        this.estadoModel = new EstadoModel();
        this.alunoRepository = new AlunoRepository();
        this.listaDeAlunos = new ArrayList<>();
    }

    public void salvar() {
        try {
            this.estadoModel = this.estadoRepository.buscarPorID(this.estadoModel.getIdEstado());
            this.alunoModel.setEstado(this.estadoModel);
            this.alunoRepository.salvar(this.alunoModel);
            this.alunoModel = new AlunoModel();
        } catch (Exception e) {
        }
    }

    public void buscarTodos() {
        this.listaDeAlunos = this.alunoRepository.buscarTodos();
    }

    public void buscarPorNome() {
        this.listaDeAlunos = this.alunoRepository.buscarPorNome(this.alunoModel.getNome());
    }

    public void excluirPorID(long idpessoa) {
        this.alunoRepository.excluirPorID(idpessoa);
    }

    public String editarPorID(long idpessoa) throws IOException {
        this.alunoModel = this.alunoRepository.buscarPorID(idpessoa);

        return "editarAluno.xhtml?faces-redirect=true";
    }

    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

}
