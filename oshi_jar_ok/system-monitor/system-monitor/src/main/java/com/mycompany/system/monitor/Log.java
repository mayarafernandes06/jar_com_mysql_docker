/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.system.monitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rene
 */
public class Log {

    public void textolog(String texto) throws IOException {
        File arquivo = new File("./MNBurguer Logger.txt");
        FileWriter arq = new FileWriter(arquivo, true);
        try {
            // Criando variaveis para "Data e Hora"
            Integer getDia = LocalDateTime.now().getDayOfMonth();
            Integer getMes = LocalDateTime.now().getMonthValue();
            Integer getAno = LocalDateTime.now().getYear();
            Integer getHora = LocalDateTime.now().getHour();
            Integer getMinuto = LocalDateTime.now().getMinute();
            Integer getSegundo = LocalDateTime.now().getSecond();
            String hora = getHora.toString();
            if (getHora < 10) {
                hora = String.format("0%d", getHora);
            }
            String minuto = getMinuto.toString();
            if (getMinuto < 10) {
                minuto = String.format("0%d", getMinuto);
            }
            String segundo = getSegundo.toString();
            if (getSegundo < 10) {
                segundo = String.format("0%d", getSegundo);
            }

            BufferedWriter bw = new BufferedWriter(arq);

            if (!arquivo.exists()) {
                arquivo.createNewFile();
                bw.write("MNBurguer logger");
            }

            bw.newLine();
            bw.write("error: " + texto + " " + getDia + "/" + getMes + "/" + getAno + " " + hora + ":" + minuto + ":" + segundo);
            bw.close();
            arq.close();

        } catch (IOException ex) {
            Logger.getLogger(LoginJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("ERRORR: " + texto);
    }

}
