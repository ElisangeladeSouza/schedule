package br.com.teste.schedule.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author elisangela
 */
@Entity
@Data
public class Paciente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;
    
    @Column(name = "paciente_nome", nullable = false, length = 100)
    private String nome;
    
    @OneToOne
    @JoinColumn(name = "agendamento_pk")
    private Agendamento agendamento;
    
}
