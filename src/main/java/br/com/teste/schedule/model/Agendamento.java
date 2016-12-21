package br.com.teste.schedule.model;

import br.com.teste.schedule.enumerations.Status;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author elisangela
 */
@Entity
@Data
public class Agendamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "agendamento_data_hora_inicio", nullable = false)
    private Date dataHoraInicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "agendamento_data_hora_fim", nullable = false)
    private Date dataHoraFim;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "agendamento_status")
    private Status status;
    
    @Column(name = "agendamento_observacoes", length = 100)
    private String observacoes;
    
    @OneToOne
    @JoinColumn(name = "paciente_pk", nullable = false)
    private Paciente paciente;
    
}
