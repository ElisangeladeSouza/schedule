package br.com.teste.schedule.services;

import br.com.teste.exceptios.NegocioException;
import br.com.teste.schedule.dao.PacienteDao;
import br.com.teste.schedule.model.Paciente;
import br.com.teste.schedule.service.interfaces.PacienteServiceIF;
import br.com.teste.schedule.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
public class PacienteService implements PacienteServiceIF, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private PacienteDao pacienteDao;

    public PacienteService() {
    }
    
    @Transactional
    @Override
    public void save(Paciente paciente) {
        if (paciente != null) {
            this.pacienteDao.salvar(paciente);
        }
    }

    @Transactional
    @Override
    public void delete(Paciente paciente) throws NegocioException {
        pacienteDao.delete(findById(paciente.getId()));
    }
    
    public Paciente findById(Long id) {
        return pacienteDao.findById(id);
    }
     
    @Override
    public List<Paciente> findAll() {
        return pacienteDao.findAll();
    }
    
}
