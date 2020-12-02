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
public class Usuario {
    
    private Integer idUsuario;
    private String Nome_usuario;
    private String Cargo_Usuario;
    //confirmar uso da chave estrangeira 
    private Integer Cliente_idCliente;

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", Nome_usuario=" + Nome_usuario + ", Cargo_Usuario=" + Cargo_Usuario + ", idCliente=" + Cliente_idCliente + '}';
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNome_usuario() {
        return Nome_usuario;
    }

    public String getCargo_Usuario() {
        return Cargo_Usuario;
    }

    public Integer getIdCliente() {
        return Cliente_idCliente;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNome_usuario(String Nome_usuario) {
        this.Nome_usuario = Nome_usuario;
    }

    public void setCargo_Usuario(String Cargo_Usuario) {
        this.Cargo_Usuario = Cargo_Usuario;
    }

    public void setIdCliente(Integer idCliente) {
        this.Cliente_idCliente = idCliente;
    }
    
    
}
