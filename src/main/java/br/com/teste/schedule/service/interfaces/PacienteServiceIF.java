package br.com.teste.schedule.service.interfaces;

import br.com.teste.schedule.model.Paciente;
import java.util.List;

/**
 *
 * @author elisangela
 */
public interface PacienteServiceIF {
    
    public List<Paciente> findAll();
    
    public void save(Paciente paciente);
    
    public void delete(Paciente pacienteSelecionado);
    
}
