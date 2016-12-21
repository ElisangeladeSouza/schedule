package br.com.teste.schedule.dao;

import br.com.teste.schedule.model.Agendamento;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class AgendamentoDao extends DaoAbstract<Agendamento> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public AgendamentoDao() {
        super(Agendamento.class);
    }
    
}
