package br.com.teste.schedule.converters;

import br.com.teste.exceptios.ScheduleException;
import br.com.teste.schedule.model.Paciente;
import br.com.teste.schedule.services.PacienteService;
import br.com.teste.schedule.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = Paciente.class)
public class PacienteConverter implements Converter {
    
    private final PacienteService pacienteService;

    public PacienteConverter() throws ScheduleException {
        this.pacienteService = CDIServiceLocator.getBean(PacienteService.class);
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Paciente objectToReturn = null;
        
        if(value != null) {
            objectToReturn = this.pacienteService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            Long code = ((Paciente) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
