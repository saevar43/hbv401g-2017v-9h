/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Hotel;
import Model.Room;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * GUI class for a JDialog panel for a list of rooms.
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 */
public class RoomsListDialog extends javax.swing.JDialog {

    /**
     * Instance variables.
     */
    MainFrame mf = new MainFrame();
    DefaultListModel<String> roomsModel; // List model.
    Hotel hotelChosen; // Hotel containing rooms in list model.
    ArrayList<Room> roomsList; //List of rooms making up list model.
    /**
     * Creates new form RoomsListDialog
     */
    public RoomsListDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Create list model from list of rooms.
     * @param rooms - ArrayList of rooms.
     */
    public void createRoomsListModel(ArrayList<Room> rooms) {
        roomsModel = new DefaultListModel<>();
        
        for (int i = 0; i < rooms.size(); i++) {
            roomsModel.addElement("Room No. " + rooms.get(i).getRoomNo() 
                    + " - Type: " + rooms.get(i).getType()
                    + " - Price: $" + rooms.get(i).getPrice());
        }
        
        this.jRoomsList.setModel(roomsModel);
    }
    
    /**
     * Setter for window title.
     * @param title - title of window.
     */
    public void setTitleText(String title) {
        this.jTitleLabel.setText(title);
    }
    
    /**
     * Setter for instance variable hotelChosen.
     * @param hotelChosen - the chosen hotel. 
     */
    public void setHotelChosen(Hotel hotelChosen) {
        this.hotelChosen = hotelChosen;
    }
    
    /**
     * Getter for instance variable hotelChosen.
     * @return 
     */
    public Hotel getHotelChosen() {
        return hotelChosen;
    }
    
    /**
     * Setter for instance variable roomsList.
     * @param roomsList - ArrayList of rooms.
     */
    public void setRoomsList(ArrayList<Room> roomsList) {
        this.roomsList = roomsList;
    }
    
    /**
     * Getter for instance variable roomsList.
     * @return 
     */
    public ArrayList<Room> getRoomsList() {
        return roomsList;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBackButton = new javax.swing.JButton();
        jTitleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jRoomsList = new javax.swing.JList<>();
        jBookButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBackButton.setText("Back To Hotels");
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jTitleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jScrollPane1.setViewportView(jRoomsList);

        jBookButton.setText("Book Room");
        jBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBookButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBookButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBackButton))
                    .addComponent(jTitleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jBackButton)
                    .addComponent(jBookButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action handler for "Back" button.
     * @param evt - button clicked.
     */
    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBackButtonActionPerformed

    /**
     * Action handler for "Book Room" button.
     * @param evt - button clicked.
     */
    private void jBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBookButtonActionPerformed
        BookRoomDialog brd = new BookRoomDialog(mf, true);
        
        brd.setHotelChosen(hotelChosen);
        brd.setHotelText(hotelChosen.getName());
        brd.setRoomText("" + roomsList.get(jRoomsList.getSelectedIndex()).getRoomNo());
        
        brd.setVisible(true);
    }//GEN-LAST:event_jBookButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RoomsListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomsListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomsListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomsListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RoomsListDialog dialog = new RoomsListDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBackButton;
    private javax.swing.JButton jBookButton;
    private javax.swing.JList<String> jRoomsList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTitleLabel;
    // End of variables declaration//GEN-END:variables
}
