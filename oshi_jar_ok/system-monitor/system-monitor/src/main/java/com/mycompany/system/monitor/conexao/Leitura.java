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
public class Leitura {
    
    private Integer idLeitura;
    //confirmar a variavel de datetime 
    private String Datahora;
    private Integer valor_leitura;
    private Integer Config_software_idConfig_software;

    @Override
    public String toString() {
        return "Leitura{" + "idLeitura=" + idLeitura + ", Datahora=" + Datahora + ", valor_leitura=" + valor_leitura + ", Config_software_idConfig_software=" + Config_software_idConfig_software + '}';
    }

    public Integer getIdLeitura() {
        return idLeitura;
    }

    public String getDatahora() {
        return Datahora;
    }

    public Integer getValor_leitura() {
        return valor_leitura;
    }

    public Integer getConfig_software_idConfig_software() {
        return Config_software_idConfig_software;
    }

    public void setIdLeitura(Integer idLeitura) {
        this.idLeitura = idLeitura;
    }

    public void setDatahora(String Datahora) {
        this.Datahora = Datahora;
    }

    public void setValor_leitura(Integer valor_leitura) {
        this.valor_leitura = valor_leitura;
    }

    public void setConfig_software_idConfig_software(Integer Config_software_idConfig_software) {
        this.Config_software_idConfig_software = Config_software_idConfig_software;
    }
    
    
}
