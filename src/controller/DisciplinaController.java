package controller;

import model.DisciplinaModel;
import repository.DisciplinaRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DisciplinaController {

    private DisciplinaModel disciplinaModel;
    private DisciplinaRepository disciplinaRepository;
    private List<DisciplinaModel> listaDeDisciplinas;

    public DisciplinaController() {
        this.disciplinaModel = new DisciplinaModel();
        this.disciplinaRepository = new DisciplinaRepository();
        this.listaDeDisciplinas = new ArrayList<>();
    }

    public void salvar() {
        try {
            this.disciplinaRepository.salvar(this.disciplinaModel);
            this.disciplinaModel = new DisciplinaModel();
        } catch (Exception e) {
        }
    }

    public void buscarTodos() {
        this.listaDeDisciplinas = this.disciplinaRepository.buscarTodos();
    }

    public void buscarPorNome() {
        this.listaDeDisciplinas = this.disciplinaRepository.buscarPorNome(this.disciplinaModel.getNome());
    }

    public void excluirPorID(long iddisciplina) {
        this.disciplinaRepository.excluirPorID(iddisciplina);
    }

    public String editarPorID(long iddisciplina) throws IOException {
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(iddisciplina);

        return "editarDisciplina.xhtml?faces-redirect=true";
    }

    public DisciplinaModel getDisciplinaModel() {
        return disciplinaModel;
    }

    public void setDisciplinaModel(DisciplinaModel disciplinaModel) {
        this.disciplinaModel = disciplinaModel;
    }

    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<DisciplinaModel> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }

    public void setListaDeDisciplinas(List<DisciplinaModel> listaDeDisciplinas) {
        this.listaDeDisciplinas = listaDeDisciplinas;
    }

}
