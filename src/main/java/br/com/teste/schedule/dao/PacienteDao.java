package br.com.teste.schedule.dao;

import br.com.teste.schedule.model.Paciente;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class PacienteDao extends DaoAbstract<Paciente> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public PacienteDao() {
        super(Paciente.class);
    }
    
}
