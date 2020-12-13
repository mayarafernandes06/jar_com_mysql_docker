/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.system.monitor.api;

import java.util.ArrayList;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author aluga.com
 */
public class Processos {
    //Atributo que possui os status da cpu
    CentralProcessor cpu;
     //Atributo que possui os status da memoria
    GlobalMemory memoria;
    
     HardwareAbstractionLayer disco;
    //Atributo que possui o software
    OperatingSystem os;
    
     public Processos() {
        cpu = new SystemInfo().getHardware().getProcessor();
        //Pegando informacoes de dentro do SystemInfo do Oshi atraves da Memoria
        memoria = new SystemInfo().getHardware().getMemory();
       
        disco = new SystemInfo().getHardware();
        
        os = new SystemInfo().getOperatingSystem();
     }
     
     public List[] processoLista() {
         List<OSProcess> procs = os.getProcesses(4, OperatingSystem.ProcessSort.CPU);
            //Aqui comecei a listar os processos atraves do atributo os com uma Lista

        //Aqui instansciei para criar a lista com 4 processos
        List arrayProcessos[] = new ArrayList[4];
        //Fiz um for para que ele pegasse o tamanho do do procs para ele listar 
        //Os quatros principais objetos
        for (int i = 0; i < procs.size() && i < 4; i++) {
           OSProcess actualProcess = procs.get(i);
          //Istanciei pois tem que ser um Array dentro de uma Lista
          // Pois assim, consigo criar uma matriz (Pois no java nao tem Json (eu acho))
         List listaProcesso = new ArrayList();
         //Criei uma variavel para que pudesse pegar os id do processo (PID), 
         //Usando o actualProcess
         Integer PID = actualProcess.getProcessID();
         listaProcesso.add(PID);
         //Aqui e a formula para poder saber o uso de CPU
         Double usoCPU = (100d * (actualProcess.getKernelTime() + actualProcess.getUserTime()) / actualProcess.getUpTime());
         listaProcesso.add(usoCPU);
         //Aqui e a formula para poder saber o uso de Memoria
         Double usoMemoria = (100d * actualProcess.getResidentSetSize() / memoria.getTotal());
         listaProcesso.add(usoMemoria);
         //Peguei o nome do processo e coloquei em uma variavel
         String PIDname = actualProcess.getName();
         listaProcesso.add(PIDname);
         //Aqui estou falando que a o arry e o listaProcesso, pois assim ele coloca na label sem dar erro
         //Pois a gente nao concatena os valores e sim substitui o valor da posicao
         //E caso nao tenha um valor, a gente so coloca 
         arrayProcessos[i] = listaProcesso;
         
        }
        //Aqui estou retornando o processo para a Dash funcionar
        return arrayProcessos;
     }
}
