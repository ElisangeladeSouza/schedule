package br.com.teste.schedule.services;

import br.com.teste.schedule.dao.DaoAbstract;
import br.com.teste.schedule.util.jpa.Transactional;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 * @param <T>
 */
public class DaoService<T> extends DaoAbstract<T> {
    
    public DaoAbstract getDao;
    
    /**
     * Faz uma consulta no banco de dados baseado em um valor passado como
     * parâmetro e retorna o resultado da consulta.
     * 
     * @param campo
     * @param valor
     * @return 
     */
    @Override
    @Transactional
    public T buscarPorCampo(String campo, Object valor) {
        return (T) getDao.buscarPorCampo(campo, valor);
    }
}
