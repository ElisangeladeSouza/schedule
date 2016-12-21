package br.com.teste.schedule.converters;

import br.com.teste.exceptios.ScheduleException;
import br.com.teste.schedule.model.Agendamento;
import br.com.teste.schedule.services.AgendamentoService;
import br.com.teste.schedule.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = Agendamento.class)
public class AgendamentoConverter implements Converter {
    
    private final AgendamentoService agendamentoService;

    public AgendamentoConverter() throws ScheduleException {
        this.agendamentoService = CDIServiceLocator.getBean(AgendamentoService.class);
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Agendamento objectToReturn = null;
        
        if(value != null) {
            objectToReturn = this.agendamentoService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            Long code = ((Agendamento) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
