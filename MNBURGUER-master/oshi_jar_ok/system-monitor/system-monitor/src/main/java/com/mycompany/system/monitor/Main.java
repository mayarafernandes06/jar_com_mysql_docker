package com.mycompany.system.monitor;

import com.mycompany.system.monitor.api.CPU;
import com.mycompany.system.monitor.api.Disk;
import com.mycompany.system.monitor.api.RAM;
import com.mycompany.system.monitor.conexao.Conexao;
import com.mycompany.system.monitor.conexao.Maquina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main extends javax.swing.JFrame {

    private CPU cpu = new CPU();
    private RAM ram = new RAM();
    private Disk disk = new Disk();
    //variavel de tempo da task
    private java.util.Timer mTimer = new java.util.Timer();
    Integer fkm;

    /**
     * Creates new form Tela
     */
    
   
   
    public Main(Integer fkr) {
        initComponents();

        Conexao config = new Conexao();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        JdbcTemplate template = new JdbcTemplate(con.getDataSource());

        // pnlDisks.add(new JLabel("asdf"));
        // pnlDisks.revalidate();
        //tarefa tempo para ser executada no determinado tempo
        TimerTask inserir = new TimerTask() {

            @Override
            public void run() {

                String CpuPorcentagemUso = cpu.getCurrentPercent().toString();
                String CpuMax = cpu.getFrequency().toString();
                String CpuMed = cpu.getCurrentFrequency().toString();
                String RamUso = ram.getUsedMemory().toString();
                String RamDisponivel = ram.getAvailableMemory().toString();
                String RamPorcentagemUso = ram.getCurrentPercent().toString();
                String discoTotal = disk.getDiskSize(0).toString();
                String discoDisponi = disk.getFreeSize(0).toString();
                String DiscoPorcentagemUso = disk.getDiskPercent(0).toString();

                String insertStatement = "select idMaquina from Maquina where fk_restaurante = ?";
                List<Maquina> lista = con.query(insertStatement, new BeanPropertyRowMapper(Maquina.class), fkr);

                for (Maquina m : lista) {
                    fkm = m.getIdMaquina();
                }

                template.update("insert into Leitura values(?,?,?,?,?);",
                        CpuPorcentagemUso, RamPorcentagemUso, DiscoPorcentagemUso, LocalDateTime.now(), fkm);

                //inserindo 
                List resultados = template.queryForList("SELECT * FROM Maquina");
                for (Object resultado : resultados) {
                    System.out.println(resultado);
                }

            }
        };
        
         // Conexão com o slack
         CPU cpu = new CPU();
         
       Double CpuPorcentagemUsoSlack = cpu.getCurrentPercent();
        
       if(CpuPorcentagemUsoSlack >= 80.0){
           Message slackMessage = Message
                .builder()
                .text("Atenção! Porcentagem alta de CPU")
                .build();

        SendMessage.sendMessage(slackMessage);

       } else{
           Message slackMessage = Message
                .builder()
                .text("CPU ok!")
                .build();

        SendMessage.sendMessage(slackMessage);
       }
       if(CpuPorcentagemUsoSlack == 2){
           Message slackMessage = Message
                .builder()
                .text("Testando valor 2")
                .build();

        SendMessage.sendMessage(slackMessage);

       }
        

        mTimer.scheduleAtFixedRate(inserir, 5000, 5000); // iserir acada 5 segundos
        /**
         * codigo para poder personalizar a barra de progresso fonte externa
         */
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //cria uma ação, e essa ação escreve na tela
        ActionListener action = (ActionEvent actionEvent) -> {
            lblCPU.setText(String.format("%.2fGhz", cpu.getCurrentFrequency()));
            lblCPU1.setText(String.format("%.2fGhz", cpu.getFrequency()));
            lblCPUPercent.setText(String.format("%.1f%%", cpu.getCurrentPercent()));

            lblRAM.setText(String.format("%.2fGB", ram.getUsedMemory()));
            lblRAM1.setText(String.format("%.2fGB", ram.getAvailableMemory()));
            lblRAMPercent.setText(String.format("%.1f%%", ram.getCurrentPercent()));

            lblNameDisk0.setText(disk.getName(0));
            lblTotalSpaceDisk0.setText(String.format("%.2fGB", disk.getDiskSize(0)));
            lblFreeSpaceDisk0.setText(String.format("%.2fGB", disk.getFreeSize(0)));
            pgbUsageDisk0.setValue(disk.getDiskPercent(0));

            //é aqui que faço os inserts na tela dos dados captados
        };

        //timer de execução da ação de jogar na tela
        Timer timer = new Timer(1000, action);

        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCPU2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblCPU3 = new javax.swing.JLabel();
        lblCPUPercent1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnInfo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCPU = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblCPU1 = new javax.swing.JLabel();
        lblCPUPercent = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblRAMPercent = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblRAM = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblRAM1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblNameDisk0 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalSpaceDisk0 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblFreeSpaceDisk0 = new javax.swing.JLabel();
        pgbUsageDisk0 = new javax.swing.JProgressBar();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setText("CPU");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Média");

        lblCPU2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblCPU2.setText("0,00 GHz");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Máximo");

        lblCPU3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblCPU3.setText("0,00 GHz");

        lblCPUPercent1.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lblCPUPercent1.setText("100.0%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCPU3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(lblCPU2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(lblCPUPercent1)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblCPU2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addComponent(lblCPUPercent1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPU3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MNBURGUER");
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInfo.setBackground(new java.awt.Color(255, 51, 0));
        btnInfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnInfo.setText("System Info");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        jPanel1.add(btnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, -1, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("CPU");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Media");

        lblCPU.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblCPU.setText("0,00 GHz");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Maximo");

        lblCPU1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblCPU1.setText("0,00 GHz");

        lblCPUPercent.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lblCPUPercent.setText("100.0%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCPU1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jLabel1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCPU)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(lblCPUPercent)
                        .addGap(34, 34, 34))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCPU)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel15))
                    .addComponent(lblCPUPercent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCPU1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 340, 210));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("RAM");

        lblRAMPercent.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lblRAMPercent.setText("100.0%");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Uso");

        lblRAM.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblRAM.setText("0.00 GB");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Disponivel");

        lblRAM1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblRAM1.setText("0.00 GB");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRAM)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(lblRAM1))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRAMPercent)
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblRAM)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblRAMPercent))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRAM1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 210));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("DISKS");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Nome:");

        lblNameDisk0.setText(":");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Total space:");

        lblTotalSpaceDisk0.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Free space:");

        lblFreeSpaceDisk0.setText("0");

        pgbUsageDisk0.setBackground(new java.awt.Color(255, 255, 255));
        pgbUsageDisk0.setForeground(new java.awt.Color(204, 51, 0));
        pgbUsageDisk0.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(lblNameDisk0, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(31, 31, 31)
                                    .addComponent(lblFreeSpaceDisk0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblTotalSpaceDisk0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pgbUsageDisk0, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel4)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblNameDisk0))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTotalSpaceDisk0))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblFreeSpaceDisk0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(pgbUsageDisk0, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 360, 230));

        jSeparator4.setForeground(new java.awt.Color(204, 51, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 327, 10));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel9.setText("MNBURGUER");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 860, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        JFrame frame = new JFrame();
        frame.setContentPane(new Info());
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_btnInfoActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("GTK+".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Main.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Main.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Main.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Main.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    //java.awt.EventQueue.invokeLater(new Runnable() {
    //public void run() {
    //new Main().setVisible(true);
    //}
    //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblCPU;
    private javax.swing.JLabel lblCPU1;
    private javax.swing.JLabel lblCPU2;
    private javax.swing.JLabel lblCPU3;
    private javax.swing.JLabel lblCPUPercent;
    private javax.swing.JLabel lblCPUPercent1;
    private javax.swing.JLabel lblFreeSpaceDisk0;
    private javax.swing.JLabel lblNameDisk0;
    private javax.swing.JLabel lblRAM;
    private javax.swing.JLabel lblRAM1;
    private javax.swing.JLabel lblRAMPercent;
    private javax.swing.JLabel lblTotalSpaceDisk0;
    private javax.swing.JProgressBar pgbUsageDisk0;
    // End of variables declaration//GEN-END:variables
}
