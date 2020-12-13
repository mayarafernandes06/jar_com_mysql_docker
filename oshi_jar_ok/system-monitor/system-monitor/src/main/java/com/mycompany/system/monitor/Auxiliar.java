/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.system.monitor;

/**
 *
 * @author Aluno
 */
public class Auxiliar {

    private Integer fk_restaurante;

    public Auxiliar(Integer fk_restaurante) {
        this.fk_restaurante = fk_restaurante;
    }

    public void setFk_restaurante(Integer fk_restaurante) {
        this.fk_restaurante = fk_restaurante;
    }

    public Integer getFk_restaurante() {
        return fk_restaurante;
    }
   
}
