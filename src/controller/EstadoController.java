package controller;

import model.EstadoModel;
import repository.EstadoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Frank
 */
@ManagedBean
@ViewScoped
public class EstadoController {
    
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private List<EstadoModel> listaDeEstados;
    
    public EstadoController(){
        this.estadoModel = new EstadoModel();
        this.estadoRepository = new EstadoRepository();
        this.listaDeEstados =  new ArrayList<>();
    }
    
    public void buscarTodos(){
        this.listaDeEstados = this.estadoRepository.buscarTodos();
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<EstadoModel> getListaDeEstados() {
        return listaDeEstados;
    }

    public void setListaDeEstados(List<EstadoModel> listaDeEstados) {
        this.listaDeEstados = listaDeEstados;
    }
    
}