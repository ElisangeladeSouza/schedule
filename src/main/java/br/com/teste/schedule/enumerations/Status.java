package br.com.teste.schedule.enumerations;

/**
 *
 * @author elisangela
 */
public enum Status {
    
    CANCELADO ("Cancelado"), 
    CONFIRMADO ("Confirmado");
    
    private final String descricao;

    private Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
