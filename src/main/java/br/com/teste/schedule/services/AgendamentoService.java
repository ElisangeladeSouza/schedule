package br.com.teste.schedule.services;

import br.com.teste.exceptios.NegocioException;
import br.com.teste.schedule.dao.AgendamentoDao;
import br.com.teste.schedule.model.Agendamento;
import br.com.teste.schedule.service.interfaces.AgendamentoServiceIF;
import br.com.teste.schedule.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
public class AgendamentoService implements AgendamentoServiceIF, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private AgendamentoDao agendamentoDao;

    public AgendamentoService() {
    }
    
    @Transactional
    @Override
    public void save(Agendamento agendamento) {
        if (agendamento != null) {
            this.agendamentoDao.salvar(agendamento);
        }
    }

    @Transactional
    @Override
    public void delete(Agendamento agendamento) throws NegocioException {
        agendamentoDao.delete(findById(agendamento.getId()));
    }
    
    public Agendamento findById(Long id) {
        return agendamentoDao.findById(id);
    }
     
    @Override
    public List<Agendamento> findAll() {
        return agendamentoDao.findAll();
    }
    
}
