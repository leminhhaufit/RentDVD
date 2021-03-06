/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;


import DAO.TaikhoanDAO;

import Entity.Taikhoan;

/**
 *
 * @author Minh Hau
 */
public class GDDangnhap extends javax.swing.JFrame {
	TaikhoanDAO tkdao = new TaikhoanDAO();

    /**
     * Creates new form GDDangnhap
     */
    public GDDangnhap() {
        initComponents();
       
        
        btnDangnhap.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				TaikhoanDAO tkdao = new TaikhoanDAO();
				String tendn= txtTendangnhap.getText();
				String mk = txtPassowrd.getText();
				
				/*
				 * NhanvienDAO nvdao = new NhanvienDAO();
				 * 
				 * Taikhoan tk = tkdao.getTaikhoanbyID(tendn);
				 * if(tendn.equalsIgnoreCase(tk.getTenDangnhap())&&
				 * mk.equalsIgnoreCase(tk.getMatkhau())) { List<Nhanvien> dsnv=
				 * nvdao.getNhanvienbyTendangnhap(tendn);
				 * if(dsnv.get(0).getQuyen().equalsIgnoreCase("Quanly")) {
				 * System.out.println(dsnv); JOptionPane.showMessageDialog(null,
				 * "Dang nhap thanh cong VOI QUYEN QUAN LY"); } else {
				 * JOptionPane.showMessageDialog(null,
				 * "Dang nhap thanh cong VOI QUYEN nhan vien"); }
				 * 
				 * 
				 * } else { JOptionPane.showMessageDialog(null, "Dang nhap khong thanh cong"); }
				 */
				Taikhoan tk = tkdao.getTaikhoanbyID(tendn);
				if(!(tendn.equalsIgnoreCase("") && mk.equalsIgnoreCase(""))) {
					if(tk.getMatkhau().equalsIgnoreCase(mk)) {
						if(tendn.equalsIgnoreCase("admin")) {
							Manager gdadmin = new Manager();
							GDDangnhap.this.setVisible(false);
							gdadmin.setVisible(true);
						}else {
							Clerk clerk = new Clerk();
							GDDangnhap.this.setVisible(false);
							clerk.setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(null, "M???t kh???u kh??ng ????ng!");
					}
						
					
				}else {
					JOptionPane.showMessageDialog(null, "T??n ????ng nh???p v?? m???t kh???u kh??ng ???????c ????? tr???ng!");
				}
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "T??n ????ng nh???p ho???c m???t kh???u kh??ng h???p l???");
				}
				
				
				
				
			}

			
		});
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        pnChinh = new javax.swing.JPanel();
        lbTieude = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbTendangnhap = new javax.swing.JLabel();
        txtTendangnhap = new javax.swing.JTextField();
        lbMatkhau = new javax.swing.JLabel();
        btnDangnhap = new javax.swing.JButton();
        txtPassowrd = new javax.swing.JPasswordField();
        setTitle("Ph???n m???m cho thu?? ????a");
     	//dat cua so giua man hinh
        setLocationRelativeTo(null);
        //khong cho phong to cua so
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnChinh.setMaximumSize(new java.awt.Dimension(1000, 800));
        pnChinh.setPreferredSize(new java.awt.Dimension(1000, 800));

        lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieude.setText("????NG NH???P");

        lbTendangnhap.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbTendangnhap.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbTendangnhap.setText("T??n ????ng nh???p:");

        txtTendangnhap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbMatkhau.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbMatkhau.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbMatkhau.setText("M???t kh???u:");

        btnDangnhap.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnDangnhap.setText("????ng nh???p");

        txtPassowrd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtPassowrd, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(btnDangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassowrd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addComponent(btnDangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
        pnChinh.setLayout(pnChinhLayout);
        pnChinhLayout.setHorizontalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTieude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        pnChinhLayout.setVerticalGroup(
            pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChinhLayout.createSequentialGroup()
                .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnChinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnChinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(GDDangnhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDDangnhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDDangnhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDDangnhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDDangnhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDangnhap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbMatkhau;
    private javax.swing.JLabel lbTendangnhap;
    private javax.swing.JLabel lbTieude;
    private javax.swing.JPanel pnChinh;
    private javax.swing.JPasswordField txtPassowrd;
    private javax.swing.JTextField txtTendangnhap;
    // End of variables declaration                   
}
