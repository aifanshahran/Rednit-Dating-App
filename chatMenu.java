package rednit;

import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class chatMenu extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String filename;
    byte[] fileBytes, image = null;
    JLabel label;
    Login a = new Login();
    String username = a.username1;
    public static double km = 100;
    public static String receiver;

    
    public chatMenu() {
        initComponents();
        
        //EVERY JFRAME SIZE
        setResizable(false);
        setPreferredSize(new Dimension(1000, 579));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //INSERT ABOVE CODE 
        
        loadChatHistory();
        
        //RETRIEVE DATABASE
        String sql = "select * from data where id_username=" + "'" + username + "'" ;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.64.2/dating?serverTimezone=UTC", "root", "");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //DATA INFO SAVE IN VARIABLE
                image = rs.getBytes("id_image");
                if(image!=null){
                    //Display Image
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(profilePicture.getWidth(),profilePicture.getHeight(),Image.SCALE_SMOOTH));
                    profilePicture.setIcon(imageIcon);
                }else{
                    //Display Image for null data
                    ImageIcon imageIcon =new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("default.jpg")).getScaledInstance(profilePicture.getWidth(),profilePicture.getHeight(),Image.SCALE_SMOOTH));
                    profilePicture.setIcon(imageIcon);} 
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    
    public void loadChatHistory(){
        try{
            ArrayList<String> name = new ArrayList<>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            
            ResultSet result = st.executeQuery("SELECT * FROM message");
            int same =0;
            while(result.next()){
  
                String sender= result.getString("id_user");
                String receiver= result.getString("id_receiver");
               if(result.getString("id_receiver").equals(username)){
                   name.add(sender);
                   if(same>0 && name.get(same-1).equals(name.get(same))){
                       name.remove(same);
                   }
                   else{
                     boxList.addItem(name.get(same));
                     same++;
                   }
                   
               }
               if(result.getString("id_user").equals(username)){
                   name.add(receiver);
                   if(same>0 && name.get(same-1).equals(name.get(same))){
                       name.remove(same);
                   }
                   else{
                     boxList.addItem(name.get(same));
                     same++;
                   }
                   
               }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }
    public Connection getConnection() {
        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2:3306/dating?serverTimezone=UTC", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(historyChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHeader = new javax.swing.JPanel();
        Rednit = new javax.swing.JLabel();
        welcomeNote = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnMatch = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnChat = new javax.swing.JButton();
        jImage = new javax.swing.JPanel();
        profilePicture = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        boxList = new javax.swing.JComboBox<>();
        chat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 46, 60));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1000, 579));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpHeader.setBackground(new java.awt.Color(58, 57, 81));
        jpHeader.setPreferredSize(new java.awt.Dimension(219, 80));

        Rednit.setFont(new java.awt.Font("Raleway", 1, 48)); // NOI18N
        Rednit.setForeground(new java.awt.Color(196, 178, 188));
        Rednit.setText("REDNIT");

        welcomeNote.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        welcomeNote.setForeground(new java.awt.Color(204, 204, 255));
        welcomeNote.setText("Welcome, " + username + "!");

        btnLogout.setBackground(new java.awt.Color(196, 178, 188));
        btnLogout.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(51, 46, 60));
        btnLogout.setText("Logout");
        btnLogout.setAlignmentX(1.0F);
        btnLogout.setAlignmentY(3.0F);
        btnLogout.setBorder(null);
        btnLogout.setBorderPainted(false);
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnMatch.setBackground(new java.awt.Color(196, 178, 188));
        btnMatch.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnMatch.setForeground(new java.awt.Color(51, 46, 60));
        btnMatch.setText("Match");
        btnMatch.setAlignmentX(1.0F);
        btnMatch.setAlignmentY(3.0F);
        btnMatch.setBorder(null);
        btnMatch.setBorderPainted(false);
        btnMatch.setFocusPainted(false);
        btnMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchActionPerformed(evt);
            }
        });

        btnProfile.setBackground(new java.awt.Color(196, 178, 188));
        btnProfile.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(51, 46, 60));
        btnProfile.setText("Profile");
        btnProfile.setAlignmentX(1.0F);
        btnProfile.setAlignmentY(3.0F);
        btnProfile.setBorder(null);
        btnProfile.setBorderPainted(false);
        btnProfile.setFocusPainted(false);
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnChat.setBackground(new java.awt.Color(58, 57, 81));
        btnChat.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnChat.setForeground(new java.awt.Color(196, 178, 188));
        btnChat.setText("Chat");
        btnChat.setAlignmentX(1.0F);
        btnChat.setAlignmentY(3.0F);
        btnChat.setBorder(null);
        btnChat.setBorderPainted(false);
        btnChat.setFocusPainted(false);
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpHeaderLayout = new javax.swing.GroupLayout(jpHeader);
        jpHeader.setLayout(jpHeaderLayout);
        jpHeaderLayout.setHorizontalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Rednit)
                .addGap(188, 188, 188)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(welcomeNote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpHeaderLayout.setVerticalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Rednit))
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(welcomeNote)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        jImage.setBackground(new java.awt.Color(99, 91, 115));
        jImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jImage.add(profilePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 160));

        getContentPane().add(jImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 224, 499));

        jPanel1.setBackground(new java.awt.Color(51, 46, 60));

        jLabel1.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHAT HISTORY");

        boxList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        boxList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxListActionPerformed(evt);
            }
        });

        chat.setBackground(new java.awt.Color(196, 178, 188));
        chat.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        chat.setForeground(new java.awt.Color(51, 46, 60));
        chat.setText("START CHATTING");
        chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxList, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(chat)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxList, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 80, 776, 499));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        username = null;
        new homepage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "The radius for matching is set within 100km. Do you want to change?", "Radius", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
               String answer = JOptionPane.showInputDialog("Insert your radius");
               km = Double.parseDouble(answer);
            } else {
                km = 100;
            }
        new NearByUser().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMatchActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
         new Profile().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChatActionPerformed

    private void boxListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxListActionPerformed

    private void chatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatActionPerformed
        // chat button
        receiver = boxList.getSelectedItem().toString();
        ChatFromMenu obj1 = new ChatFromMenu();
        obj1.setVisible(true);
    }//GEN-LAST:event_chatActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(chatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chatMenu().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rednit;
    private javax.swing.JComboBox<String> boxList;
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMatch;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton chat;
    private javax.swing.JPanel jImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JLabel profilePicture;
    private javax.swing.JLabel welcomeNote;
    // End of variables declaration//GEN-END:variables
}
