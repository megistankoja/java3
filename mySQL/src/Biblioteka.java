
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author User
 */
public final class Biblioteka extends javax.swing.JFrame {

    String dbUsername = "root";
    String dbPassword = "";
    String dbServerUrl = "jdbc:mysql://localhost:3306/mysqlproject";
    String dbClassPathUrl = "com.mysql.cj.jdbc.Driver";
    String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String titulli = "";
    String autori = "";
    String faqet = "";
    String kategoria = "";
    String rafti = "";
    Connection connx;
    DefaultTableModel model;

    public Biblioteka() {
        initComponents();
        connx = databaseConnection();
        populateJTableFromMysqlDatabase();
    }

    public Connection databaseConnection() {
        Connection conn;
        try {
            Class.forName(dbClassPathUrl);
            //JOptionPane.showMessageDialog(null, "Driver Loaded!");
            conn = (Connection) DriverManager.getConnection(dbServerUrl + timeZone, dbUsername, dbPassword);
            //JOptionPane.showMessageDialog(null, "Connected!");
            return conn;
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return null;
    }

    //metoda per me rujt rezultatet Database ne nje ArrayList
    public ArrayList<Book> booksList() {
        ArrayList<Book> bookLists = new ArrayList<>();
        String selectAllSQLQuery = "SELECT * FROM `mysqlprojecttable`";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = connx.createStatement();
            rs = stmt.executeQuery(selectAllSQLQuery);

            while (rs.next()) {
                Book book = new Book();
                book.setTitulli(rs.getString("Titulli"));
                book.setAutori(rs.getString("Autori"));
                book.setFaqet(rs.getInt("Faqet"));
                book.setKategoria(rs.getString("Kategoria"));
                book.setRafti(rs.getString("Rafti"));
                bookLists.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Biblioteka.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookLists;

    }

    //mbushim tabelen me data nga database
    public void populateJTableFromMysqlDatabase() {
        ArrayList<Book> dataArray = booksList();
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] rows = new Object[5];

        for (int i = 0; i < dataArray.size(); i++) {
            rows[0] = dataArray.get(i).getTitulli();
            rows[1] = dataArray.get(i).getAutori();
            rows[2] = dataArray.get(i).getFaqet();
            rows[3] = dataArray.get(i).getKategoria();
            rows[4] = dataArray.get(i).getRafti();
            model.addRow(rows);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_titulli = new javax.swing.JTextField();
        txt_autori = new javax.swing.JTextField();
        int_faqet = new javax.swing.JTextField();
        button1 = new javax.swing.JRadioButton();
        button2 = new javax.swing.JRadioButton();
        button3 = new javax.swing.JRadioButton();
        box = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Parchment", 1, 48)); // NOI18N
        jLabel1.setText("Biblioteka");

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel2.setText("Titulli:");

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel3.setText("Autori:");

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel4.setText("Kategoria:");

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel5.setText("Rafti:");

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel6.setText("Faqet:");

        txt_titulli.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        txt_autori.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        int_faqet.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        buttonGroup1.add(button1);
        button1.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        button1.setText("per femije");

        buttonGroup1.add(button2);
        button2.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        button2.setText("per te rritur");

        buttonGroup1.add(button3);
        button3.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        button3.setText("per te gjithe");

        box.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        box.setBorder(null);
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jButton1.setText("Shto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jButton2.setText("Pastro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulli", "Autori", "Faqet", "Kategoria", "Rafti"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jButton4.setText("Fshi");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_autori, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(int_faqet, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button3))
                            .addComponent(txt_titulli)
                            .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_titulli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_autori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(int_faqet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1)
                    .addComponent(button2)
                    .addComponent(button3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed
      
    }//GEN-LAST:event_boxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //te dhenat shtohen ne tabele dhe gjithashtu ne database
        titulli = txt_titulli.getText();

        autori = txt_autori.getText();

        faqet = int_faqet.getText();

        if (button1.isSelected()) {
            kategoria = "per femije";
        } else if (button2.isSelected()) {
            kategoria = "per te rritur";
        } else if (button3.isSelected()) {
            kategoria = "per te gjithe";
        }

        rafti = box.getSelectedItem().toString();

        if (titulli.isEmpty() || autori.isEmpty() || faqet.isEmpty() || kategoria.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nuk keni plotesuar te gjitha vendet!!!");
        }
        try {
            String bookInsertSQLQuery = "INSERT INTO `mysqlprojecttable`(`Titulli`, `Autori`, `Faqet`, `Kategoria`, `Rafti`) VALUES (? , ? , ? , ? , ?)";
            PreparedStatement bookPST = this.connx.prepareStatement(bookInsertSQLQuery);
            bookPST.setString(1, titulli);
            bookPST.setString(2, autori);
            bookPST.setString(3, faqet);
            bookPST.setString(4, kategoria);
            bookPST.setString(5, rafti);
            int bookInserted = bookPST.executeUpdate();
            if (bookInserted > 0) {
                JOptionPane.showMessageDialog(null, "U krye me sukses!!!");
                clearAllInputFields();
                populateJTableFromMysqlDatabase();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Biblioteka.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // fshin nje te dhene nga tabela dhe gjithashtu nga databasa
        clearAllInputFields();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // kur klikojme ne tabele mbi te dhenen ajo do te plotsohet dhe tek vendet(text fields)
        int JTableSelectedRow = jTable1.getSelectedRow();

        txt_titulli.setText(booksList().get(JTableSelectedRow).getTitulli());
        txt_autori.setText(booksList().get(JTableSelectedRow).getAutori());
        int_faqet.setText(Integer.toString(booksList().get(JTableSelectedRow).getFaqet()));
        String kategoria = booksList().get(JTableSelectedRow).getKategoria();
        switch (kategoria) {
            case "per femije" ->
                button1.setSelected(true);
            case "per te rritur" ->
                button2.setSelected(true);
            case "per te gjithe" ->
                button3.setSelected(true);
            default -> {
            }
        }
        String rafti = booksList().get(JTableSelectedRow).getRafti();
        for (int i = 0; i < box.getItemCount(); i++) {
            if (box.getItemAt(i).equalsIgnoreCase(rafti)) {
                box.setSelectedIndex(i);
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //komanda per fshirjen e nje libri nga lista(nga tabela dhe nga MySQL database)
        if (txt_titulli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mungon titulli!!!");
        } else {
            Connection dbconnection = null;
            PreparedStatement pStatement = null;
            String deleteSQLQuery = "DELETE FROM `mysqlprojecttable` WHERE Titulli = ?";

            try {
                dbconnection = this.connx;
                pStatement = dbconnection.prepareStatement(deleteSQLQuery);
                pStatement.setString(1, txt_titulli.getText());
                int deleteSTMT = pStatement.executeUpdate();

                if (deleteSTMT > 0) {
                    JOptionPane.showMessageDialog(null, "Libri u fshi nga lista!!!");
                    //pstrimi i te dhenave ne jTextField
                    clearAllInputFields();
                    //printimi i listes se re ne tabele
                    populateJTableFromMysqlDatabase();
                }
            } catch (SQLException ex) {
            } finally {
                
                //mbyll lidhjen
                try {
                    if (pStatement != null) {
                        pStatement.close();
                    }
                    /*if (dbconnection != null) {
                    dbconnection.close();
                    }*/
                } catch (SQLException sQLException) {
                    sQLException.getMessage();
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Biblioteka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biblioteka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biblioteka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biblioteka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biblioteka().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box;
    private javax.swing.JRadioButton button1;
    private javax.swing.JRadioButton button2;
    private javax.swing.JRadioButton button3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField int_faqet;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_autori;
    private javax.swing.JTextField txt_titulli;
    // End of variables declaration//GEN-END:variables

    private void clearAllInputFields() {
        txt_titulli.setText(" ");
        txt_autori.setText(" ");
        int_faqet.setText(" ");
        buttonGroup1.clearSelection();
        box.setSelectedIndex(0);
    }
}
