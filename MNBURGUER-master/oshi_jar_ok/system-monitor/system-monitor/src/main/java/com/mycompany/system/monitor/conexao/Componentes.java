/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.system.monitor.conexao;

/**
 *
 * @author Aluno
 */
public class Componentes {
    
    private Integer idComponentes;
    private String Nome_componentes;
    private String Metrica;

    @Override
    public String toString() {
        return "Componentes{" + "idComponentes=" + idComponentes + ", Nome_componentes=" + Nome_componentes + ", Metrica=" + Metrica + '}';
    }

    public Integer getIdComponentes() {
        return idComponentes;
    }

    public String getNome_componentes() {
        return Nome_componentes;
    }

    public String getMetrica() {
        return Metrica;
    }

    public void setIdComponentes(Integer idComponentes) {
        this.idComponentes = idComponentes;
    }

    public void setNome_componentes(String Nome_componentes) {
        this.Nome_componentes = Nome_componentes;
    }

    public void setMetrica(String Metrica) {
        this.Metrica = Metrica;
    }
    
    
}
