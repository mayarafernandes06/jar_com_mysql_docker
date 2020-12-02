/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.system.monitor;

/**
 *
 * @author mayara
 */
public class Dado {

    private Integer idCliente;
    private String nome;
    private String celular_Cliente;
    private String email_Cliente;
    private String senha;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular_Cliente() {
        return celular_Cliente;
    }

    public void setCelular_Cliente(String celular_Cliente) {
        this.celular_Cliente = celular_Cliente;
    }

    public String getEmail_Cliente() {
        return email_Cliente;
    }

    public void setEmail_Cliente(String email_Cliente) {
        this.email_Cliente = email_Cliente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
