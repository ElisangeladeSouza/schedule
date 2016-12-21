package br.com.teste.controller;

import br.com.teste.exceptios.NegocioException;
import br.com.teste.schedule.model.Paciente;
import br.com.teste.schedule.service.interfaces.PacienteServiceIF;
import br.com.teste.schedule.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
@Model
public class PacienteBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Paciente paciente;
    
    @Inject
    private PacienteServiceIF pacienteService;
    
    @Inject
    private Paciente pacienteSelecionado;
    
    private transient List<Paciente> pacientes;
    
    public PacienteBean() {
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
    
    @PostConstruct
    public void init() {
        this.pacientes = pacienteService.findAll();
    }
    
    public void salvar() {
        this.pacienteService.save(paciente);
        if(getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de paciente '" + paciente.getId() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("PesquisaPaciente.xhtml");
        paciente = new Paciente();
    }
    
    public void excluir() throws NegocioException {
        this.pacienteService.delete(pacienteSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaPaciente.xhtml");
    }
    
    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro e retorna true, senao refere-se a um produto
     * a ser editado, retornando false.
     *
     * @return
     */
    public boolean getEditando() {
        return this.paciente.getId() != null;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteServiceIF getPacienteService() {
        return pacienteService;
    }

    public void setPacienteService(PacienteServiceIF pacienteService) {
        this.pacienteService = pacienteService;
    }

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }
    
}
