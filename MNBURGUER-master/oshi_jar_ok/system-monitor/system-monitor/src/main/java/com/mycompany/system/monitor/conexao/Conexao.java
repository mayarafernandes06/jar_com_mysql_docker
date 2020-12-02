/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.system.monitor.conexao;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Aluno
 */



//classe criada para conexão com o banco
//depois, para usar essa conexao, basta instanciare o objeto na classe que queira
public class Conexao {
  
  //instanciando o objeto da classe BasicDataSource 
  BasicDataSource dataSource = new BasicDataSource();  
  
  public Conexao(){
      
      dataSource = new BasicDataSource();
      
      dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      
      dataSource.setUrl("jdbc:sqlserver://mnburger.database.windows.net:1433;database=bdmnBurger;user=adminlocal@mnburger;password=#Gfgrupo8;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
      
      dataSource.setUsername("adminlocal");
      
      dataSource.setPassword("#Gfgrupo8");
      
  }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
  
  
  
    
}
