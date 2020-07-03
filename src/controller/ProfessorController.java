package controller;

import model.ProfessorModel;
import model.EstadoModel;
import repository.ProfessorRepository;
import repository.EstadoRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProfessorController {

    private ProfessorModel professorModel;
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private ProfessorRepository professorRepository;
    private List<ProfessorModel> listaDeProfessores;

    public ProfessorController() {
        this.estadoRepository = new EstadoRepository();
        this.professorModel = new ProfessorModel();
        this.estadoModel = new EstadoModel();
        this.professorRepository = new ProfessorRepository();
        this.listaDeProfessores = new ArrayList<>();
    }

    public void salvar() {
        try {
            this.estadoModel = this.estadoRepository.buscarPorID(this.estadoModel.getIdEstado());
            this.professorModel.setEstado(this.estadoModel);
            this.professorRepository.salvar(this.professorModel);
            this.professorModel = new ProfessorModel();
        } catch (Exception e) {
        }
    }

    public void buscarTodos() {
        this.listaDeProfessores = this.professorRepository.buscarTodos();
    }

    public void buscarPorNome() {
        this.listaDeProfessores = this.professorRepository.buscarPorNome(this.professorModel.getNome());
    }

    public void excluirPorID(long idpessoa) {
        this.professorRepository.excluirPorID(idpessoa);
    }

    public String editarPorID(long idpessoa) throws IOException {
        this.professorModel = this.professorRepository.buscarPorID(idpessoa);

        return "editarprofessor.xhtml?faces-redirect=true";
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

    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorModel> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<ProfessorModel> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }

}
