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
public class Restaurante {
    
    private Integer idRestaurante;
    private String Nome_Restaurante;
    private String CNPJ;
    private String Rua;
    private String Numero_endereco;
    private Integer Cliente_idCliente;

    public Integer getIdRestaurante() {
        return idRestaurante;
    }

    public String getNome_Restaurante() {
        return Nome_Restaurante;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getRua() {
        return Rua;
    }

    public String getNumero_endereco() {
        return Numero_endereco;
    }

    public Integer getCliente_idCliente() {
        return Cliente_idCliente;
    }

    public void setIdRestaurante(Integer idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public void setNome_Restaurante(String Nome_Restaurante) {
        this.Nome_Restaurante = Nome_Restaurante;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public void setNumero_endereco(String Numero_endereco) {
        this.Numero_endereco = Numero_endereco;
    }

    public void setCliente_idCliente(Integer Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "idRestaurante=" + idRestaurante + ", Nome_Restaurante=" + Nome_Restaurante + ", CNPJ=" + CNPJ + ", Rua=" + Rua + ", Numero_endereco=" + Numero_endereco + ", Cliente_idCliente=" + Cliente_idCliente + '}';
    }
    
    
    
}
