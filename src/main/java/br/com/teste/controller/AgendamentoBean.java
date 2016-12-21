package br.com.teste.controller;

import br.com.teste.exceptios.NegocioException;
import br.com.teste.schedule.enumerations.Status;
import br.com.teste.schedule.model.Agendamento;
import br.com.teste.schedule.model.Paciente;
import br.com.teste.schedule.service.interfaces.AgendamentoServiceIF;
import br.com.teste.schedule.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author elisangela
 */
@Model
public class AgendamentoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Agendamento agendamento;
    
    @Inject
    private AgendamentoServiceIF agendamentoService;
    
    @Inject
    private Agendamento agendamentoSelecionado;
    
    private ScheduleModel scheduleModel;
    
    private ScheduleEvent evento = new DefaultScheduleEvent();
    
    private transient List<Agendamento> agendamentos;
    
    private transient List<Status> status = new ArrayList<>();
    
    public AgendamentoBean() {
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }
    
    @PostConstruct
    public void init() {
        this.agendamento = new Agendamento();
        this.scheduleModel = new DefaultScheduleModel();
        this.status = Arrays.asList(Status.values());
        
        this.agendamentos = agendamentoService.findAll();
        
        for(Agendamento ag : agendamentos) {
            DefaultScheduleEvent event = new DefaultScheduleEvent();
            event.setStartDate(ag.getDataHoraInicio());
            event.setEndDate(ag.getDataHoraFim());
            event.setTitle(ag.getPaciente().getNome());
            event.setData(ag.getId());
            event.setDescription(ag.getObservacoes());
            event.setAllDay(true);
            event.setEditable(true);
            
            scheduleModel.addEvent(event);
        }
    }
    
    // Funcionando
    public void quandoNovo(SelectEvent selectEvent) {
        ScheduleEvent scheduleEvent = new DefaultScheduleEvent("", (Date)selectEvent.getObject(), (Date)selectEvent.getObject());
        agendamento = new Agendamento();
        agendamento.setDataHoraInicio(new java.sql.Date(scheduleEvent.getStartDate().getTime()));
        agendamento.setDataHoraFim(new java.sql.Date(scheduleEvent.getEndDate().getTime()));
    }
    
    // Editar cadastro (não esta funcionando)
    public void quandoSelecionado(SelectEvent selectEvent) {
//        ScheduleEvent event = (ScheduleEvent) selectEvent.getObject();
//        
//        for (Agendamento agenda : agendamentos) {
//            if(agenda.getId() == (Long) event.getData()) {
//                agendamento = agenda;
//                break;
//            }
//        }
    }
    
    public void quandoMovido(ScheduleEntryMoveEvent moveEvent) {
        
    }
    
    public void quandoRedimencionado(ScheduleEntryResizeEvent resizeEvent) {
        
    }
    
    public void salvar() {
        if (agendamento.getId() == null) {
            if(agendamento.getDataHoraInicio().getTime() <= agendamento.getDataHoraFim().getTime()) {
                this.agendamentoService.save(agendamento);
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            } else {
                if(getEditando()) {
                    FacesUtil.mensagemSucesso("Cadastro de agendamento '" + agendamento.getId() + "' atualizado com sucesso!");
                }
            }
            agendamento = new Agendamento();
        }
        
    }
    
    public void excluir() throws NegocioException {
        this.agendamentoService.delete(agendamentoSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaAgendamento.xhtml");
    }
    
    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro e retorna true, senao refere-se a um produto
     * a ser editado, retornando false.
     *
     * @return
     */
    public boolean getEditando() {
        return this.agendamento.getId() != null;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public AgendamentoServiceIF getAgendamentoService() {
        return agendamentoService;
    }

    public void setAgendamentoService(AgendamentoServiceIF agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    public Agendamento getAgendamentoSelecionado() {
        return agendamentoSelecionado;
    }

    public void setAgendamentoSelecionado(Agendamento agendamentoSelecionado) {
        this.agendamentoSelecionado = agendamentoSelecionado;
    }

    public ScheduleModel getScheduleModel() {
        return scheduleModel;
    }

    public void setScheduleModel(ScheduleModel scheduleModel) {
        this.scheduleModel = scheduleModel;
    } 

    public ScheduleEvent getEvento() {
        return evento;
    }

    public void setEvent(ScheduleEvent evento) {
        this.evento = evento;
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }
    
}

