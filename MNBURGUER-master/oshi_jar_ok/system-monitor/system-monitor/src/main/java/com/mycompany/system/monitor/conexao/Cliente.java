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
public class Cliente {
    
    private Integer idCliente;
    private String Nome_cliente;
    private String Celular_cliente;
    private String Email_cliente;
    private String Senha_cliente;

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", Nome_cliente=" + Nome_cliente + ", Celular_cliente=" + Celular_cliente + ", Email_cliente=" + Email_cliente + ", Senha_cliente=" + Senha_cliente + '}';
    }    

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setNome_cliente(String Nome_cliente) {
        this.Nome_cliente = Nome_cliente;
    }

    public void setCelular_cliente(String Celular_cliente) {
        this.Celular_cliente = Celular_cliente;
    }

    public void setEmail_cliente(String Email_cliente) {
        this.Email_cliente = Email_cliente;
    }

    public void setSenha_cliente(String Senha_cliente) {
        this.Senha_cliente = Senha_cliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNome_cliente() {
        return Nome_cliente;
    }

    public String getCelular_cliente() {
        return Celular_cliente;
    }

    public String getEmail_cliente() {
        return Email_cliente;
    }

    public String getSenha_cliente() {
        return Senha_cliente;
    }
    
    
    
    
}
