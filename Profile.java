package rednit;

import java.awt.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Profile extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String filename;
    byte[] fileBytes, image = null;
    JLabel label;
    Login a = new Login();
    String username = a.username1;
    String name = a.name1;
    String state = a.state1;
    String email = a.email1;
    String phone = a.phone1;
    String gender = a.gender1;
    String interest = a.interest1;
    String hobby = a.hobby1;
    public static double km = 100;

    
    public Profile() {
        initComponents();
        
        //EVERY JFRAME SIZE
        setResizable(false);
        setPreferredSize(new Dimension(1000, 579));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //INSERT ABOVE CODE 
        
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
        
        if(hobby==null){
            hobby = "No data recorded.";
        }
        
        lblState.setText(state);
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
        editPhoto = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        profilePicture = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblState1 = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblEmail2 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone2 = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblGender2 = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblInterest2 = new javax.swing.JLabel();
        lblInterest = new javax.swing.JLabel();
        lblHobby2 = new javax.swing.JLabel();
        lblHobby = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPassword = new javax.swing.JButton();
        jPassword1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 46, 60));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1000, 579));
        setPreferredSize(new java.awt.Dimension(1000, 579));
        setResizable(false);

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

        btnProfile.setBackground(new java.awt.Color(58, 57, 81));
        btnProfile.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(196, 178, 188));
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

        btnChat.setBackground(new java.awt.Color(196, 178, 188));
        btnChat.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnChat.setForeground(new java.awt.Color(51, 46, 60));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jImage.setBackground(new java.awt.Color(99, 91, 115));
        jImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editPhoto.setText("Edit Photo");
        editPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPhotoActionPerformed(evt);
            }
        });
        jImage.add(editPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 185, -1, -1));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jImage.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 214, -1, -1));
        jImage.add(profilePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 160));

        jPanel1.setBackground(new java.awt.Color(51, 46, 60));

        lblName.setBackground(new java.awt.Color(51, 46, 60));
        lblName.setFont(new java.awt.Font("Raleway", 1, 36)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 204, 204));
        lblName.setText(name.toUpperCase());

        lblState1.setBackground(new java.awt.Color(51, 46, 60));
        lblState1.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblState1.setForeground(new java.awt.Color(216, 212, 242));
        lblState1.setText("State:");

        lblState.setBackground(new java.awt.Color(51, 46, 60));
        lblState.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblState.setForeground(new java.awt.Color(216, 212, 242));
        lblState.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblEmail2.setBackground(new java.awt.Color(51, 46, 60));
        lblEmail2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblEmail2.setForeground(new java.awt.Color(216, 212, 242));
        lblEmail2.setText("Email:");

        lblEmail.setBackground(new java.awt.Color(51, 46, 60));
        lblEmail.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(216, 212, 242));
        lblEmail.setText(email);
        lblEmail.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblPhone2.setBackground(new java.awt.Color(51, 46, 60));
        lblPhone2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblPhone2.setForeground(new java.awt.Color(216, 212, 242));
        lblPhone2.setText("Phone:");

        lblPhone.setBackground(new java.awt.Color(51, 46, 60));
        lblPhone.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(216, 212, 242));
        lblPhone.setText(phone);
        lblPhone.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblGender2.setBackground(new java.awt.Color(51, 46, 60));
        lblGender2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblGender2.setForeground(new java.awt.Color(216, 212, 242));
        lblGender2.setText("Gender:");

        lblGender.setBackground(new java.awt.Color(51, 46, 60));
        lblGender.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblGender.setForeground(new java.awt.Color(216, 212, 242));
        lblGender.setText(gender);
        lblGender.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblInterest2.setBackground(new java.awt.Color(51, 46, 60));
        lblInterest2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblInterest2.setForeground(new java.awt.Color(216, 212, 242));
        lblInterest2.setText("Interest in:");

        lblInterest.setBackground(new java.awt.Color(51, 46, 60));
        lblInterest.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblInterest.setForeground(new java.awt.Color(216, 212, 242));
        lblInterest.setText(interest
        );
        lblInterest.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblHobby2.setBackground(new java.awt.Color(51, 46, 60));
        lblHobby2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblHobby2.setForeground(new java.awt.Color(216, 212, 242));
        lblHobby2.setText("Hobby:");

        lblHobby.setBackground(new java.awt.Color(51, 46, 60));
        lblHobby.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblHobby.setForeground(new java.awt.Color(216, 212, 242));
        lblHobby.setText(hobby
        );
        lblHobby.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButton1.setText("Edit Info");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPassword.setText("Edit Password");
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });

        jPassword1.setText("Edit Location");
        jPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassword1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 493, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(91, 91, 91))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblInterest2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHobby2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGender2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblState1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhone2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHobby, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblInterest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPassword)
                            .addComponent(jPassword1))
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName)
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblState1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPassword)
                        .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(lblEmail2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone)
                            .addComponent(lblPhone2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPassword1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(lblGender2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInterest)
                    .addComponent(lblInterest2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHobby)
                    .addComponent(lblHobby2))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        username = null;
        new homepage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void editPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPhotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","png");
         fileChooser.addChoosableFileFilter(filter);
         int result = fileChooser.showSaveDialog(null);
         if(result == JFileChooser.APPROVE_OPTION){
             File selectedFile = fileChooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
             filename = path;
              ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(profilePicture.getWidth(),profilePicture.getHeight(),Image.SCALE_SMOOTH));
              profilePicture.setIcon(imageIcon);
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data inserted.");
         }
    }//GEN-LAST:event_editPhotoActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
            String sql = "UPDATE data SET id_image=? WHERE id_username=" + "'" + username + "'" ;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.64.2/dating?serverTimezone=UTC", "root", "");
            ps = con.prepareStatement(sql);
            InputStream is = new FileInputStream(new File(filename));
            ps.setBlob(1,is);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Photo successfully updated");
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No file inserted.");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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

    }//GEN-LAST:event_btnProfileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new profileEdit().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        new passwordUpdate().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPasswordActionPerformed

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        new chatMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnChatActionPerformed

    private void jPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassword1ActionPerformed
        new locationUpdate().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPassword1ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rednit;
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMatch;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton editPhoto;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jPassword;
    private javax.swing.JButton jPassword1;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail2;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender2;
    private javax.swing.JLabel lblHobby;
    private javax.swing.JLabel lblHobby2;
    private javax.swing.JLabel lblInterest;
    private javax.swing.JLabel lblInterest2;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhone2;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblState1;
    private javax.swing.JLabel profilePicture;
    private javax.swing.JLabel welcomeNote;
    // End of variables declaration//GEN-END:variables
}
