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
public class Maquina {

    private Integer idMaquina;
    private String Nome_maquina;
    private Integer fk_restaurante;

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public String getNome_maquina() {
        return Nome_maquina;
    }

    public Integer getFk_restaurante() {
        return fk_restaurante;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public void setNome_maquina(String Nome_maquina) {
        this.Nome_maquina = Nome_maquina;
    }

    public void setFk_restaurante(Integer fk_restaurante) {
        this.fk_restaurante = fk_restaurante;
    }

    @Override
    public String toString() {
        return idMaquina.toString();
    }


}