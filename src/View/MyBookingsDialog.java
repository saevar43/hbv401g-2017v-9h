/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.BookingControl;
import Model.Booking;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 * GUI class for a JDialog panel for a list of bookings.
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 */
public class MyBookingsDialog extends javax.swing.JDialog {

    private MainFrame mf = new MainFrame();
    private String kt;
    private ArrayList<Booking> bookingsList;
    private DefaultListModel<String> bookingsModel;
    
    /**
     * Creates new form MyBookingsDialog
     */
    public MyBookingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setTitleText(String title) {
        jTitleLabel.setText(title);
    }
    
    public void createBookingsListModel(ArrayList<Booking> bookings) {
        bookingsModel = new DefaultListModel<>();
        
        for (int i = 0; i < bookings.size(); i++) {
            bookingsModel.addElement("" + bookings.get(i).getBookingId() + " " 
                    + bookings.get(i).getHotel().getName() + " " 
                    + bookings.get(i).getRoom().getRoomNo());
        }
        
        jBookingsList.setModel(bookingsModel);
    }
    
    public void setBookingsList(ArrayList<Booking> bookingsList) {
        this.bookingsList = bookingsList;
    }
    
    public void setKt(String kt) {
        this.kt = kt;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTitleLabel = new javax.swing.JLabel();
        jCloseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBookingsList = new javax.swing.JList<>();
        jCancelBookingButton = new javax.swing.JButton();
        jViewBookingButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTitleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jCloseButton.setText("Close");
        jCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCloseButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jBookingsList);

        jCancelBookingButton.setText("Cancel Booking");
        jCancelBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelBookingButtonActionPerformed(evt);
            }
        });

        jViewBookingButton.setText("View Booking");
        jViewBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jViewBookingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jViewBookingButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                                .addComponent(jCancelBookingButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCloseButton))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCloseButton)
                    .addComponent(jCancelBookingButton)
                    .addComponent(jViewBookingButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCloseButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jCloseButtonActionPerformed

    private void jCancelBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelBookingButtonActionPerformed
        BookingControl bc = new BookingControl();
        Booking booking = bc.getBookingById(bookingsList.get(jBookingsList.getSelectedIndex()).getBookingId());
        
        if (JOptionPane.showConfirmDialog(mf, "Are you sure you want to cancel this booking?", 
                "Cancel Booking", JOptionPane.YES_NO_OPTION) == 0) {
            bc.deleteBooking(booking.getBookingId());
        
            this.setBookingsList(bc.getBookingsByKt(kt));
            this.createBookingsListModel(bookingsList);
            jBookingsList.setModel(bookingsModel);
        }
    }//GEN-LAST:event_jCancelBookingButtonActionPerformed

    private void jViewBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewBookingButtonActionPerformed
        BookingControl bc = new BookingControl();
        Booking booking = bc.getBookingById(bookingsList.get(jBookingsList.getSelectedIndex()).getBookingId());
        
        ViewBookingDialog vbd = new ViewBookingDialog(mf,true);
        
        vbd.addBookingToView(booking);
        
        vbd.setVisible(true);
    }//GEN-LAST:event_jViewBookingButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MyBookingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyBookingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyBookingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyBookingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MyBookingsDialog dialog = new MyBookingsDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jBookingsList;
    private javax.swing.JButton jCancelBookingButton;
    private javax.swing.JButton jCloseButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTitleLabel;
    private javax.swing.JButton jViewBookingButton;
    // End of variables declaration//GEN-END:variables
}
