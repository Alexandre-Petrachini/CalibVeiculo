/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calibragemveiculo;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class Veiculo extends javax.swing.JFrame {

    Connection conec = null;
    Statement st = null; 
  ResultSet rs = null;
    ResultSet rs2 = null;
    int iniciando = 1;
   
    public Veiculo() {
        initComponents();
    Conectar();
   
    ColocarMarca();
    iniciando = 0;
     EscolherMarca();
     
    }
    
    
    
    public void ColocarMarca(){
      try{
                 CMarca.removeAllItems();
             rs = st.executeQuery("select * from VEICULOS group BY MARCA");
           
                
             
             
        while (rs.next()) {
            String pat = rs.getString("MARCA");
                    CMarca.addItem(pat);
        }
             }
             catch(SQLException e){
                 System.out.println(""+e);
                 System.out.println(""+st);
                 System.out.println(""+rs);
                 }
         
    }
    
    
    public void EscolherMarca(){
      try{
             
            CCarro.removeAllItems();
             
             rs2 = st.executeQuery("select VEICULO from VEICULOS where MARCA ='"+CMarca.getSelectedItem()+"'");
             
             while(rs2.next()){
             String pat2 = rs2.getString("VEICULO");
             CCarro.addItem(pat2);
             
             
             }
             }catch(SQLException e){
                 System.out.println(""+e);}
        
    }
    
    
    
    
    
    
    public void Conectar(){
    
        try {
             
            conec = DriverManager.getConnection("jdbc:sqlite:BancoVeiculo.db");
           
            st = conec.createStatement();
            st.setQueryTimeout(30);
            
            System.out.println("Sucesso");
    
    
    }
     catch(SQLException e)
        {
          // if the error message is "out of memory", 
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
    }      
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
       
    }

    return new DefaultTableModel(data, columnNames);

}
    
    
    
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CMarca = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PesquisaMarca = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CCarro = new javax.swing.JComboBox();
        PesquisaCarro = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CMarca.setToolTipText("Escolha um Veículo..");
        CMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CMarcaItemStateChanged(evt);
            }
        });
        CMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMarcaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calibragemveiculo/car-compact.png"))); // NOI18N
        jLabel1.setText(" Tabela de Veículos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Escolha uma Marca:");

        PesquisaMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PesquisaMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calibragemveiculo/search (1).png"))); // NOI18N
        PesquisaMarca.setText("Pesquisar por Marca");
        PesquisaMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PesquisaMarca.setFocusable(false);
        PesquisaMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisaMarcaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Escolha um carro:");

        CCarro.setToolTipText("Escolha um Veículo..");
        CCarro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCarroActionPerformed(evt);
            }
        });

        PesquisaCarro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PesquisaCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calibragemveiculo/search (1).png"))); // NOI18N
        PesquisaCarro.setText("Pesquisar por Carro");
        PesquisaCarro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PesquisaCarro.setFocusable(false);
        PesquisaCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisaCarroActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calibragemveiculo/left-arrow.png"))); // NOI18N
        jButton1.setText("Voltar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(PesquisaMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(PesquisaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PesquisaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesquisaMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMarcaActionPerformed

        if(iniciando!=1) {
            EscolherMarca();
        }

    
    }//GEN-LAST:event_CMarcaActionPerformed

    private void PesquisaMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisaMarcaActionPerformed
                     
try{
                 String sql = "select * from VEICULOS where MARCA ='"+CMarca.getSelectedItem()+"'";
                  System.out.println(""+sql);
                ResultSet rs = st.executeQuery(sql);
                 System.out.println(""+rs);
                
                JTable table = new JTable(buildTableModel(rs));             
                
                

                JScrollPane scroll = new JScrollPane(table);
                scroll.setPreferredSize(new Dimension(750,750));
                
                
    // Closes the Connection


    JOptionPane.showMessageDialog(null,scroll);



  

                
                
             }catch(SQLException e){
                 System.out.println(""+e);
             }  
        
        
    }//GEN-LAST:event_PesquisaMarcaActionPerformed

    private void CCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCarroActionPerformed
 
    }//GEN-LAST:event_CCarroActionPerformed

    private void PesquisaCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisaCarroActionPerformed
try{
                 String sql = "select * from VEICULOS where MARCA ='"+CMarca.getSelectedItem()+"'and VEICULO ='"+CCarro.getSelectedItem()+"'";
                  System.out.println(""+sql);
                ResultSet rs = st.executeQuery(sql);
               
                   Tabela x = new Tabela();
                while (rs.next()){
             
                x.setVisible(true);
                x.label1.setText(rs.getString("MARCA"));
                 x.label2.setText(rs.getString("VEICULO"));
                  x.label3.setText(rs.getString("CAMBDIANTMIN"));
                   x.label4.setText(rs.getString("CAMBDIANTMAX"));
                    x.label5.setText(rs.getString("CASTMIN"));
                     x.label6.setText(rs.getString("CASTMAX"));
                      x.label7.setText(rs.getString("ALIN.DIANTEIROMIN."));
                       x.label8.setText(rs.getString("ALIN.DIANTEIROMAX."));
                        x.label9.setText(rs.getString("CAMB.TRASEIROMIN."));
                         x.label10.setText(rs.getString("CAMB.TRASEIROMAX."));
                          x.label11.setText(rs.getString("ALIN.TRASEIROMIN."));
                           x.label12.setText(rs.getString("ALIN.TRASEIROMAX."));
                     
                
              
                        
                
                
                
                
                }


  

                
                
             }catch(SQLException e){
                 System.out.println(""+e);
             }  
                           // TODO add your handling code here:
    }//GEN-LAST:event_PesquisaCarroActionPerformed

    private void CMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CMarcaItemStateChanged

            
             
            
  // TODO add your handling code here:
    }//GEN-LAST:event_CMarcaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 Menu z = new Menu();
 z.setVisible(true);
 this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


            
            
       
            
    public static void main(String args[]) {
      
    
        
        
        
        
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Veiculo().setVisible(true);
   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CCarro;
    private javax.swing.JComboBox CMarca;
    private javax.swing.JButton PesquisaCarro;
    private javax.swing.JButton PesquisaMarca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
