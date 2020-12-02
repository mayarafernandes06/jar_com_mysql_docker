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
public class Config_software {
    
    private Integer idConfig_software;
    private Integer Alerta;
    private Integer Componentes_idComponentes;
    private Integer Cadastro_Maquina_idCadastro_Maquina;

    @Override
    public String toString() {
        return "Config_software{" + "idConfig_software=" + idConfig_software + ", Alerta=" + Alerta + ", Componentes_idComponentes=" + Componentes_idComponentes + ", Cadastro_Maquina_idCadastro_Maquina=" + Cadastro_Maquina_idCadastro_Maquina + '}';
    }

    public Integer getIdConfig_software() {
        return idConfig_software;
    }

    public Integer getAlerta() {
        return Alerta;
    }

    public Integer getComponentes_idComponentes() {
        return Componentes_idComponentes;
    }

    public Integer getCadastro_Maquina_idCadastro_Maquina() {
        return Cadastro_Maquina_idCadastro_Maquina;
    }

    public void setIdConfig_software(Integer idConfig_software) {
        this.idConfig_software = idConfig_software;
    }

    public void setAlerta(Integer Alerta) {
        this.Alerta = Alerta;
    }

    public void setComponentes_idComponentes(Integer Componentes_idComponentes) {
        this.Componentes_idComponentes = Componentes_idComponentes;
    }

    public void setCadastro_Maquina_idCadastro_Maquina(Integer Cadastro_Maquina_idCadastro_Maquina) {
        this.Cadastro_Maquina_idCadastro_Maquina = Cadastro_Maquina_idCadastro_Maquina;
    }
    
    
    
}
