package rednit;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Register extends javax.swing.JFrame {

    AESEncryptDecrypt aes = new AESEncryptDecrypt();
    String secretKey = "friendZoned!!!";
    Connection con = null;
    PreparedStatement pep = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private double log = 0;
    private double lat = 0;
    String filename;
    InputStream is = null;
    
    public Register() {
        initComponents();
        
        //EVERY JFRAME SIZE
        setResizable(false);
        setPreferredSize(new Dimension(1000, 579));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //INSERT ABOVE CODE 
        
        
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
        btnLogin = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblFullname = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhonenumber = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblInterest = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblPostal = new javax.swing.JLabel();
        lblHobby = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        previewImage = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtGender = new javax.swing.JComboBox<>();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtPostal = new javax.swing.JTextField();
        boxInterest = new javax.swing.JComboBox<>();
        boxState = new javax.swing.JComboBox<>();
        boxHobby = new javax.swing.JComboBox<>();
        btnUpload = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnOR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 46, 60));
        setPreferredSize(new java.awt.Dimension(1000, 579));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpHeader.setBackground(new java.awt.Color(58, 57, 81));
        jpHeader.setPreferredSize(new java.awt.Dimension(219, 80));

        Rednit.setFont(new java.awt.Font("Raleway", 1, 48)); // NOI18N
        Rednit.setForeground(new java.awt.Color(196, 178, 188));
        Rednit.setText("REDNIT");

        btnLogin.setBackground(new java.awt.Color(196, 178, 188));
        btnLogin.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(51, 46, 60));
        btnLogin.setText("Back");
        btnLogin.setAlignmentX(1.0F);
        btnLogin.setAlignmentY(3.0F);
        btnLogin.setBorder(BorderFactory.createEmptyBorder());
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpHeaderLayout = new javax.swing.GroupLayout(jpHeader);
        jpHeader.setLayout(jpHeaderLayout);
        jpHeaderLayout.setHorizontalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Rednit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 668, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
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
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 80));

        jPanel1.setBackground(new java.awt.Color(51, 46, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 768));

        lblFullname.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblFullname.setForeground(new java.awt.Color(216, 212, 242));
        lblFullname.setText("Full Name*");

        lblState.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblState.setForeground(new java.awt.Color(216, 212, 242));
        lblState.setText("State*");

        lblEmail.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(216, 212, 242));
        lblEmail.setText("Email*");

        lblPhonenumber.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPhonenumber.setForeground(new java.awt.Color(216, 212, 242));
        lblPhonenumber.setText("Phone Number*");

        lblGender.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblGender.setForeground(new java.awt.Color(216, 212, 242));
        lblGender.setText("Gender*");

        lblInterest.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblInterest.setForeground(new java.awt.Color(216, 212, 242));
        lblInterest.setText("Interest in*");

        lblUsername.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(216, 212, 242));
        lblUsername.setText("Username*");

        lblPassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(216, 212, 242));
        lblPassword.setText("Password*");

        lblPostal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPostal.setForeground(new java.awt.Color(216, 212, 242));
        lblPostal.setText("Postal Address*");

        lblHobby.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblHobby.setForeground(new java.awt.Color(216, 212, 242));
        lblHobby.setText("Hobby*");

        lblImage.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblImage.setForeground(new java.awt.Color(216, 212, 242));
        lblImage.setText("Image");

        txtFullName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtPhoneNumber.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtGender.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        txtUsername.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtPostal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPostalActionPerformed(evt);
            }
        });

        boxInterest.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        boxInterest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        boxState.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        boxState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perlis", "Penang", "Kedah", "Kelantan", "Perak", "Terengganu", "Pahang", "Selangor", "N. Sembilan", "Melaka", "Johor", "Sarawak", "Sabah", "W.P. Putrajaya", "W.P. KL", "W.P. Labuan" }));
        boxState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxStateActionPerformed(evt);
            }
        });

        boxHobby.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sports", "Music", "Reading", "Travelling", "Gaming", "Socializing", "Dancing", "Painting", "Gardening" }));

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnRegister.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rednit/loginTinder.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnOr.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addGap(119, 119, 119)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblUsername)
                                .addGap(77, 77, 77)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPassword)
                                .addGap(81, 81, 81)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(btnUpload)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(previewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegister))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(boxState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(lblHobby)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(boxHobby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(363, 363, 363))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhonenumber)
                            .addComponent(lblGender)
                            .addComponent(lblInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxInterest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addComponent(lblPostal)
                                .addGap(18, 18, 18)
                                .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegister)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addComponent(lblFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(lblState))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(boxState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblHobby)
                                        .addComponent(boxHobby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(lblEmail))
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(lblPhonenumber)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblGender)
                                                .addGap(17, 17, 17)
                                                .addComponent(lblInterest))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(boxInterest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lblPostal))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(16, 16, 16)
                                                        .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(btnOR, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblPassword))
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImage)
                            .addComponent(previewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpload))))
                .addGap(268, 268, 268))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if(verify()){
            if(userAlreadyExist(txtUsername.getText()) == false){
                try{
                    String query = "INSERT INTO `data`(`id_name`, `id_state`, `id_email`, `id_phone`, `id_gender`, `id_interest`, `id_username`, `id_password`, `id_hobby`, `id_x`, `id_y`, `id_image`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                    con = DriverManager.getConnection("jdbc:mysql://192.168.64.2/dating?serverTimezone=UTC", "root","");
                    pep = con.prepareStatement(query);
                    pep.setString(1, txtFullName.getText());
                    pep.setString(2, boxState.getSelectedItem().toString());
                    pep.setString(3, txtEmail.getText());
                    pep.setString(4, txtPhoneNumber.getText());
                    pep.setString(5, txtGender.getSelectedItem().toString());
                    pep.setString(6, boxInterest.getSelectedItem().toString());
                    pep.setString(7, txtUsername.getText());
                    pep.setString(8, aes.encrypt(txtPassword.getText(), secretKey));
                    pep.setString(9, boxHobby.getSelectedItem().toString());
                    getLatLog(txtPostal.getText());
                    pep.setDouble(10, log);
                    pep.setDouble(11, lat);
                    InputStream is = new FileInputStream(new File(filename));
                    pep.setBlob(12,is);
                    
                    pep.execute();
                    pep.close();
                    
                    JOptionPane.showMessageDialog(null, "Successfully registered! You may login now :)");
                    dispose();
                    Login login = new Login();
                    login.setVisible(true);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);}
            }else{
                JOptionPane.showMessageDialog(null, "Username already exists");}
    }
       
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPostalActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","png");
         fileChooser.addChoosableFileFilter(filter);
         int result = fileChooser.showSaveDialog(null);
         if(result == JFileChooser.APPROVE_OPTION){
             File selectedFile = fileChooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
             filename = path;
             ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(previewImage.getWidth(),previewImage.getHeight(),Image.SCALE_SMOOTH));
             previewImage.setIcon(imageIcon);
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data");
         }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void boxStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxStateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxStateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        Adapter adp = new Adapter();
        adp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        new homepage().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }
    
    public boolean userAlreadyExist(String name){

        boolean userExist = false;
        try{
        String sql ="select id_username from data where id_username=?";
        con = DriverManager.getConnection("jdbc:mysql://192.168.64.2/dating?serverTimezone=UTC", "root","");
        ps = con.prepareStatement(sql);
        ps.setString(1, name);
        rs = ps.executeQuery();

        String tempName = ""; 

        if(rs.next()){
            tempName = rs.getString("id_username");
            if(tempName.equals(name)){
                userExist = true;
            }
            else{
                userExist = false;
            }
        } 
        ps.close();
        } catch (SQLException e){
            System.out.println("SQL Exception: "+ e.toString());
        }

        return userExist;
    }
    
    public boolean verify(){
        EmailValidator emailValidator = new EmailValidator();
        if(txtUsername.getText().equals("") || txtPassword.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill all the details.");
            return false;
        }
        else if(!(isInteger(txtPostal.getText())) || !(length(txtPostal.getText()))){
            JOptionPane.showMessageDialog(null, "Please enter the correct postal address");
            return false;
        }else if(!emailValidator.validate(txtEmail.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Please enter the correct email address");
            return false;
        }else{
            return true;
        }
    }
    
    public boolean isInteger(String s){
        try { 
        Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
        return false; 
        } catch(NullPointerException e) {
        return false;
        }
    
    return true;
    
    }
    
    public boolean length(String a){
        int l = a.length();
        if(l == 5){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void getLatLog(String postcode) throws MalformedURLException, IOException {
        postcode += ("%20Malaysia");

        URL open = new URL("https://api.opencagedata.com/geocode/v1/xml?q=" + postcode + "&key=b02b99c4258c48898ab9e5352953aa71&language=en&pretty=1");
        URLConnection c = open.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));

        String line;
        String[] arr1 = new String[1];
        String[] arr2 = new String[1];

        while ((line = reader.readLine()) != null) {
            if (line.equalsIgnoreCase("      <geometry>")) {
                line = reader.readLine();
                arr1 = line.replace(" ", "").split("<");
                line = reader.readLine();
                arr2 = line.replace(" ", "").split("<");
                break;
            }
        }
        reader.close();
        String result1 = "";
        String result2 = "";

        for (String s : arr1) {
            String[] a = s.split(">");

            for (String d : a) {
                result1 += (d + " ");
            }
        }

        for (String s : arr2) {
            String[] a = s.split(">");

            for (String d : a) {
                result2 += (d + " ");
            }
        }
        arr1 = result1.split(" ");
        arr2 = result2.split(" ");

        lat = Double.parseDouble(arr1[2]);
        log = Double.parseDouble(arr2[2]);
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rednit;
    private javax.swing.JComboBox<String> boxHobby;
    private javax.swing.JComboBox<String> boxInterest;
    private javax.swing.JComboBox<String> boxState;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel btnOR;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHobby;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInterest;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhonenumber;
    private javax.swing.JLabel lblPostal;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel previewImage;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JComboBox<String> txtGender;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPostal;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}


