package br.com.teste.schedule.service.interfaces;

import br.com.teste.schedule.model.Agendamento;
import java.util.List;

/**
 *
 * @author elisangela
 */
public interface AgendamentoServiceIF {
    
    public List<Agendamento> findAll();
    
    public void save(Agendamento agendamento);
    
    public void delete(Agendamento agendamentoSelecionado);
}
