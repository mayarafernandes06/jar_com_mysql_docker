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
public class Cadastro_Maquina {
    
    private Integer idCadastro_Maquina;
    private String Nome_maquina;
    private String Hardware_maquina;
    private Integer Restaurante_idRestaurante;

    @Override
    public String toString() {
        return "Cadastro_Maquina{" + "idCadastro_Maquina=" + idCadastro_Maquina + ", Nome_maquina=" + Nome_maquina + ", Hardware_maquina=" + Hardware_maquina + ", Restaurante_idRestaurante=" + Restaurante_idRestaurante + '}';
    }

    public Integer getIdCadastro_Maquina() {
        return idCadastro_Maquina;
    }

    public String getNome_maquina() {
        return Nome_maquina;
    }

    public String getHardware_maquina() {
        return Hardware_maquina;
    }

    public Integer getRestaurante_idRestaurante() {
        return Restaurante_idRestaurante;
    }

    public void setIdCadastro_Maquina(Integer idCadastro_Maquina) {
        this.idCadastro_Maquina = idCadastro_Maquina;
    }

    public void setNome_maquina(String Nome_maquina) {
        this.Nome_maquina = Nome_maquina;
    }

    public void setHardware_maquina(String Hardware_maquina) {
        this.Hardware_maquina = Hardware_maquina;
    }

    public void setRestaurante_idRestaurante(Integer Restaurante_idRestaurante) {
        this.Restaurante_idRestaurante = Restaurante_idRestaurante;
    }
    
    
    
}
